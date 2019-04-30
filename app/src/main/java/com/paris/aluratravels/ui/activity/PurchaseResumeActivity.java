package com.paris.aluratravels.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.Objects;

public class PurchaseResumeActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_resume);
        setTitle(TITLE_APPBAR);

        Intent intent = getIntent();
        if (intent.hasExtra("package")){
            Packages packages = Objects.requireNonNull(intent.getExtras()).getParcelable("package");
            setImage(packages);
            setCity(packages);
            setDate(packages);
            setPrice(packages);
        }



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
