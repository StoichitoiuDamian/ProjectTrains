package com.example.demo;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class DemoApplicationTests {


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

/*
	@Test
	void contextLoads() {
	}
	TypeDobanda t1 = TypeDobanda.MICA;
	TypeDobanda t2 = TypeDobanda.MEDIE;
	TypeDobanda t3 = TypeDobanda.MARE;

	@Mock
	OperatiiBazaDeDate user;

	CalculDobanda c2 = new CalculDobanda();
	CalculDobanda c3 = new CalculDobanda();
	@Test
	void testsMare(){
		assertEquals(2,c2.dobanda(t3));
	}
	@Test
	void testMica(){
		assertEquals(0.5,c2.dobanda(t1));
	}
	@Test
	void testMedie(){
		assertEquals(1,c2.dobanda(t2));
	}
	@Test
	void recalculareMetodaMediu(){
		User u1 = new User("Marcel ",Risc.MEDIU);
		when(user.getUser()).thenReturn(u1);
		CalculDobanda c5 = new CalculDobanda(user);
		assertEquals(1,c5.calculDobanda());
		verify(user).getUser();
	}
	@Test
	void recalculareMetodaMic(){
		User u1 = new User("Marcel ",Risc.SCAZUT);
		when(user.getUser()).thenReturn(u1);
		CalculDobanda c5 = new CalculDobanda(user);
		assertEquals(0.5,c5.calculDobanda());
		verify(user).getUser();
	}
	@Test
	void recalculareMetodaMare(){
		User u1 = new User("Marcel ",Risc.RIDICAT);
		when(user.getUser()).thenReturn(u1);
		CalculDobanda c5 = new CalculDobanda(user);
		assertEquals(2,c5.calculDobanda());
		verify(user).getUser();
	}
*/


}
