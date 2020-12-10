package com.example.meetchecker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meetchecker.dto.QrCodeDTO;
import com.example.meetchecker.utils.LocalDateTimeSerializer;
import com.google.gson.GsonBuilder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.time.LocalDateTime;

public class QrCodeActivity extends AppCompatActivity {
    ImageView imgQrCode;
    QrCodeDTO qrCodeDTO;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        inicializaeComponents();
        gerarQrCode();
    }

    private void gerarQrCode() {
        String texto = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create().toJson(qrCodeDTO);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(texto, BarcodeFormat.QR_CODE, 350, 350);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imgQrCode.setImageBitmap(bitmap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void inicializaeComponents() {
        Intent intent = getIntent();
        qrCodeDTO = (QrCodeDTO)intent.getSerializableExtra("qrCodeDto");
        imgQrCode = (ImageView)findViewById(R.id.imgQrCode);
    }
}
