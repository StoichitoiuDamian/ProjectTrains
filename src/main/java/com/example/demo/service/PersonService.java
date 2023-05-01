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
     Această clasă definește o implementare a interfeței "NewTrainInformation" și include metode pentru a realiza operații CRUD (create, read, update, delete)
     pentru obiecte de tip "Person". Clasa are o referință la un obiect "PersonRepository" și un obiect "TrainNews".

     Metoda "personFindAll" returnează o listă de toate obiectele "Person" stocate în baza de date, "personDeleteAll" șterge toate obiectele "Person" din baza de date,
     iar "createPerson" creează un nou obiect "Person" și îl salvează în baza de date.
     Metoda "updateById" primește un id de persoană și un obiect "Person" și actualizează informațiile din obiectul "Person" corespunzător id-ului.

     Metoda "update" este o metodă suprascrisă care primește un șir de știri și actualizează obiectul "trainNews" corespunzător.
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
