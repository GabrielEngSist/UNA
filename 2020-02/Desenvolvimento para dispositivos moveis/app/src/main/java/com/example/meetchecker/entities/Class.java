package com.example.meetchecker.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.UUID;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "class")
public class Class implements Serializable {
    @PrimaryKey(autoGenerate = true) protected int id;
    @NonNull protected String guidId;
    @NonNull protected String name;
    protected String profileId;
    public String getGuidId() { return guidId; }
    public void setGuidId(String guidId) { this.guidId = guidId; }
    public String getProfileId() { return profileId; }
    public void setProfileId(String profileId) { this.profileId = profileId; }
    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }
}
