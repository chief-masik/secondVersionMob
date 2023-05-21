package com.example.secondversion5pr.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.AndroidViewModel;

import com.example.secondversion5pr.data.database.entity.RiverEntity;
import com.example.secondversion5pr.data.model.River;
import com.example.secondversion5pr.ui.repository.RiverRepository;

import java.util.List;

public class RiverViewModel extends AndroidViewModel {
    public LiveData<List<River>> rivers;
    private RiverRepository riverRepository;
    public RiverViewModel(Application application) {
        super(application);
        riverRepository = new RiverRepository(application);
        rivers = riverRepository.getAll();
    }
    public LiveData<List<River>> getAllCars() {
        return rivers;
    }

    public void insert(River river) {
        riverRepository.insert(new RiverEntity(river.getImage(), river.getNameItem()));
    }
}
