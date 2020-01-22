package techtest.techtest.service.impl;

import org.springframework.stereotype.Service;

import techtest.techtest.service.MatchingService;

@Service
public class MatchingFactory {
	public MatchingService getMatchingMethod(String matchCriteria){
	      if(matchCriteria == null){
	         return null;
	      }		
	      if(matchCriteria.equalsIgnoreCase("Certificate")){
	         return new CertificateMatchingImpl();
	         
	      } else if(matchCriteria.equalsIgnoreCase("DriverLicense")){
	         return new DriverLicenseMatchingImpl();
	      }
	      else if(matchCriteria.equalsIgnoreCase("Location")){
		         return new LocationMatchingImpl();
		      }
	      return null;
	   }
}