package com.example.meetchecker.ui.profile;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.meetchecker.QrCodeActivity;
import com.example.meetchecker.R;
import com.example.meetchecker.dto.QrCodeDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.UUID;

public class GenerateQrCodeFragment extends Fragment {

    private EditText etxStart;
    private EditText etxEnd;
    private EditText etxDate;
    private EditText etxName;
    private Button btnSave;
    private GenerateQrCodeViewModel generateQrCodeViewModel;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        initializeProperties(inflater, container);
        setOnClickListeners();

        return root;
    }

    private void setOnClickListeners() {
        setOnClickListenerEtxTime(root, etxStart);
        setOnClickListenerEtxTime(root, etxEnd);
        setOnClickListenerEtxTime(root, etxDate);
        enableRules();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QrCodeDTO qrCodeDto = new QrCodeDTO();
                qrCodeDto.setClassId(UUID.randomUUID().toString());
                qrCodeDto.setId(UUID.randomUUID().toString());
                qrCodeDto.setClassName(etxName.getText().toString());
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(etxDate.getText().toString(), formato);
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime startTime = LocalTime.parse(etxStart.getText().toString(), formatoHora);
                LocalTime endTime =  LocalTime.parse(etxEnd.getText().toString(), formatoHora);

                qrCodeDto.setStartDate(LocalDateTime.of(date.getYear(),date.getMonth(), date.getDayOfMonth(), startTime.getHour(), startTime.getMinute(), 0));
                qrCodeDto.setFinishDate(LocalDateTime.of(date.getYear(),date.getMonth(), date.getDayOfMonth(), endTime.getHour(), endTime.getMinute(), 0));

                Intent intent = new Intent(root.getContext(), QrCodeActivity.class);
                intent.putExtra("qrCodeDto", qrCodeDto);
                startActivity(intent);
            }
        });
    }

    private void enableRules() {
        etxStart.setEnabled(false);
        etxEnd.setEnabled(false);
        etxDate.setEnabled(false);
        btnSave.setEnabled(false);

        etxName.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(s.toString().trim().length()>0){
                            etxDate.setEnabled(true);
                        }else {
                            etxDate.setText("");
                            etxDate.setEnabled(false);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        etxDate.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(s.toString().trim().length()>0){
                            etxStart.setEnabled(true);
                        }else{
                            etxStart.setText("");
                            etxStart.setEnabled(false);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        etxStart.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(s.toString().trim().length()>0){
                            etxEnd.setEnabled(true);
                        }else{
                            etxEnd.setText("");
                            etxEnd.setEnabled(false);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

        etxEnd.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(s.toString().trim().length()>0){
                            btnSave.setEnabled(true);
                        }else{
                            btnSave.setEnabled(false);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );
    }

    private void initializeProperties(@NonNull LayoutInflater inflater, ViewGroup container) {
        generateQrCodeViewModel = ViewModelProviders.of(this).get(GenerateQrCodeViewModel.class);
        root = inflater.inflate(R.layout.fragment_generate_qr_code, container, false);
        etxName = (EditText)root.findViewById(R.id.etxName);
        etxStart = (EditText)root.findViewById(R.id.etxStart);
        etxEnd = (EditText)root.findViewById(R.id.etxEnd);
        etxDate = (EditText)root.findViewById(R.id.etxDate);
        btnSave = (Button)root.findViewById(R.id.btnSave);
    }

    private void setOnClickListenerEtxTime(View root, EditText editText) {
        editText.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();

                if(editText.getInputType() == 36){
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker = new TimePickerDialog(root.getContext(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            editText.setText((selectedHour < 10 ? "0" : "") + selectedHour + ":" + (selectedMinute < 10 ? "0" : "") + selectedMinute);
                        }
                    }, hour, minute, true);
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();
                }
                if(editText.getInputType() == 131073){
                    int dayOfMonth = mcurrentTime.get(Calendar.DAY_OF_MONTH);
                    int month = mcurrentTime.get(Calendar.MONTH);
                    int year = mcurrentTime.get(Calendar.YEAR);
                    DatePickerDialog mTimePicker = new DatePickerDialog(root.getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            Integer correctMonth = (month + 1);
                            editText.setText((dayOfMonth < 10 ? "0" : "") + dayOfMonth + "/" + (correctMonth < 10 ? "0" : "") + correctMonth + "/" + year);
                        }
                    }, year, month, dayOfMonth);
                    mTimePicker.setTitle("Select Time");
                    mTimePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                    mTimePicker.show();
                }
            }
        });
    }
}