package com.example.meetchecker.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "profile")
public class Profile {
    @PrimaryKey(autoGenerate = true) protected int id;

    protected String guidId;
    protected String name;
    protected String key;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getGuidId() { return guidId; }
    public void setGuidId(String guidId) { this.guidId = guidId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
}
