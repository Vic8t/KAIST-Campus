package com.example.kaistcampusv2.ui.facilities;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FacilitiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FacilitiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is facilities fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}