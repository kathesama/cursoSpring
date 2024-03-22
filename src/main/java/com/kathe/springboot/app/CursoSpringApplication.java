package com.kathe.springboot.app;

import com.kathe.springboot.app.entities.Person;
import com.kathe.springboot.app.repositories.section09.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableAspectJAutoProxy
@RequiredArgsConstructor
public class CursoSpringApplication implements CommandLineRunner {

	private final PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		update();
	}

	@Transactional
	public void create(){
		Person person = new Person(null, "Pepe", "Aguilar", "React");
		repository.save(person);
	}

	@Transactional
	public void update(){
		Optional<Person> person = repository.findById(6L);

		person.ifPresent((optionalPerson) -> {
			System.out.println("Ingresando el lenguaje de programación");
			optionalPerson.setProgrammingLanguage("JS");
			System.out.println(repository.save(optionalPerson));
		});

//		repository.save(person);
	}

	@Transactional(readOnly = true)
	public void findOne(){
//		Person person = null;
//
//		Optional<Person> optionalPerson = repository.findById(1L);
//
//		if(optionalPerson.isPresent()) {
//			person = optionalPerson.get();
//		}
//
//		System.out.println(person);

//		repository.findById(1L).ifPresent(person -> System.out.println(person));
		repository.findById(1L).ifPresent(System.out::println);
		repository.findByNameContaining("se").ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void List() {
		List<Person> entities = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Maria");

		entities.stream().forEach(person -> {
			System.out.println(person);
		});
//		List<Person> entities = Arrays.asList(
//				new Person(null, "Juan", "Mendoza", "C++"),
//				new Person(null, "Carlos", "Rodriguez", "C++"),
//				new Person(null, "Julio", "Perez", "C++"),
//				new Person(null, "Roman", "Ramirez", "C++")
//		);
//
//		repository.saveAll(entities);
	}
}
