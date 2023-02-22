package id.mahendra.test.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@Service
public class JobService {

	private String URL_FIND_ALL = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
	private String URL_FIND_BY_ID = "http://dev3.dansmultipro.co.id/api/recruitment/positions";
	@Autowired
	private WebClient webClient;
	
	public List<Job> findAll(){
		
		ResponseSpec responseSpec = webClient.get().uri(URL_FIND_ALL).retrieve();
		List<Job> response = responseSpec.bodyToMono(new ParameterizedTypeReference<List<Job>>() {}).block();
		return response;
	}
	
	public Job findById(String id){
		ResponseSpec responseSpec = webClient.get().uri(URL_FIND_BY_ID + "/" + id).retrieve();
		Job response = responseSpec.bodyToMono(Job.class).block();
		return response;
	}
}
