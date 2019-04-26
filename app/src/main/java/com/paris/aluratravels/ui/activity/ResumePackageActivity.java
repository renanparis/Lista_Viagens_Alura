package com.paris.aluratravels.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.paris.aluratravels.R;
import com.paris.aluratravels.model.Packages;
import com.paris.aluratravels.util.DateUtil;
import com.paris.aluratravels.util.DaysUtil;
import com.paris.aluratravels.util.FormatCurrencyUtil;
import com.paris.aluratravels.util.ResourcerUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumePackageActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_package);
        setTitle(TITLE_APPBAR);


        Packages packageSp = new Packages("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        setCity(packageSp);
        setImage(packageSp);
        setDays(packageSp);
        setPrice(packageSp);
        setDate(packageSp);

    }

    private void setDate(Packages packages) {
        TextView date = findViewById(R.id.activity_resume_date_package);
        String dateFormattedPackage = DateUtil.formatDateInText(packages.getDays());
        date.setText(dateFormattedPackage);
    }


    private void setPrice(Packages packages) {
        TextView price = findViewById(R.id.activity_resume_price_package);
        String currencyBr = FormatCurrencyUtil.formatCurrencyBr(packages.getPrice());
        price.setText(currencyBr);
    }

    private void setDays(Packages packages) {
        TextView days = findViewById(R.id.activity_resume_days_package);
        String daysInText = DaysUtil.formatDaysInText(packages.getDays());
        days.setText(daysInText);
    }

    private void setImage(Packages packages) {
        ImageView image = findViewById(R.id.activity_resume_image_package);
        Drawable imageText = ResourcerUtil.getDrawableText(this, packages.getImage());
        image.setImageDrawable(imageText);
    }

    private void setCity(Packages packages) {
        TextView city = findViewById(R.id.activity_resume_city_package);
        city.setText(packages.getCity());
    }
}
