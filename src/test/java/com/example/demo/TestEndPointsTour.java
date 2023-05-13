package com.example.demo;

import com.example.demo.model.Tour;
import com.example.demo.model.Train;
import com.example.demo.repository.TourRepository;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TicketService;
import com.example.demo.service.TourService;
import com.example.demo.service.TrainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class TestEndPointsTour {
    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourService tourService;



    private Tour tour1;
    private Tour tour2;
    private List<Tour> tourList;



    @BeforeEach
    public void setUp() {
        tour1 = new Tour();
        tour1.setId_tour(1L);
        tour1.setHour(20);
        tour1.setDay(20);
        tour1.setMonth(12);
        tour1.setId_train(1);

        tour2 = new Tour();
        tour2.setId_tour(2L);
        tour2.setHour(10);
        tour2.setDay(10);
        tour2.setMonth(6);
        tour2.setId_train(2);

        tourList = new ArrayList<>();
        tourList.add(tour1);
        tourList.add(tour2);
    }

    @Test
    public void testTourFindAll() {
        when(tourRepository.findAll()).thenReturn(tourList);
        List<Tour> foundTour = tourService.toursFindAll();
        assertEquals(2, foundTour.size());
        assertEquals(tourList, foundTour);
    }

    @Test
    public void testTourDeleteAll() {
        tourService.tourDeleteAll();
        verify(tourRepository, times(1)).deleteAll();
    }

    @Test
    public void testCreateTour() {
        when(tourRepository.save(tour1)).thenReturn(tour1);
        Tour createdTour = tourService.createTour(tour1);
        assertEquals(tour1, createdTour);
    }
    @Test
    public void testUpdateById() {
        Optional<Tour> optionalTour = Optional.of(tour1);
        when(tourRepository.findById(1L)).thenReturn(optionalTour);
        when(tourRepository.save(tour1)).thenReturn(tour1);
        Tour updatedTour = tourService.updateById(1L, tour1);
        assertEquals(tour1, updatedTour);
    }
    @Test
    public void testFindById() {
        Optional<Tour> optionalTour = Optional.of(tour1);
        when(tourRepository.findById(1L)).thenReturn(optionalTour);
        Tour foundTour = tourService.findById(1L);
        assertEquals(tour1, foundTour);
    }

    @Test
    public void testDeleteById() {
        Optional<Tour> optionalTour = Optional.of(tour1);
        when(tourRepository.findById(1L)).thenReturn(optionalTour);
        tourService.deleteById(1L);
        verify(tourRepository, times(1)).deleteById(1L);
    }

}
