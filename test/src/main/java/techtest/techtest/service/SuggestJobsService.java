package techtest.techtest.service;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import techtest.techtest.Exception.NotMatchException;
import techtest.techtest.entity.Job;
import techtest.techtest.entity.Worker;
import techtest.techtest.external.JobService;
import techtest.techtest.external.WorkerService;
import techtest.techtest.service.impl.MatchingFactory;

@Service
public class SuggestJobsService {
	
	@Value("#{'${matching.criteria}'.split(',')}") 
	private List<String> matchCriteria;

	@Autowired
	WorkerService workerService;

	@Autowired
	JobService jobService;

	@Autowired
	MatchingFactory matchingFactory;
	
	@Value("${max.job}")
	private String strMaxJob;
	
    public List<Job> getSuggestedJobsForWorkerId(long workerId) throws JSONException{
    	Worker worker = workerService.getWorkerById(workerId);
    	
    	List<Job> jobs = jobService.getAll();
        List<Job> matchedJobs = getMatchedJobs(jobs,worker, matchCriteria);
        return 	matchedJobs;
    }
    
    private List<Job> getMatchedJobs(List<Job> jobs, Worker worker, List<String> matchCriterias){ 
    	byte maxJobs = Byte.parseByte(strMaxJob);
    	byte counter =0; 
    	List<Job> suggestedJobs = new ArrayList<Job>();
    	for (Job job:jobs ) {
    		try {
    			//if not match, throws Exception. if matched, add to result list
    			Job matchedJob = isJobMatched(job, worker, matchCriterias);
    			if (counter < maxJobs) {
    				suggestedJobs.add(matchedJob);
    				counter ++;
    			}
    			else return suggestedJobs ;
    		}
    		catch (Exception ex){};
    	}
    	return suggestedJobs;
    }
    
    //check if a job matches with this worker or not
    private Job isJobMatched(Job job, Worker worker, List<String> matchCriterias) 
    		throws JSONException, NotMatchException {
    	for (String criteria: matchCriterias) {
    		MatchingService matchingService = matchingFactory.getMatchingMethod(criteria);
        		matchingService.matching(job, worker);
    	}
    	return job;
    }
}
