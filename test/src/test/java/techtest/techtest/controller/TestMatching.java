package techtest.techtest.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMatching {
	final String URL = "http://localhost:8080/jobs?workerId=";
	
	@Autowired
	private MockMvc mockMvc;

	//@Test
	public void testIfReturnMoreThan3Jobs() throws Exception {
		this.mockMvc.perform(get(URL +  "5")).andExpect(jsonPath("$", hasSize(4)));
	}

	//@Test
	public void testNoDrivingLicense() throws Exception {
		this.mockMvc.perform(get(URL +  "18")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Nimon")));
	}

	//@Test
	public void testWorkerIdLessThanZero() throws Exception {
		this.mockMvc.perform(get(URL +  "-1")).andDo(print()).andExpect(status().isBadRequest());
	}

	
	//@Test
	public void testNotInLocation() throws Exception {
		this.mockMvc.perform(get(URL +  "7")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("")));
	}
	
	@Test
	public void testNotActive() throws Exception {
		this.mockMvc.perform(get(URL +  "1")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("")));
	}


}
