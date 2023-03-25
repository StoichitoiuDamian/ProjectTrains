package com.example.demo.service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

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
}
