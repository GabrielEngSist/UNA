package com.prova.alarme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Trim, Trim, Trim", Toast.LENGTH_LONG).show();
        Intent alarme = new Intent(context, AlarmActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(alarme);
    }
}
