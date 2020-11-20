package pl.mobile.divinumofficium.fragments.prima;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrimaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PrimaViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("Prima");
    }

    public LiveData<String> getText() {return mText; }
}
