package com.example.demo.trainclassunittests;

import com.example.demo.model.Train;

import java.util.List;
import java.util.Optional;

public interface TrainDao {

//    Train updateById(Long id,Train train);
    Train save(Train train);

    List<Train> findAll();

    Optional<Train> findById(Long id);

    void deleteById(Long id);

    void deleteAll();
}
