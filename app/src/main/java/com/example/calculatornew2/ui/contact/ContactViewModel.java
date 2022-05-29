package com.example.calculatornew2.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ContactViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("You can contact the developer for giving feedback for this application. It " +
                "will very helpful to improve and modification the new version of Calculator. " +
                "If you using this application getting some issues kindly contact me. Click " +
                "following icons to contact developer. \n\n Kavi castelo");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
