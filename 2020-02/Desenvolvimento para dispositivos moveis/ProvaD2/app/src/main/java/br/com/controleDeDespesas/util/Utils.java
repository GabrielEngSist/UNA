package br.com.controleDeDespesas.util;

import java.text.*;
import java.util.Locale;

public class Utils {
    private static Locale localeBR = new Locale("pt", "BR");
    public static String doubleToCurrencyPtBR(Double total) {
        NumberFormat brCurrency = NumberFormat.getCurrencyInstance(localeBR);
        return brCurrency.format(total);
    }

    public static Double getDoubleFromString(String stringDouble)  {
        try{
            return NumberFormat.getCurrencyInstance(localeBR).parse(stringDouble).doubleValue();
        }catch (ParseException e){
            e.printStackTrace();
            String cleanString = stringDouble.replaceAll("\\D", "");
            try {
                double money = Double.parseDouble(cleanString);
                return money / 100;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return 0.0;
    }
}
