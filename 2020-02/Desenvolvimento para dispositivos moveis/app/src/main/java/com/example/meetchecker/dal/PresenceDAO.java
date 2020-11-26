package com.example.meetchecker.dal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.meetchecker.entities.Presence;
import com.example.meetchecker.entities.PresenceWithClass;

import java.util.List;

@Dao
public interface PresenceDAO {
    @Insert
    public void insert(Presence... presences);

    @Update
    public void update(Presence... presences);

    @Delete
    public void delete(List<Presence> presences);

    @Query("SELECT c.*, p.* FROM Presence p INNER JOIN Class c on c.guidId == p.classId")
    public List<PresenceWithClass> loadPresencesWithClass();

    @Query("SELECT * FROM Presence WHERE guidId = :id")
    public Presence getPresenceById(String id);
}
