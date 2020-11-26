package com.example.meetchecker.ui.classes;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.meetchecker.MainActivity;
import com.example.meetchecker.R;
import com.example.meetchecker.adapters.ClassesToClasseItemAdapter;

import java.util.List;

public class ClassesFragment extends Fragment {

    private ClassesViewModel classesViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        classesViewModel = ViewModelProviders.of(this).get(ClassesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_classes, container, false);
        final ListView minhasClasses = (ListView) root.findViewById(R.id.minhas_classes);

        classesViewModel.getClasses().observe(getViewLifecycleOwner(), new Observer<List<com.example.meetchecker.entities.Class>>() {
            @Override
            public void onChanged(@Nullable List<com.example.meetchecker.entities.Class> classes) {
                minhasClasses.setAdapter(new ClassesToClasseItemAdapter(classes, getActivity()));
            }
        });

        return root;
    }
}