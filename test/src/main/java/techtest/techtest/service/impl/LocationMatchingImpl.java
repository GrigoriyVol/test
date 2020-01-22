package techtest.techtest.service.impl;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import techtest.techtest.Exception.NotMatchException;
import techtest.techtest.entity.Job;
import techtest.techtest.entity.Worker;
import techtest.techtest.service.MatchingService;

@Service
public class LocationMatchingImpl implements MatchingService {
	@Override
	public boolean matching(Job job, Worker worker) throws JSONException, NotMatchException{
		//difference >=0 mean job location is inside jobSearch area
		double difference = worker.getJobSearchAddress().getMaxJobDistance() - 
					getDistance(Double.parseDouble(worker.getJobSearchAddress().getLatitude()), 
					Double.parseDouble(job.getLocation().getLatitude()),
					Double.parseDouble(worker.getJobSearchAddress().getLongitude()), 
					Double.parseDouble(job.getLocation().getLongitude()), 
					worker.getJobSearchAddress().getUnit());
		if (difference < 0)
			throw new NotMatchException();
		return true;
	}
	
	
	private double getDistance(double lat1,  double lat2,double lon1, double lon2, String unit){ 
		//Radius of earth in kilometers
		final double radiusInKm = 6371; 
		final double radiusInMile = 3956;

		final String Km = "km"; 
		//final String Mile = "mile";

		lon1 = Math.toRadians(lon1); 
		lon2 = Math.toRadians(lon2); 
		lat1 = Math.toRadians(lat1); 
		lat2 = Math.toRadians(lat2); 

		double dlon = lon2 - lon1;  
		double dlat = lat2 - lat1;

		double a = Math.pow(Math.sin(dlat / 2), 2) 
	        + Math.cos(lat1) * Math.cos(lat2) 
	        * Math.pow(Math.sin(dlon / 2),2); 
	     
		double c = 2 * Math.asin(Math.sqrt(a)); 
	
	// calculate the result
		double radius;
		if (unit.toLowerCase().equals(Km))
			radius = radiusInKm;
		else
			radius = radiusInMile;
		double result = (c*radius); 
		return Math.round(result*1000)/1000; 
	}  
}
