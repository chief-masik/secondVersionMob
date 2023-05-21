package com.example.secondversion5pr.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.secondversion5pr.data.model.Lake;
import com.example.secondversion5pr.ui.repository.LakeRepository;

import java.util.List;

public class LakeViewModel extends ViewModel {

    public LiveData<List<Lake>> lakes;
    private static final LakeRepository lakeRepository = new LakeRepository();
    public LakeViewModel() {
        initialization();
    }
    private void initialization(){
        lakes = lakeRepository.getData();
    }
}
