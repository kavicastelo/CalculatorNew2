package com.example.calculatornew2.ui.home;

import android.widget.ImageButton;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculatornew2.database;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("KEEP YOUR PRIVACY..");
    }

    public LiveData<String> getText() {
        return mText;
    }
}