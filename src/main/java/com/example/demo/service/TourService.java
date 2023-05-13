package com.example.demo.service;

import com.example.demo.model.Tour;
import com.example.demo.model.Train;
import com.example.demo.repository.TourRepository;
import com.example.demo.repository.TrainRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TourService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    public TourService(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }
    public TourRepository getTourRepository() {
        return tourRepository;
    }

    public void setTourRepository(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> toursFindAll(){
        return tourRepository.findAll();
    }
    public void tourDeleteAll(){
        tourRepository.deleteAll();
    }

    public Tour createTour(Tour tour){
        return tourRepository.save(tour);
    }

    public Tour updateById(Long id,Tour tour){
        Optional<Tour> updateTour = tourRepository.findById(id);
        long id_tour = tour.getId_tour();
        int day = tour.getDay();
        int month = tour.getMonth();
        String start = tour.getStart();
        String stop = tour.getStop();
        int id_train = tour.getId_train();


        return tourRepository.save(tour);
    }

    public Tour findById(Long id_tour){
        Optional<Tour> optionalTour = tourRepository.findById(id_tour);
        if(optionalTour.isPresent()){
            return optionalTour.get();
        }else {
            throw new EntityNotFoundException("tour with id "+id_tour+ "not found");
        }
    }
    public void deleteById(Long id_tour){
        Optional<Tour> optionalTour = tourRepository.findById(id_tour);
        if(optionalTour.isPresent()){
            tourRepository.deleteById(id_tour);
        }else {
            throw new EntityNotFoundException("train with id "+id_tour+"not found");
        }
    }
}
