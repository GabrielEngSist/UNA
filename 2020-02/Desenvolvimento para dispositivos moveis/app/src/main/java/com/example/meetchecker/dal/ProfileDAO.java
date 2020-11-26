package com.example.meetchecker.dal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meetchecker.entities.Presence;
import com.example.meetchecker.entities.PresenceWithClass;
import com.example.meetchecker.entities.Profile;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface ProfileDAO {
    @Insert
    public void insert(Profile... profiles);

    @Update
    public void update(Profile... profiles);

    @Delete
    public void delete(List<Presence> presences);

    @Query("SELECT * FROM Profile")
    public List<Profile> getAllProfiles();

    @Query("SELECT * FROM Profile WHERE guidId = :id")
    public Profile getProfileById(String id);
}
