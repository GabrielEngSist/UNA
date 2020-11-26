package com.example.meetchecker.ui.presences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.meetchecker.R;
import com.example.meetchecker.adapters.PresenceToPresenceItemAdapter;

public class PresenceFragment extends Fragment {

    private PresenceViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PresenceToPresenceItemAdapter adapter = new PresenceToPresenceItemAdapter(null, null);
        homeViewModel =
                ViewModelProviders.of(this).get(PresenceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_presences, container, false);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}