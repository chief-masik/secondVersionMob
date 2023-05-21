package com.example.secondversion5pr.ui.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.secondversion5pr.data.database.RoomDataBase.RiverRoomDataBase;
import com.example.secondversion5pr.data.database.dao.RiverDao;
import com.example.secondversion5pr.data.database.entity.RiverEntity;
import com.example.secondversion5pr.data.model.River;

import java.util.List;
import java.util.stream.Collectors;

public class RiverRepository {

    private final RiverDao riverDao;
    private LiveData<List<River>> rivers;
    private final Context context;
    RiverRoomDataBase roomDataBase;

    public RiverRepository(Context appContext) {
        context = appContext;
        roomDataBase = RiverRoomDataBase.getDatabase(appContext);
        riverDao = RiverRoomDataBase.getDatabase(appContext).riverDao();
        rivers = Transformations.map(riverDao.getAllRivers(), entities -> entities.stream()
                .map(RiverEntity::toRiver).collect(Collectors.toList()));
    }
    public LiveData<List<River>> getAll() {
        return rivers;
    }
    public void insert(RiverEntity river) {
        RiverRoomDataBase.databaseWriteExecutor
                .execute(() -> riverDao.insert(river));
    }
}
