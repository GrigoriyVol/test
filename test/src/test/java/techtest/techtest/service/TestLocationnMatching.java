package techtest.techtest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import org.springframework.boot.test.context.SpringBootTest;
import techtest.techtest.service.impl.LocationMatchingImpl;

@SpringBootTest
public class TestLocationnMatching {
	@Autowired
	private LocationMatchingImpl lm;

	
	//@Test
	public void getDistance() {
		double lat1 = 50.083564; 
        double lat2 = 49.994037; 
        double lon1 = 15.190295; 
        double lon2 = 14.013835;
        //getDistance method was changed back to Private, so these below statemets can not run
        //double distance = lm.getDistance(lat1, lat2, lon1, lon2, "km");
        //Assert.isTrue(distance == 84.0, "check distance");
	}
}
