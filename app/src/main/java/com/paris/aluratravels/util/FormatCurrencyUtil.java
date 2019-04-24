package com.paris.aluratravels.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatCurrencyUtil {

    public static final String PORTUGUSE = "pt";
    public static final String COUNTRY = "br";
    public static final String FORMAT_ORIGINAL = "R$";
    public static final String FORMAT_WITH_ESPACE = "R$ ";

    public static String formatCurrencyBr(BigDecimal value) {
        NumberFormat formatBr = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUSE, COUNTRY));
        return formatBr.format(value).replace(FORMAT_ORIGINAL, FORMAT_WITH_ESPACE);
    }
}
