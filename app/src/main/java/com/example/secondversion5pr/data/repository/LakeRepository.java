package com.example.secondversion5pr.data.repository;

import androidx.lifecycle.LiveData;

import com.example.secondversion5pr.data.datasource.LakeSource;
import com.example.secondversion5pr.data.model.Lake;

import java.util.List;

public class LakeRepository {

    private LiveData<List<Lake>> lakes;
    public LakeRepository() {
        lakes = LakeSource.getLakes();
    }
    public LiveData<List<Lake>> getData() {
        return lakes;
    }
}
