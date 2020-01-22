package techtest.techtest.external;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import techtest.techtest.entity.*;

@Service
public class WorkerService {
	@Value("${uri.worker}")
	private String workerUri;
	
	private List<Worker> getAll() {
		String jsonString = new ExternalService(workerUri).getExternalDataAsString();
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Worker>>(){}.getType();
		List<Worker> list = gson.fromJson(jsonString, type);
		return list;
	}
	
	//get WorkerByID. Assumed that userId is workerId 
	public Worker getWorkerById(long workerId) {
		List<Worker> list = getAll();
			
		Worker worker = list.stream()
				  .filter(element ->  (element.getUserId()== workerId && element.getIsActive()))
				  .findAny()
				  .orElse(null);
			return worker;
	}
}
