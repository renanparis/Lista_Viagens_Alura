package com.paris.aluratravels.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcerUtil {

    public static Drawable getDrawableText(Context context, String drawableInText) {
        Resources resources = context.getResources();
        int idDrwaable = resources.getIdentifier(drawableInText, "drawable", context.getPackageName());
        return resources.getDrawable(idDrwaable);
    }



}
