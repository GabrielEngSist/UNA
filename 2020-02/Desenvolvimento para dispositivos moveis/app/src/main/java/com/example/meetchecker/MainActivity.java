package com.example.meetchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.meetchecker.dto.QrCodeDTO;
import com.example.meetchecker.entities.Class;
import com.example.meetchecker.entities.Presence;
import com.example.meetchecker.utils.AppDatabase;
import com.example.meetchecker.utils.CustomGson;
import com.example.meetchecker.utils.SingletonDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        final Activity activity = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Ler presença");
                integrator.setCameraId(0);
                integrator.initiateScan();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_classes, R.id.nav_presence, R.id.nav_generate_qr_code)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() != null){
                try{
                    final QrCodeDTO qrCodeDTO = CustomGson.getInstance().fromJson(result.getContents(), QrCodeDTO.class);
                    new AsyncTask<QrCodeDTO, Void, Boolean>(){

                        @Override
                        protected Boolean doInBackground(QrCodeDTO... qrCode) {
                            AppDatabase db = SingletonDatabase.getInstance(MainActivity.this);

                            Class _class = db.classDAO().getClassById(qrCode[0].getClassId());
                            if(_class == null){
                                _class = new Class();
                                _class.setGuidId(qrCode[0].getClassId());
                                _class.setName(qrCode[0].getClassName());
                                db.classDAO().insert(_class);
                            }else{
                                _class.setName(qrCode[0].getClassName());
                                db.classDAO().update(_class);
                            }

                            Presence presence = db.presenceDAO().getPresenceById(qrCode[0].getId());
                            if(presence == null){
                                presence = new Presence();
                                presence.setDate(LocalDateTime.now());
                                presence.setClassId(qrCode[0].getClassId());
                                presence.setGuidId(qrCode[0].getId());
                                db.presenceDAO().insert(presence);
                            }else{
                                presence.setDate(LocalDateTime.now());
                                presence.setClassId(qrCode[0].getClassId());
                                db.presenceDAO().update(presence);
                            }
                            return true;
                        }

                        @Override
                        protected void onPostExecute(Boolean aBoolean) {
                            super.onPostExecute(aBoolean);
                            if( aBoolean == true ) {
                                alert("Presença registrada com sucesso");
                                MainActivity.this.setResult(1);
                            }
                        }
                    }.execute(qrCodeDTO);
                }catch (Exception ex){
                    alert("Falha ao registrar presença");
                    MainActivity.this.setResult(0);
                }

            }else{
                alert("Não foi possível realizar a leitura");
                MainActivity.this.setResult(0);
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void alert(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}