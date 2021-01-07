package pl.mobile.divinumofficium.officium.fragments.matutinum;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.mobile.divinumofficium.R;

public class MatutinumFragment extends Fragment {

    private MatutinumViewModel matutinumViewModel;

    public static MatutinumFragment newInstance() {
        return new MatutinumFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        matutinumViewModel = new ViewModelProvider(this).get(MatutinumViewModel.class);
        View root = inflater.inflate(R.layout.matutinum_fragment, container, false);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        matutinumViewModel = new ViewModelProvider(this).get(MatutinumViewModel.class);

    }

}