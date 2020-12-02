package com.example.meetchecker.ui.classes;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meetchecker.entities.Class;
import com.example.meetchecker.repository.ClassRepository;


import java.util.List;

public class ClassesViewModel extends AndroidViewModel {

    private ClassRepository classRepository;

    public ClassesViewModel(Application application) {
        super(application);
        classRepository = new ClassRepository(application);
    }

    public List<com.example.meetchecker.entities.Class> getClasses() {
        return classRepository.getAllClasses();
    }

    public void insert(Class class_){
        classRepository.insert(class_);
    }
}