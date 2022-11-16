package kr.kwangan2.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PersonControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	// @Test
	public void testHello() throws Exception {
		mockMvc.perform(get("/hello").param("name", "홍길동"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello: 홍길동"))
			.andDo(print());
	}
	
	@Test
	public void testGetPerson() throws Exception {
		mockMvc.perform(get("/getPerson")
				.param("name", "Lee Ji Eun")
				.param("age", "24"))
			.andExpect(status().isOk())
			.andExpect(content().string("{\"name\":\"Lee Ji Eun\",\"age\":24}"))
			.andDo(print());
	}
	
	// @Test
	public void testGetPersonList() throws Exception {
		mockMvc.perform(get("/getPersonList")
				.param("name[0]", "Lee Ji Eun")
				.param("age[0]", "24")
				.param("name[1]", "Lee Dan ji")
				.param("age[1]", "9"))
			.andExpect(status().isOk())
			.andExpect(content().string("[{\"name\":\"Lee Ji Eun\",\"age\":24},{\"name\":\"Lee Dan ji\",\"age\":9}]"))
			.andDo(print());
	}
	
}	// class
