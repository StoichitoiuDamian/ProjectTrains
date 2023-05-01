package com.example.demo.observer;




import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainNews {

    /**
     Această clasă implementează pattern-ul Observer (observator), care permite notificarea automată a altor obiecte
     (denumite observatori) atunci când se întâmplă o anumită acțiune.
     În contextul specific al acestei clase, obiectele observatoare sunt reprezentate de instanțe ale clasei NewTrainInformation.

     Mai precis, această clasă definește următoarele metode:
     addObserver(NewTrainInformation newTrainInformation): adaugă un nou observator la lista de observatori a acestei clase;
     removeObserver(NewTrainInformation newTrainInformation): elimină un observator din lista de observatori a acestei clase;
     setNews(String news): actualizează știrile legate de trenurile noi și notifică toți observatorii despre aceste schimbări.
     */

    private String news;
    private List<NewTrainInformation> newTrainInformations = new ArrayList<>();

    public void addObserver(NewTrainInformation newTrainInformation){
        this.newTrainInformations.add(newTrainInformation);
    }
    public void removeObserver(NewTrainInformation newTrainInformation){
        this.newTrainInformations.remove(newTrainInformation);
    }

    public void setNews(String news) {
        this.news = news;
        for(NewTrainInformation newTrainInformation : this.newTrainInformations){
            newTrainInformation.update(this.news);
        }
    }

}
