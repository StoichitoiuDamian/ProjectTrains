package com.example.demo.trainclassunittests;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TrainDaoImpl implements TrainDao{
    @Autowired
    private TrainRepository trainRepository;

   // @Override
   // public Train updateById(Long id, Train train) {
   //     return trainRepository.updateById(id,train);
   // }

    @Override
    public Train save(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    @Override
    public Optional<Train> findById(Long id) {
        return trainRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
       trainRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
      trainRepository.deleteAll();
    }
}
