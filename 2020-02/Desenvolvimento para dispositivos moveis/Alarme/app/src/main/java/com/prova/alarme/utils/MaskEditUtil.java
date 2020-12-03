package com.prova.alarme.utils;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import java.time.LocalTime;

public abstract class MaskEditUtil {

    public static final String FORMAT_HOUR = "##:##";

    public static TextWatcher mask(final EditText ediTxt) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            @Override
            public void afterTextChanged(final Editable s) {}

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {}

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                String unpadded = MaskEditUtil.unmask(s.toString());
                if(unpadded.length() > MaskEditUtil.unmask(FORMAT_HOUR).length()){
                    unpadded = unpadded.substring(0,MaskEditUtil.unmask(FORMAT_HOUR).length());
                }
                final String str = unpadded + "0000".substring(unpadded.length());
                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (final char m : FORMAT_HOUR.toCharArray()) {
                    if (m != '#' && str.length() >= old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (final Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                try {
                    LocalTime.parse(mascara);
                    ediTxt.setText(mascara);
                    ediTxt.setSelection(start+1);
                }catch(final Exception ex){
                    ediTxt.setText("00:00");
                    ediTxt.setSelection(0);
                }
            }
        };
    }

    public static String unmask(final String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "").replaceAll("[/]", "").replaceAll("[(]", "").replaceAll("[ ]","").replaceAll("[:]", "").replaceAll("[)]", "");
    }
}