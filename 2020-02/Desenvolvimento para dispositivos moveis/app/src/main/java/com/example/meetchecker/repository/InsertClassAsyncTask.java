package com.example.meetchecker.repository;

import android.os.AsyncTask;

import com.example.meetchecker.dal.ClassDAO;
import com.example.meetchecker.entities.Class;

public class InsertClassAsyncTask extends AsyncTask<Class, Void, Void> {

    private ClassDAO classDAO;

    InsertClassAsyncTask(ClassDAO dao) {
        classDAO = dao;
    }

    @Override
    protected Void doInBackground(final Class... params) {
        classDAO.insert(params[0]);
        return null;
    }
}
