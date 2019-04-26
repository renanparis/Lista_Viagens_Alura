package com.paris.aluratravels.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.paris.aluratravels.R;
import com.paris.aluratravels.model.Packages;
import com.paris.aluratravels.util.DateUtil;
import com.paris.aluratravels.util.FormatCurrencyUtil;
import com.paris.aluratravels.util.ResourcerUtil;

import java.math.BigDecimal;

public class PurchaseResumeActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_resume);
        setTitle(TITLE_APPBAR);

        Packages packageSp =
                new Packages("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        setImage(packageSp);
        setCity(packageSp);
        setDate(packageSp);
        setPrice(packageSp);

    }

    private void setImage(Packages packages) {
        ImageView image = findViewById(R.id.activity_purchase_resume_image_package);
        Drawable imageText = ResourcerUtil.getDrawableText(this, packages.getImage());
        image.setImageDrawable(imageText);
    }

    private void setPrice(Packages packages) {
        TextView price = findViewById(R.id.activity_purchase_resume_price);
        String currencyBr = FormatCurrencyUtil.formatCurrencyBr(packages.getPrice());
        price.setText(currencyBr);
    }

    private void setDate(Packages packages) {
        TextView date = findViewById(R.id.activity_purchase_resume_date);
        String formatDateInText = DateUtil.formatDateInText(packages.getDays());
        date.setText(formatDateInText);
    }

    private void setCity(Packages packages) {
        TextView city = findViewById(R.id.activity_purchase_resume_city);
        city.setText(packages.getCity());
    }
}
