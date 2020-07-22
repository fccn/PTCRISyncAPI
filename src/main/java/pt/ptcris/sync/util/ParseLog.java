package pt.ptcris.sync.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unix4j.Unix4j;
import org.unix4j.unix.Grep;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import io.swagger.api.impl.OrcidApiServiceImpl;
import pt.ptcris.sync.progress.ProgressStatus;
import pt.ptcris.sync.progress.ProgressStatusList;
import pt.ptcris.sync.progress.StatusRecords;
import pt.ptcris.sync.progress.StatusRecordsList;

public class ParseLog {
	public static final String progressMethodName = "ProgressStatus";
	private static final Logger _log = LoggerFactory.getLogger(OrcidApiServiceImpl.class);
	private static final Properties properties = PropertiesLoader.getInstance().getProperties();
	private static final String logFile = properties.getProperty("logback.log.file");

	public static String getOrcidProgressStatus(String orcid) {
		String orcidExpression = Utils.formatOrcid(orcid);
		String escapedOrcidExpression = Utils.escapeDelimiter(orcidExpression);

		String result = "";

		List<String> resultList = Unix4j.grep(Grep.Options.i, escapedOrcidExpression, logFile).grep(progressMethodName)
				.toStringList();

		ProgressStatusList pgStatusList = new ProgressStatusList();
		for (String line : resultList) {
			ParseLogStatusMethod parsedLog = new ParseLogStatusMethod(line);
			pgStatusList.add(parsedLog.progressStatus);
		}

		ObjectMapper mapper = new ObjectMapper();
		// Object to JSON in file
		try {
			if (!pgStatusList.isEmpty()) {
				result = mapper.writeValueAsString(pgStatusList);
			}
		} catch (JsonProcessingException e) {
			_log.error(e.getMessage());
		}

		return result;
	}

	static private class ParseLogLine {
		public String date;
		public String time;
		public String mode;
		public String thread;
		public String fileName;
		public String lineNumber;
		public String message;

		private static final String pattern = "(.*)\\s(.*)\\s(.*)\\s\\[(.*)\\]\\s(.*\\..*)\\:(\\d+)\\s(\\\".*\\\")";

		public ParseLogLine(String line) {
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(line);

			while (m.find()) {
				this.date = m.group(1);
				this.time = m.group(2);
				this.mode = m.group(3);
				this.thread = m.group(4);
				this.fileName = m.group(5);
				this.lineNumber = m.group(6);
				this.message = m.group(7);
			}
		}

	}

	static private class ParseLogStatusMethod {
		private static final String patternProgressMessage = "\\\"\\|(.*)\\:(.*)\\|\\|" + ParseLog.progressMethodName
				+ "\\:(.*\\;)\\|\\\"";
		private static final String patternStatus = "([A-Z|\\_|0-9]+)\\:([0-9]+)";
		private static Pattern pProgress = Pattern.compile(patternProgressMessage); // gets
																					// orcid
		private static Pattern pStatus = Pattern.compile(patternStatus);

		private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S");
		public ProgressStatus progressStatus = new ProgressStatus();

		public ParseLogStatusMethod(String message) {
			ParseLogLine parsedLine = new ParseLogLine(message);

			StatusRecordsList statusRecordsList = new StatusRecordsList();
			Date date;
			try {
				date = dateFormat.parse(parsedLine.date + " " + parsedLine.time);
			} catch (java.text.ParseException e) {
				date = new Date();
			}

			// Parse Message
			if (parsedLine.message != null) {
				Matcher mProgress = pProgress.matcher(parsedLine.message);
				mProgress.find();

				if (!mProgress.group().isEmpty() && mProgress.group(3) != null) {
					Matcher mStatus = pStatus.matcher(mProgress.group(3));

					while (mStatus.find()) {
						StatusRecords sr = new StatusRecords();
						sr.setStatus(mStatus.group(1));
						sr.setRecordsNumber(Integer.valueOf(mStatus.group(2)));

						statusRecordsList.add(sr);
					}

					progressStatus.setDate(date);
					progressStatus.setStatusRecordsList(statusRecordsList);
				}
			}
		}
	}
}
