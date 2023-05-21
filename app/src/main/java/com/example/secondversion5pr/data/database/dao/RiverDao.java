package com.example.secondversion5pr.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.secondversion5pr.data.database.entity.RiverEntity;

import java.util.List;

@Dao
public interface RiverDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(RiverEntity river);

    @Query("DELETE FROM river_table")
    void deleteAll();

    @Query("SELECT * FROM river_table")
    LiveData<List<RiverEntity>> getAllRivers();
}
