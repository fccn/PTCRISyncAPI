package pt.ptcris.sync.map;

import java.math.BigInteger;
import java.util.Map.Entry;

import org.um.dsi.gavea.orcid.model.work.Work;

import io.swagger.model.WorkExportResult;
import io.swagger.model.WorkExportResultPTCRISyncResult;
import pt.ptcris.PTCRISyncResult;

public class ExportSwaggerMap {
	
	public static WorkExportResult map(Entry<BigInteger, PTCRISyncResult<Work>> entry) {
		
		WorkExportResult workExportRes = new WorkExportResult();
		
		//Set putcode
		String putCode = "";		
		if (entry.getKey() != null) {
			putCode = entry.getKey().toString();
		}
		workExportRes.setPutCode(putCode);		
		
		//Set Result (code + exception)
		PTCRISyncResult<Work> syncResult = entry.getValue();		
		int code = 0;	
		String exception = "";
		if (syncResult.exception != null) {
			exception = syncResult.exception.getMessage();
		}			
		if ((new Integer(syncResult.code)) != null) {
			code = syncResult.code;
		}

		//Set code type message
		WorkExportResultPTCRISyncResult.TypeEnum type = null;
        switch(code){
	        case PTCRISyncResult.ADDOK:
	        	type = WorkExportResultPTCRISyncResult.TypeEnum.ADDOK;
	            break;
	        case PTCRISyncResult.INVALID:
	        	type = WorkExportResultPTCRISyncResult.TypeEnum.INVALID;
	            break;
	        case PTCRISyncResult.UPDATEOK:
	        	type = WorkExportResultPTCRISyncResult.TypeEnum.UPDATEOK;
	            break;
	        case PTCRISyncResult.UPTODATE:
	        	type = WorkExportResultPTCRISyncResult.TypeEnum.UPTODATE;
	            break;
	        case PTCRISyncResult.CLIENTERROR:
	        default:
	        	type = WorkExportResultPTCRISyncResult.TypeEnum.CLIENTERROR;
	            break;	        

	    }

        workExportRes.setPtCRISyncResult(new WorkExportResultPTCRISyncResult());
		workExportRes.getPtCRISyncResult().setCode(code);
        workExportRes.getPtCRISyncResult().setType(type);
		workExportRes.getPtCRISyncResult().setException(exception);
		
		return workExportRes;
	}
}
