package pl.mobile.divinumofficium.fragments.prima;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.mobile.divinumofficium.R;

public class PrimaFragment extends Fragment {

    private PrimaViewModel primaViewModel;

    public PrimaFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        primaViewModel = new ViewModelProvider(this).get(PrimaViewModel.class);
        View root = inflater.inflate(R.layout.prima_fragment, container, false);

        final TextView textView = root.findViewById(R.id.prima_txt);
        primaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}