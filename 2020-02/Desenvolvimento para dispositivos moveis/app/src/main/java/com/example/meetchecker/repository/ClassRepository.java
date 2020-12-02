package com.example.meetchecker.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.meetchecker.dal.ClassDAO;
import com.example.meetchecker.entities.Class;
import com.example.meetchecker.utils.AppDatabase;
import com.example.meetchecker.utils.SingletonDatabase;

import java.util.List;

public class ClassRepository {
    private ClassDAO classDAO;
    public ClassRepository(Application application){
        AppDatabase db = SingletonDatabase.getInstance(application);
        classDAO = db.classDAO();
    }

    public void insert(Class class_) {
        new InsertClassAsyncTask(classDAO).execute(class_);
    }

    public List<Class> getAllClasses() {
        return classDAO.getAllClasses();
    }
}
