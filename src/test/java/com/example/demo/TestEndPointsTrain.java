package com.example.demo;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
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
public class TestEndPointsTrain {
    @Mock
    private TrainRepository trainRepository;

    @InjectMocks
    private TrainService trainService;



    private Train train1;
    private Train train2;
    private List<Train> trainList;

    /**
     * testTrainFindAll():
     * Această metodă de testare verifică funcția trainFindAll() din clasa TrainService.
     * Prin intermediul metodei mock when(trainDao.findAll()).thenReturn(trainList),
     * simulăm comportamentul metodei findAll() din clasa TrainDao pentru a returna trainList.
     * Apoi, apelăm metoda trainFindAll() din clasa
     * TrainService și verificăm că aceasta întoarce o
     * listă de dimensiunea așteptată, respectiv 2 și că aceasta este identică cu trainList.
     *
     * testTrainDeleteAll():
     * Această metodă de testare verifică funcția trainDeleteAll() din clasa TrainService.
     * Apelăm metoda trainDeleteAll() din clasa TrainService, iar apoi prin intermediul metodei verify(trainDao, times(1)).deleteAll(),
     * verificăm dacă metoda deleteAll() din clasa TrainDao a fost apelată exact o dată.
     *
     * testCreateTrain():
     * Această metodă de testare verifică funcția createTrain(Train train) din clasa TrainService.
     * Prin intermediul metodei mock when(trainDao.save(train1)).thenReturn(train1), simulăm comportamentul metodei save() din clasa
     * TrainDao pentru a returna obiectul train1 dat ca parametru. Apoi, apelăm metoda createTrain(Train train1) din clasa TrainService
     * și verificăm că obiectul returnat este identic cu train1.
     *
     * testUpdateById():
     * Această metodă de testare verifică funcția updateById(Long id, Train train) din clasa TrainService.
     * Prin intermediul metodei mock when(trainDao.findById(1L)).thenReturn(optionalTrain) simulăm comportamentul metodei findById()
     * din clasa TrainDao pentru a returna un obiect de tip Optional<Train> care conține obiectul train1. De asemenea, prin intermediul
     * metodei mock when(trainDao.save(train1)).thenReturn(train1) simulăm comportamentul metodei save() din clasa TrainDao pentru a returna
     * obiectul train1 dat ca parametru. Apoi, apelăm metoda updateById(Long id, Train train1) din clasa TrainService și verificăm că obiectul returnat este identic cu train1.
     *
     * testFindById():
     * Această metodă de testare verifică funcția findById(Long id) din clasa TrainService.
     * Prin intermediul metodei mock when(trainDao.findById(1L)).thenReturn(optionalTrain)
     * simulăm comportamentul metodei findById() din clasa TrainDao pentru a returna un obiect de tip Optional<Train> care conține obiectul train1.
     * Apoi, apelăm metoda findById(Long id) din clasa TrainService și verificăm că obiectul returnat este identic cu train1.
     */



    @BeforeEach
    public void setUp() {
        train1 = new Train();
        train1.setId_train(1L);
        train1.setTrain_name("Train 1");
        train1.setTrain_type("Type 1");
        train1.setId_tour(2L);

        train2 = new Train();
        train2.setId_train(2L);
        train2.setTrain_name("Train 2");
        train2.setTrain_type("Type 2");
        train2.setId_tour(3L);

        trainList = new ArrayList<>();
        trainList.add(train1);
        trainList.add(train2);
    }

    @Test
    public void testTrainFindAll() {
        when(trainRepository.findAll()).thenReturn(trainList);
        List<Train> foundTrains = trainService.trainFindAll();
        assertEquals(2, foundTrains.size());
        assertEquals(trainList, foundTrains);
    }

    @Test
    public void testTrainDeleteAll() {
        trainService.trainDeleteAll();
        verify(trainRepository, times(1)).deleteAll();
    }

    @Test
    public void testCreateTrain() {
        when(trainRepository.save(train1)).thenReturn(train1);
        Train createdTrain = trainService.createTrain(train1);
        assertEquals(train1, createdTrain);
    }
    @Test
    public void testUpdateById() {
        Optional<Train> optionalTrain = Optional.of(train1);
        when(trainRepository.findById(1L)).thenReturn(optionalTrain);
        when(trainRepository.save(train1)).thenReturn(train1);
        Train updatedTrain = trainService.updateById(1L, train1);
        assertEquals(train1, updatedTrain);
    }
    @Test
    public void testFindById() {
        Optional<Train> optionalTrain = Optional.of(train1);
        when(trainRepository.findById(1L)).thenReturn(optionalTrain);
        Train foundTrain = trainService.findById(1L);
        assertEquals(train1, foundTrain);
    }

    @Test
    public void testDeleteById() {
        Optional<Train> optionalTrain = Optional.of(train1);
        when(trainRepository.findById(1L)).thenReturn(optionalTrain);
        trainService.deleteById(1L);
        verify(trainRepository, times(1)).deleteById(1L);
    }


}
