package com.example.meetchecker.repository;

import android.app.Application;

import com.example.meetchecker.dal.PresenceDAO;
import com.example.meetchecker.entities.PresenceWithClass;
import com.example.meetchecker.utils.AppDatabase;
import com.example.meetchecker.utils.SingletonDatabase;

import java.util.List;

public class PresenceRepository {
    private PresenceDAO presenceDAO;
    public PresenceRepository(Application application){
        AppDatabase db = SingletonDatabase.getInstance(application);
        presenceDAO = db.presenceDAO();
    }

    public List<PresenceWithClass> getAllPresences(){
        return presenceDAO.loadPresencesWithClass();
    }
}
