package com.example.calculatornew2.ui.follow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FollowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FollowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Click Icon to follow us on Social media...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
