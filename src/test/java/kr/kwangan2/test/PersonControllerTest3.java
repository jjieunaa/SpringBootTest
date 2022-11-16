package kr.kwangan2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.test.domain.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PersonControllerTest3 {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	// @Test
	public void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello?name=jieun", String.class);
		assertEquals("Hello: jieun", result);
	}
	
	@Test
	public void testGetPerson() throws Exception {
		Person person = restTemplate.getForObject("/getPerson", Person.class);
		assertEquals("Lee Ji Eun", person.getName());
		
		Person person2 = new Person();
		person2.setName("Lee Ji Eun");
		person2.setAge(24);
		
		System.out.println("person2 ==> " + person2.hashCode());
		System.out.println("person ==> " + person.hashCode());
		
		assertEquals(person2, person);
		
	}
	
}	// class
