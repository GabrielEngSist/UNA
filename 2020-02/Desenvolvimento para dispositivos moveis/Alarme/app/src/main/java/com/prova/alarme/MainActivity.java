package com.prova.alarme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    protected EditText txtHora;
    protected CheckBox btnSegunda, btnTerca, btnQuarta, btnQuinta, btnSexta, btnSabado, btnDomingo;
    protected Button btnAgendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHora = findViewById(R.id.txtHora);
        btnSegunda = findViewById(R.id.btnSegunda);
        btnTerca = findViewById(R.id.btnTerca);
        btnQuarta = findViewById(R.id.btnQuarta);
        btnQuinta = findViewById(R.id.btnQuinta);
        btnSexta = findViewById(R.id.btnSexta);
        btnSabado = findViewById(R.id.btnSabado);
        btnDomingo = findViewById(R.id.btnDomingo);
        btnAgendar = findViewById(R.id.btnAgendar);

        final SharedPreferences sharedPreferences = getSharedPreferences("appAgendar", getApplicationContext().MODE_PRIVATE);

        final Boolean Segunda = sharedPreferences.getBoolean("segunda", btnSegunda.isChecked());
        btnSegunda.setChecked(Segunda);
        final Boolean Terca = sharedPreferences.getBoolean("terca", btnTerca.isChecked());
        btnTerca.setChecked(Terca);
        final Boolean Quarta = sharedPreferences.getBoolean("quarta", btnQuarta.isChecked());
        btnQuarta.setChecked(Quarta);
        final Boolean Quinta = sharedPreferences.getBoolean("quinta", btnQuinta.isChecked());
        btnQuinta.setChecked(Quinta);
        final Boolean Sexta = sharedPreferences.getBoolean("sexta", btnSexta.isChecked());
        btnSexta.setChecked(Sexta);
        final Boolean Sabado = sharedPreferences.getBoolean("sabado", btnSabado.isChecked());
        btnSabado.setChecked(Sabado);
        final Boolean Domingo = sharedPreferences.getBoolean("domingo", btnDomingo.isChecked());
        btnDomingo.setChecked(Domingo);

        alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                Long timeInMiliANTES = calendar.getTimeInMillis();
                System.out.println(timeInMiliANTES);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("segunda", btnSegunda.isChecked());
                editor.putBoolean("terca", btnTerca.isChecked());
                editor.putBoolean("quarta", btnQuarta.isChecked());
                editor.putBoolean("quinta", btnQuinta.isChecked());
                editor.putBoolean("sexta", btnSexta.isChecked());
                editor.putBoolean("sabado  ", btnSabado.isChecked());
                editor.putBoolean("domingo", btnDomingo.isChecked());
                editor.apply();


                //Pegar hora e minuto do tempo digitado   1530
                String hora = txtHora.getText().toString().substring(0, 2); //15
                String minuto = txtHora.getText().toString().substring(2, 4); //30

                //Inserir no Calendar a hora e minuto
                calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(hora));
                calendar.add(Calendar.MINUTE, Integer.parseInt(minuto));


                if(btnSegunda.isChecked()){calendar.add(Calendar.DAY_OF_WEEK, 2);}
                if(btnTerca.isChecked()){calendar.add(Calendar.DAY_OF_WEEK, 3);}
                if(btnQuarta.isChecked()){calendar.add(Calendar.DAY_OF_WEEK, 4);}
                if(btnQuinta.isChecked()){calendar.add(Calendar.DAY_OF_WEEK, 5);}
                if(btnSexta.isChecked()){calendar.add(Calendar.DAY_OF_WEEK, 6);}
                if(btnSabado.isChecked()){calendar.add(Calendar.DAY_OF_WEEK, 7);}
                if(btnDomingo.isChecked()){calendar.add(Calendar.DAY_OF_WEEK, 1);}

                Long timeInMiliDEPOIS = calendar.getTimeInMillis();
                System.out.println(timeInMiliDEPOIS);

                Long timeAlarm = timeInMiliDEPOIS - timeInMiliANTES;

                alarmManager.set(AlarmManager.RTC_WAKEUP, timeAlarm, pendingIntent);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeAlarm, pendingIntent);
            }
        });

    }
}