package techtest.techtest.service;

import techtest.techtest.Exception.NotMatchException;
import techtest.techtest.entity.*;

import org.json.JSONException;

public interface MatchingService {
	boolean matching(Job job, Worker worker) throws JSONException, NotMatchException;
}