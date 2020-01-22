package techtest.techtest.external;

import org.springframework.web.client.RestTemplate;

public class ExternalService {
	private String uri;
	
	protected ExternalService(String swipeUri) {
		uri = swipeUri;
	}

	protected  String getExternalDataAsString(){
		RestTemplate restTemplate = new RestTemplate();
		String jsonString = restTemplate.getForObject(uri, String.class);
		return jsonString;
	}
}
