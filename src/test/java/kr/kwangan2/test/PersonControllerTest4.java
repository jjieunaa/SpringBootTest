package kr.kwangan2.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kr.kwangan2.test.domain.Person;
import kr.kwangan2.test.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PersonControllerTest4 {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;
	
	@Test
	public void testHello() throws Exception {
		when(personService.hello("jieun")).thenReturn("Hello: jieun");
		
		mockMvc.perform(get("/hello").param("name", "jieun"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello: jieun"))
			.andDo(print());
	}
	
	@Test
	public void testGetPerson() throws Exception {
		Person person = new Person();
		
		person.setName("Lee Ji Eun");
		person.setAge(24);
		
		when(personService.getPerson()).thenReturn(person);
	}
	
	@Test
	public void testGetPersonList() throws Exception {
		Person person1 = new Person();
		person1.setName("Lee Ji Eun");
		person1.setAge(24);
		
		Person person2 = new Person();
		person2.setName("Lee Dan Ji");
		person2.setAge(9);
		
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(person1);
		personList.add(person2);
		
		when(personService.getPersonList()).thenReturn(personList);
	}
	
}	// class
