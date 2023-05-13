package com.example.demo.controller;


import com.example.demo.model.Carload;
import com.example.demo.model.Person;
import com.example.demo.model.Train;
import com.example.demo.observer.TrainNews;
import com.example.demo.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Această clasă este un controller pentru o aplicație web care permite gestionarea de persoane.
 * Folosește anotarea Spring @Autowired pentru a injecta o instanță a clasei PersonService.
 * Clasa conține cinci endpoint-uri diferite, toate marcate cu anotări Spring care specifică tipul de cerere HTTP și calea URL. Aceste endpoint-uri permit:
 *
 * Obținerea tuturor persoanelor (HTTP GET la /person)
 * Ștergerea tuturor persoanelor (HTTP DELETE la /deletePerson)
 * Crearea unei noi persoane (HTTP POST la /postPerson)
 * Actualizarea unei persoane existente, specificată prin ID (HTTP PUT la /putPerson{id})
 * Obținerea unor știri, pasând un string cu noutățile (HTTP GET la /getNews)
 * Ultimul endpoint (/getNews) este cel care diferă de celelalte, întrucât nu lucrează direct cu obiecte de tip Person.
 * În schimb, apelează o metodă de actualizare în cadrul PersonService pentru a notifica persoanele abonate despre știri noi.
 */
@RestController
@CrossOrigin
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> showPerson(){
        return personService.personFindAll();
    }

    @DeleteMapping("/deletePerson")
    public void deletePerson(){
        personService.personDeleteAll();
    }

    @PostMapping("/postPerson")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
    @PutMapping("/putPerson{id}")
    public Person updatePerson(@PathVariable Long id,@RequestBody Person person){
        return personService.updateById(id,person);
    }
    @GetMapping("/getNews")
    public void getNews(String news){
        personService.update(news);
    }
    @GetMapping("/findPerson{id}")
    public Person findById(@PathVariable Long id){
        Person t1 = new Person();

        try{
            t1 = personService.findById(id);
        }
        catch (EntityNotFoundException e2){
            System.out.println("Entity not found");
        }
        catch (Exception e){
            t1 = null;
            System.out.println("Exception found");
        }

        return t1;
    }
    @DeleteMapping("/deletePerson{id}")
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }
}
