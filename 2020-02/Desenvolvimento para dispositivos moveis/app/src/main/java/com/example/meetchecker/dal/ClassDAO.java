package com.example.meetchecker.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meetchecker.entities.Class;

import java.util.List;
import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface ClassDAO {
    @Insert
    public void insert(Class... presences);

    @Update
    public void update(Class... presences);

    @Delete
    public void delete(List<Class> presences);

    @Query("SELECT * FROM Class")
    public LiveData<List<Class>> getAllClasses();

    @Query("SELECT * FROM Class WHERE guidId = :id")
    public Class getClassById(String id);
}
