package com.example.calculatornew2.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This application is build for improve your privacy. Calculator V1.0 can hide " +
                "4 types of files from your gallery. You can change the security key after register to " +
                "the application. Default security key is 1111. This is basic type software and I hope to " +
                "improve. When you using this application getting bugs please contact me. This is free " +
                "application and ENJOY!! ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
