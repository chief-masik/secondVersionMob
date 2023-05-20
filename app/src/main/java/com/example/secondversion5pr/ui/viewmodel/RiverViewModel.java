package com.example.secondversion5pr.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.secondversion5pr.data.model.River;
import com.example.secondversion5pr.data.repository.RiverRepository;

import java.util.List;

public class RiverViewModel extends ViewModel {
    public LiveData<List<River>> rivers;
    private static final RiverRepository riverRepository = new RiverRepository();
    public RiverViewModel() {
        initialization();
    }
    private void initialization(){
        rivers = riverRepository.getData();
    }
}
