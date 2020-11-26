package com.example.meetchecker.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.meetchecker.dal.ClassDAO;
import com.example.meetchecker.dal.PresenceDAO;
import com.example.meetchecker.dal.ProfileDAO;
import com.example.meetchecker.entities.Presence;
import com.example.meetchecker.entities.Profile;
import com.example.meetchecker.entities.Class;


@Database(entities = {Presence.class, Class.class, Profile.class}, version = 3)
@TypeConverters(LocalDateTimeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PresenceDAO presenceDAO();
    public abstract ClassDAO classDAO();
    public abstract ProfileDAO profileDAO();
}
