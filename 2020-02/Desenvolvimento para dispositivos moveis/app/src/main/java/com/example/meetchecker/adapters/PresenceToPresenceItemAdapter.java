package com.example.meetchecker.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.meetchecker.R;
import com.example.meetchecker.entities.PresenceWithClass;

import java.time.format.DateTimeFormatter;
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
        if(this._presences == null){
            return 0;
        }
        return this._presences.size();    }

    @Override
    public PresenceWithClass getItem(int position) {
        return this._presences.get(position);
    }

    @Override
    public long getItemId(int position) {
        if(this._presences == null){
            return 0;
        }
        return this._presences.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");


        View view                       = _activity.getLayoutInflater().inflate(R.layout.presence_item,parent,false);
        PresenceWithClass presence      = this._presences.get(position);
        TextView _class                 = view.findViewById(R.id.txtClass);
        TextView attendanceDate         = view.findViewById(R.id.txtAttendanceDate);
        TextView details                = view.findViewById(R.id.txtDetails);
        TextView overall                = view.findViewById(R.id.txtOverall);

        _class.setText(presence._class.getName());
        attendanceDate.setText("Presença registrada dia " + df.format(presence.presence.getDate()) + " às " +  tf.format(presence.presence.getDate()) );
        details.setText("");
        overall.setText(presence.presence.getReviewText());

        return view;
    }
}
