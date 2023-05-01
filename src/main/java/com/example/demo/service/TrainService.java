package com.example.demo.service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {
    /**
     Mai precis, această clasă definește următoarele metode pentru manipularea datelor din tabelul Train:
     trainFindAll():
     returnează o listă cu toate înregistrările din tabelul Train;
     trainDeleteAll():
     șterge toate înregistrările din tabelul Train;
     createTrain(Train train):
     adaugă o nouă înregistrare în tabelul Train, utilizând obiectul Train furnizat ca argument;
     updateById(Long id,Train train):
     actualizează o înregistrare existentă din tabelul Train cu ID-ul dat,
     utilizând obiectul Train furnizat ca argument. Această metodă utilizează metoda findById(id) pentru a găsi înregistrarea înainte de a o actualiza;
     findById(Long id_train):
     caută o înregistrare din tabelul Train după ID și returnează obiectul
     Train corespunzător. Dacă nu există nicio înregistrare cu acel ID, se va arunca o excepție EntityNotFoundException;
     deleteById(Long id_train):
     șterge o înregistrare din tabelul Train cu ID-ul dat.
     Această metodă utilizează metoda findById(id) pentru a găsi înregistrarea înainte de a o șterge.
     Dacă nu există nicio înregistrare cu acel ID, se va arunca o excepție EntityNotFoundException.
     Această clasă este marcată cu @Service, ceea ce înseamnă că poate fi injectată în alte clase care o folosesc ca dependență.
     utilizează și o dependență a clasei TrainRepository, care este injectată prin intermediul constructorului.
     */

    private  TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }
    public TrainRepository getTrainRepository() {
        return trainRepository;
    }

    public void setTrainRepository(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> trainFindAll(){
        return trainRepository.findAll();
    }
    public void trainDeleteAll(){
        trainRepository.deleteAll();
    }

    public Train createTrain(Train train){
        return trainRepository.save(train);
    }

    public Train updateById(Long id,Train train){
        Optional<Train> updateTrain = trainRepository.findById(id);
        String train_name = train.getTrain_name();
        String train_type = train.getTrain_type();
        long tour_id = train.getId_tour();

        return trainRepository.save(train);
    }

    public Train findById(Long id_train){
        Optional<Train> optionalTrain = trainRepository.findById(id_train);
        if(optionalTrain.isPresent()){
            return optionalTrain.get();
        }else {
            throw new EntityNotFoundException("train with id "+id_train+ "not found");
        }
    }
    public void deleteById(Long id_train){
        Optional<Train> optionalTrain = trainRepository.findById(id_train);
        if(optionalTrain.isPresent()){
            trainRepository.deleteById(id_train);
        }else {
            throw new EntityNotFoundException("train with id "+id_train+"not found");
        }
    }

}
