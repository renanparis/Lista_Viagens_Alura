package com.paris.aluratravels.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {


    public static final String DAY_AND_MONTH = "dd/MM";

    public static  String formatDateInText(int days) {
        
        Calendar departureDate = Calendar.getInstance();
        Calendar returnDate = Calendar.getInstance();
        returnDate.add(Calendar.DATE, days);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DAY_AND_MONTH);
        String departureDateFormatted = dateFormat.format(departureDate.getTime());
        String returnDateFormatted = dateFormat.format(returnDate.getTime());
        return departureDateFormatted + " - "
                + returnDateFormatted + " de " + returnDate.get(Calendar.YEAR);
    }
}
