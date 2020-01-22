package techtest.techtest.external;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import techtest.techtest.entity.*;

@Service
public class JobService {
	
	@Value("${uri.job}")
	private String jobUri;

	public List<Job> getAll() {
		
		String jsonString = new ExternalService(jobUri).getExternalDataAsString();
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Job>>(){}.getType();
		List<Job> list = gson.fromJson(jsonString, type);
		return list;
	}
}
