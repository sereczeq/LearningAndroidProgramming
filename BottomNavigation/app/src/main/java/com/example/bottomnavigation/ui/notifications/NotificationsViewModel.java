package com.example.bottomnavigation.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is right fragment");
    }

    public void setText(String s)
    {
        mText.setValue(s);
    }

    public void resetText()
    {
        mText.setValue("This is right fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}