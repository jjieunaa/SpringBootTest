package kr.kwangan2.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.kwangan2.test.domain.Person;

// @RestController
public class PersonController {
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello: " + name;
	}
	
	@GetMapping("/getPerson")
	public Person getPerson() {
		Person person = new Person();
		
		person.setName("Lee Ji Eun");
		person.setAge(24);
		
		return person;
	}
	
	@GetMapping("/getPersonList")
	public List<Person> getPersonList() {
		Person person1 = new Person();
		person1.setName("Lee Ji Eun");
		person1.setAge(24);
		
		Person person2 = new Person();
		person2.setName("Lee Dan ji");
		person2.setAge(9);
		
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(person1);
		personList.add(person2);
		
		return personList;
	}

}
