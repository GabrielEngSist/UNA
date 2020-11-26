package com.example.meetchecker.utils;

import android.content.Context;

import androidx.room.Room;

public class SingletonDatabase {
    private static AppDatabase appDatabase = null;

    private SingletonDatabase(){}
    public static AppDatabase getInstance(final Context context){
        if( appDatabase == null ){
            synchronized (AppDatabase.class){
                if( appDatabase == null){
                    appDatabase = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "meet_checker" ).fallbackToDestructiveMigration().build();
                }
            }
        }

        return appDatabase;
    }
}
