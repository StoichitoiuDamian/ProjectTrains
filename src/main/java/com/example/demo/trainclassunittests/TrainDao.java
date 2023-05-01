package com.example.demo.trainclassunittests;

import com.example.demo.model.Train;

import java.util.List;
import java.util.Optional;

/**
 * Aceasta clasă este o interfață care definește metodele necesare pentru a efectua operațiile de bază pe entitatea Train în baza de date. Acestea includ:
 *
 * save(Train train): metoda folosită pentru a salva un obiect Train în baza de date.
 * findAll(): metoda folosită pentru a găsi toate obiectele Train din baza de date.
 * findById(Long id): metoda folosită pentru a găsi un obiect Train din baza de date după ID-ul său.
 * deleteById(Long id): metoda folosită pentru a șterge un obiect Train din baza de date după ID-ul său.
 * deleteAll(): metoda folosită pentru a șterge toate obiectele Train din baza de date.
 * Aceste metode sunt utilizate de obiecte ale clasei care implementează această interfață pentru a efectua operațiile de interogare și modificare a datelor din baza de date.
 */
public interface TrainDao {

//    Train updateById(Long id,Train train);
    Train save(Train train);

    List<Train> findAll();

    Optional<Train> findById(Long id);

    void deleteById(Long id);

    void deleteAll();
}
