package com.example.secondversion5pr.data.repository;

import androidx.lifecycle.LiveData;

import com.example.secondversion5pr.data.datasource.RiverSource;
import com.example.secondversion5pr.data.model.River;

import java.util.List;

public class RiverRepository {

    private LiveData<List<River>> rivers;
    public RiverRepository() {
        rivers = RiverSource.getRivers();
    }
    public LiveData<List<River>> getData() {
        return rivers;
    }
}
