package techtest.techtest.service.impl;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import techtest.techtest.Exception.NotMatchException;
import techtest.techtest.entity.Job;
import techtest.techtest.entity.Worker;
import techtest.techtest.service.MatchingService;

@Service
public class DriverLicenseMatchingImpl implements MatchingService {

	@Override
	public boolean matching(Job job, Worker worker) throws JSONException, NotMatchException {
		boolean matched; 
		if (!job.getDriverLicenseRequired()) return true;
		else {
			matched = worker.getHasDriversLicense() && job.getDriverLicenseRequired();
			if (!matched) throw new NotMatchException();
		}
			return matched;
	}
}