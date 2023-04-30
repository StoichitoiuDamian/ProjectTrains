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
     * metodele folosite pentru a realiza Get put post delete
     *  plus alte end pointuri noi cum ar fi findbyid deletebyid
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
