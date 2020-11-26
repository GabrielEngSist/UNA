package com.example.meetchecker.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.meetchecker.R;
import com.example.meetchecker.entities.Class;

import java.util.List;

public class ClassesToClasseItemAdapter extends BaseAdapter {
    private List<Class> _classes;
    private Activity _activity;

    public ClassesToClasseItemAdapter(List<Class> classes, Activity activity) {
        this._classes = classes;
        this._activity = activity;
    }

    @Override
    public int getCount() {
        if(this._classes == null){
            return 0;
        }
        return this._classes.size();
    }

    @Override
    public Class getItem(int position) {
        return this._classes.get(position);
    }

    @Override
    public long getItemId(int position) {
        if(this._classes == null){
            return 0;
        }
        return this._classes.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = _activity.getLayoutInflater().inflate(R.layout.activity_classe_item, parent, false);
        Class class_ = this._classes.get(position);
        TextView txtClass = view.findViewById(R.id.txtClass);

        txtClass.setText(class_.getName());

        return view;
    }
}
