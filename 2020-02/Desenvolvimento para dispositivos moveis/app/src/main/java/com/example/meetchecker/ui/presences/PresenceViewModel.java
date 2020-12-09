package com.example.meetchecker.ui.presences;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.meetchecker.entities.PresenceWithClass;
import com.example.meetchecker.repository.PresenceRepository;

import java.util.List;

public class PresenceViewModel extends AndroidViewModel {

    private PresenceRepository presenceRepository;

    public PresenceViewModel(Application application) {
        super(application);
        presenceRepository = new PresenceRepository(application);
    }

    public List<PresenceWithClass> getAllPresences() {
        return this.presenceRepository.getAllPresences();
    }
}