package kr.kwangan2.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.kwangan2.test.domain.Person;
import kr.kwangan2.test.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public String hello(String name) {
		return "Hello: " + name;
	}

	@Override
	public Person getPerson() {
		Person person = new Person();
		
		person.setName("Lee Ji Eun");
		person.setAge(24);
		
		return person;
	}

	@Override
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
