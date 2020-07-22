package pt.ptcris.sync.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.um.dsi.gavea.orcid.model.work.Work;

import io.swagger.model.WorkInvalidResult;
import io.swagger.model.WorkInvalidResults;

public class InvalidSwaggerMap {
	public static WorkInvalidResults map(Map<Work,Set<String>> invalidResults) {
		WorkInvalidResults returnInvalids = new WorkInvalidResults(); 
		
		for (Map.Entry<Work,Set<String>> entry : invalidResults.entrySet()) {
			WorkInvalidResult invalidResult = new WorkInvalidResult();
			Work work = entry.getKey();
			List<String> errors = new ArrayList<String>(entry.getValue());
			
			invalidResult.setWork(WorkSwaggerMap.map(work));
			invalidResult.setError(errors);
			
			returnInvalids.add(invalidResult);
		}
		
		return returnInvalids;
	}
}
