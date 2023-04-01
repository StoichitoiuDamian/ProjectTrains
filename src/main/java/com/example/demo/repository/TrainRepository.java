package com.example.demo.repository;

import com.example.demo.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {
    Optional<Train> findById(Long id_train);
    void deleteById(Long id_train);
}
