package com.example.meetchecker.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meetchecker.R;
import com.example.meetchecker.entities.PresenceWithClass;

import java.util.List;

public class PresenceToPresenceItemAdapter extends BaseAdapter {

    private final Activity _activity;
    private final List<PresenceWithClass> _presences;

    public PresenceToPresenceItemAdapter(List<PresenceWithClass> presences, Activity activity){
        this._presences = presences;
        this._activity = activity;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view                       = _activity.getLayoutInflater().inflate(R.layout.presence_item,parent,false);
        PresenceWithClass presence      = this._presences.get(position);
        TextView _class                 = view.findViewById(R.id.txtClass);
        TextView attendanceDate         = view.findViewById(R.id.txtAttendanceDate);
        TextView details                = view.findViewById(R.id.txtDetails);
        TextView overall                 = view.findViewById(R.id.txtOverall);

        _class.setText(presence._class.getName());
        attendanceDate.setText("");
        details.setText("");
        overall.setText("");

        return view;
    }
}
