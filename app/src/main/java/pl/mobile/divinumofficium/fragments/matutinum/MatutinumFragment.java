package pl.mobile.divinumofficium.fragments.matutinum;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.mobile.divinumofficium.R;
import pl.mobile.divinumofficium.fragments.prima.PrimaViewModel;

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

        final TextView textView = root.findViewById(R.id.prima_txt);
        matutinumViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        matutinumViewModel = new ViewModelProvider(this).get(MatutinumViewModel.class);

    }

}