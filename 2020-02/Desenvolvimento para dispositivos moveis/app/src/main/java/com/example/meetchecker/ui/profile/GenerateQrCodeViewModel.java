package com.example.meetchecker.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GenerateQrCodeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GenerateQrCodeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}