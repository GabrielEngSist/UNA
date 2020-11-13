package br.com.controleDeDespesas.singleton;

import android.content.Context;

import androidx.room.Room;

import br.com.controleDeDespesas.util.AppDatabase;

public class SingletonDatabase {
    private static AppDatabase appDatabase = null;
    private SingletonDatabase(){}

    public static AppDatabase getInstace(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "expenses.sqlite").build();
        }
        return  appDatabase;
    }
}
