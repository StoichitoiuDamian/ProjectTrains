package com.example.demo.observer;




import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainNews {


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
