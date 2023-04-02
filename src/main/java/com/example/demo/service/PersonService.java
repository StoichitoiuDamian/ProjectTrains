package com.example.demo.service;


import com.example.demo.model.Person;
import com.example.demo.model.Train;
import com.example.demo.observer.NewTrainInformation;
import com.example.demo.observer.TrainNews;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements NewTrainInformation{

    /**
     * metodele folosite pentru a realiza Get put post delete
     *
     */
    @Autowired
    private PersonRepository personRepository;
    private TrainNews trainNews;

    public List<Person> personFindAll(){
        return personRepository.findAll();
    }
    public void personDeleteAll(){
        personRepository.deleteAll();
    }
    public Person createPerson(Person person){
        return personRepository.save(person);
    }
    public Person updateById(Long id,Person person){
        Optional<Person> updatePerson = personRepository.findById(id);
        String username = person.getUsername();
        String password = person.getPassword();

        return personRepository.save(person);
    }
    @Override
    public void update(String news) {
        trainNews.setNews(news);
    }

}
