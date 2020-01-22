package techtest.techtest.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import techtest.techtest.Exception.NotMatchException;
import techtest.techtest.entity.Job;
import techtest.techtest.entity.Worker;
import techtest.techtest.service.MatchingService;

@Service
public class CertificateMatchingImpl implements MatchingService  {

	//Assume that it is matched if worker has atleast 1 ceritificate in job.requiredCertificate
	@Override
	public boolean matching(Job job, Worker worker) throws JSONException, NotMatchException{
		List<String> jobCertificatesLowerCase = convertToLowerCase(job.getRequiredCertificates());
		List<String> workerCertificatesLowerCase = convertToLowerCase(worker.getCertificates());
		/*if isDisJoint = false mean there is at least worker certificate matches Job required certificates
		 * isDisJoint = true, there is no match
		 */
		boolean isDisJoint = Collections.disjoint(jobCertificatesLowerCase, workerCertificatesLowerCase);
		if (isDisJoint) 
			throw new NotMatchException();
		return !isDisJoint;
	}
	
	private List<String> convertToLowerCase(List<String> list) {
		return list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
	}
}
