package com.prova.alarme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarme Acionado", Toast.LENGTH_LONG).show();
        Intent alarme = new Intent(context, AlarmActivity.class);
        context.getApplicationContext().startActivity(alarme);
    }
}
