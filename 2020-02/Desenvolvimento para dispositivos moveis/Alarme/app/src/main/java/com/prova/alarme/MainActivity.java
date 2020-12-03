package com.prova.alarme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.prova.alarme.utils.MaskEditUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    private EditText etxtTime;
    private CheckBox chkMonday, chkTuesday, chkWednesday, chkThursday, chkFriday, chkSaturday, chkSunday;
    private Button btnAgendar;

    private List<CheckBox> daysOfWeek;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sp = getSharedPreferences("appAgendar", getApplicationContext().MODE_PRIVATE);
        initializeDaysOfWeek(sp);
        alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        btnAgendar = findViewById(R.id.btnSetAlarm);
        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                Long startTime = calendar.getTimeInMillis();
                SharedPreferences.Editor spEditor = sp.edit();
                spEditor.putString("daysOfWeek",  getStringFromDaysOfWeekCheckBoxList());
                spEditor.putString("hour", etxtTime.getText().toString());
                spEditor.apply();
                LocalTime localTime = LocalTime.parse(etxtTime.getText());
                calendar.add(Calendar.HOUR_OF_DAY,localTime.getHour());
                calendar.add(Calendar.MINUTE,localTime.getMinute());

                for (int i = 0; i < daysOfWeek.size() ; i++) {
                    if(daysOfWeek.get(i).isChecked()){
                        calendar.add(Calendar.DAY_OF_WEEK, i+1);
                    }
                }

                Long endTime = calendar.getTimeInMillis();
                Long timeAlarm = endTime - startTime;

                alarmManager.set(AlarmManager.RTC_WAKEUP, timeAlarm, pendingIntent);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeAlarm, pendingIntent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initializeDaysOfWeek(SharedPreferences sp) {
        etxtTime = findViewById(R.id.etxtTime);
        etxtTime.addTextChangedListener(MaskEditUtil.mask(etxtTime));
        chkSunday = findViewById(R.id.chkSunday);
        chkTuesday = findViewById(R.id.chkTuesday);
        chkWednesday = findViewById(R.id.chkWednesday);
        chkThursday = findViewById(R.id.chkThursday);
        chkFriday = findViewById(R.id.chkFriday);
        chkSaturday = findViewById(R.id.btnSabado);
        chkMonday = findViewById(R.id.chkMonday);
        daysOfWeek = new ArrayList<>();
        daysOfWeek.add(chkSunday);
        daysOfWeek.add(chkMonday);
        daysOfWeek.add(chkTuesday);
        daysOfWeek.add(chkWednesday);
        daysOfWeek.add(chkThursday);
        daysOfWeek.add(chkFriday);
        daysOfWeek.add(chkSaturday);

        final String daysOfWeekString = sp.getString("daysOfWeek", getStringFromDaysOfWeekCheckBoxList());
        etxtTime.setText(sp.getString("hour","00:00"));
        final List<Boolean> valoresMarcados = getBoolValuesFromArrayString(daysOfWeekString);
        for (int i = 0; i < daysOfWeek.size() ; i++) {
            daysOfWeek.get(i).setChecked(valoresMarcados.get(i));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String getStringFromDaysOfWeekCheckBoxList(){
        List<String> aux = new ArrayList<>();
        for (CheckBox c: daysOfWeek){
            aux.add(String.valueOf(c.isChecked()));
        }

        return String.join("|",aux);
    }

    private List<Boolean> getBoolValuesFromArrayString(String arrayOfBooleans){
        List<Boolean> resultado = new ArrayList<>();
        String[] aux = arrayOfBooleans.split("\\|");

        for (String a : aux){
            resultado.add(Boolean.parseBoolean(a));
        }

        return  resultado;
    }
}