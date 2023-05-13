package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.Ticket;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class TestEndPointsPerson {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;



    private Person person1;
    private Person person2;
    private List<Person> personList;



    @BeforeEach
    public void setUp() {
        person1 = new Person();
        person1.setId_person(1L);
        person1.setUsername("name1");
        person1.setUsername("name2");

        person2 = new Person();
        person2.setId_person(1L);
        person2.setUsername("name1");
        person2.setUsername("name2");




        personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
    }

    @Test
    public void testPersonFindAll() {
        when(personRepository.findAll()).thenReturn(personList);
        List<Person> foundPerson = personService.personFindAll();
        assertEquals(2, foundPerson.size());
        assertEquals(personList, foundPerson);
    }

    @Test
    public void testPersonDeleteAll() {
        personService.personDeleteAll();
        verify(personRepository, times(1)).deleteAll();
    }

    @Test
    public void testCreatePerson() {
        when(personRepository.save(person1)).thenReturn(person1);
        Person createdPerson = personService.createPerson(person1);
        assertEquals(person1, createdPerson);
    }
    @Test
    public void testUpdateById() {
        Optional<Person> optionalPerson = Optional.of(person1);
        when(personRepository.findById(1L)).thenReturn(optionalPerson);
        when(personRepository.save(person1)).thenReturn(person1);
        Person updatedPerson = personService.updateById(1L, person1);
        assertEquals(person1, updatedPerson);
    }
    @Test
    public void testFindById() {
        Optional<Person> optionalPerson = Optional.of(person1);
        when(personRepository.findById(1L)).thenReturn(optionalPerson);
        Person foundPerson = personService.findById(1L);
        assertEquals(person1, foundPerson);
    }

    @Test
    public void testDeleteById() {
        Optional<Person> optionalPerson = Optional.of(person1);
        when(personRepository.findById(1L)).thenReturn(optionalPerson);
        personService.deleteById(1L);
        verify(personRepository, times(1)).deleteById(1L);
    }
}
