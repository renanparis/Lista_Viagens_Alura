package com.paris.aluratravels.util;

public class DaysUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formatDaysInText(int numberOfDays) {
        
        if (numberOfDays > 1){
          return numberOfDays + PLURAL;
      
        }
        return numberOfDays + SINGULAR;
    }
}
