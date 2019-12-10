package com.example.kaistcampusv2.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to our digitalized international student handbook. Hope it will help you to get familiar with the campus and more.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}