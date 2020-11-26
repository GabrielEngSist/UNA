package com.example.meetchecker.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "presence")
public class Presence implements Serializable {
    @PrimaryKey(autoGenerate = true) protected int id;
    @NonNull protected String guidId;
    @NonNull protected LocalDateTime date;
    @NonNull protected String classId;
    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }
    public String getGuidId() { return guidId; }
    public void setGuidId(String guidId) { this.guidId = guidId; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public String getClassId() { return classId; }
    public void setClassId(String classId) { this.classId = classId; }
}
