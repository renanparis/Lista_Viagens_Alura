package com.paris.aluratravels.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.paris.aluratravels.R;
import com.paris.aluratravels.model.Packages;
import com.paris.aluratravels.util.DaysUtil;
import com.paris.aluratravels.util.FormatCurrencyUtil;
import com.paris.aluratravels.util.ResourcerUtil;

import java.math.BigDecimal;

public class ResumePackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_package);

        

        Packages packageSp = new Packages("São Paulo", "sao_paulo_sp",2, new BigDecimal(243.99));

        TextView city = findViewById(R.id.activity_resume_city_package);
        city.setText(packageSp.getCity());

        ImageView image = findViewById(R.id.activity_resume_image_package);
        Drawable imageText = ResourcerUtil.getDrawableText(this, packageSp.getImage());
        image.setImageDrawable(imageText);

        TextView days = findViewById(R.id.activity_resume_days_package);
        String daysInText = DaysUtil.formatDaysInText(packageSp.getDays());
        days.setText(daysInText);

        TextView price = findViewById(R.id.activity_resume_price_package);
        String currencyBr = FormatCurrencyUtil.formatCurrencyBr(packageSp.getPrice());
        price.setText(currencyBr);
    }
}
