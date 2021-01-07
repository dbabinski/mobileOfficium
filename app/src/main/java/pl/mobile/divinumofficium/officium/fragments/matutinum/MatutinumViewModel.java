package pl.mobile.divinumofficium.officium.fragments.matutinum;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MatutinumViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MatutinumViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("Prima");
    }

    public LiveData<String> getText() {return mText; }
}