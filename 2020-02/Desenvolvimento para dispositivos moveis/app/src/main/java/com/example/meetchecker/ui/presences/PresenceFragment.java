package com.example.meetchecker.ui.presences;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.meetchecker.R;
import com.example.meetchecker.adapters.PresenceToPresenceItemAdapter;
import com.example.meetchecker.entities.PresenceWithClass;

import java.util.List;

public class PresenceFragment extends Fragment {

    private PresenceViewModel presenceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        presenceViewModel = ViewModelProviders.of(getActivity()).get(PresenceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_presences, container, false);
        final ListView minhasPresencas = (ListView) root.findViewById(R.id.minhas_presencas);
        new AsyncTask<Void, Void, List<PresenceWithClass>>(){

            @Override
            protected List<PresenceWithClass> doInBackground(Void... voids) {
                return presenceViewModel.getAllPresences();
            }

            @Override
            protected void onPostExecute(List<PresenceWithClass> presenceWithClasses) {
                super.onPostExecute(presenceWithClasses);
                if(presenceWithClasses != null && presenceWithClasses.size() > 0){
                    minhasPresencas.setAdapter(new PresenceToPresenceItemAdapter(presenceWithClasses, getActivity()));
                }
            }
        }.execute();

        return root;
    }
}