package com.example.meetchecker.ui.classes;


import android.os.AsyncTask;
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
import com.example.meetchecker.entities.Class;

import java.util.List;

public class ClassesFragment extends Fragment {

    private ClassesViewModel classesViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        classesViewModel = ViewModelProviders.of(getActivity()).get(ClassesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_classes, container, false);
        final ListView minhasClasses = (ListView) root.findViewById(R.id.minhas_classes);

        new AsyncTask<Void, Void, List<Class>>(){

            @Override
            protected List<Class> doInBackground(Void... voids) {
                return classesViewModel.getClasses();
            }

            @Override
            protected void onPostExecute(List<Class> classes) {
                super.onPostExecute(classes);
                if(classes != null && classes.size() > 0){
                    minhasClasses.setAdapter(new ClassesToClasseItemAdapter(classes, getActivity()));
                }
            }
        }.execute();

        return root;
    }
}