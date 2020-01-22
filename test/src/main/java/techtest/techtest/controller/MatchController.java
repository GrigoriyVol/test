package techtest.techtest.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import techtest.techtest.entity.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import techtest.techtest.service.SuggestJobsService;

@RestController
@RequestMapping({"/"})
public class MatchController {

	@Autowired
	SuggestJobsService suggestJobsService;
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getSuggestedJobs(@Valid @RequestParam Integer workerId){
		if (workerId == null)
			return ResponseEntity.badRequest().build();
		else if (workerId<0)  
			return ResponseEntity.badRequest().build();
			
		try {
			List<Job> jobs = suggestJobsService.getSuggestedJobsForWorkerId(workerId);
			return new ResponseEntity<>(jobs, HttpStatus.OK);
		}
		catch (JSONException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
