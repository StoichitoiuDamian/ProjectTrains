package com.example.demo;

import com.example.demo.model.Carload;
import com.example.demo.model.Person;
import com.example.demo.repository.CarloadRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.CarloadService;
import com.example.demo.service.PersonService;
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
public class TestEndPointsCarload {
    @Mock
    private CarloadRepository carloadRepository;

    @InjectMocks
    private CarloadService carloadService;



    private Carload carload1;
    private Carload carload2;
    private List<Carload> carloadList;



    @BeforeEach
    public void setUp() {
        carload1 = new Carload();
        carload1.setId_carload(1L);
        carload1.setId_train(1);
        carload1.setNumber_sits(1);
        carload1.setClass_type("First Class");

        carload1 = new Carload();
        carload1.setId_carload(1L);
        carload1.setId_train(1);
        carload1.setNumber_sits(1);
        carload1.setClass_type("First Class");




        carloadList = new ArrayList<>();
        carloadList.add(carload1);
        carloadList.add(carload2);
    }

    @Test
    public void testCarloadFindAll() {
        when(carloadRepository.findAll()).thenReturn(carloadList);
        List<Carload> foundCarload = carloadService.CarloadsFindAll();
        assertEquals(2, foundCarload.size());
        assertEquals(carloadList, foundCarload);
    }

    @Test
    public void testCarloadDeleteAll() {
        carloadService.carloadDeleteAll();
        verify(carloadRepository, times(1)).deleteAll();
    }

    @Test
    public void testCreateCarload() {
        when(carloadRepository.save(carload1)).thenReturn(carload1);
        Carload createCarload = carloadService.createCarload(carload1);
        assertEquals(carload1, createCarload);
    }
    @Test
    public void testUpdateById() {
        Optional<Carload> optionalCarload= Optional.of(carload1);
        when(carloadRepository.findById(1L)).thenReturn(optionalCarload);
        when(carloadRepository.save(carload1)).thenReturn(carload1);
        Carload updatedCarload = carloadService.updateById(1L, carload1);
        assertEquals(carload1, updatedCarload);
    }
    @Test
    public void testFindById() {
        Optional<Carload> optionalCarload = Optional.of(carload1);
        when(carloadRepository.findById(1L)).thenReturn(optionalCarload);
        Carload foundCarload = carloadService.findById(1L);
        assertEquals(carload1, foundCarload);
    }

    @Test
    public void testDeleteById() {
        Optional<Carload> optionalCarload = Optional.of(carload1);
        when(carloadRepository.findById(1L)).thenReturn(optionalCarload);
        carloadService.deleteById(1L);
        verify(carloadRepository, times(1)).deleteById(1L);
    }
}
