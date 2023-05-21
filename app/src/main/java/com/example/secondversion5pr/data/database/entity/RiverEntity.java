package com.example.secondversion5pr.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.secondversion5pr.data.model.River;

@Entity(tableName = "river_table")
public class RiverEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int image;

    public RiverEntity(@NonNull int image, String name) {
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public River toRiver() {
        return new River(this.image, this.name);
    }
}
