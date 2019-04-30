package com.paris.aluratravels.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.paris.aluratravels.R;
import com.paris.aluratravels.model.Packages;
import com.paris.aluratravels.util.FormatCurrencyUtil;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(TITLE_APPBAR);
        Intent intent = getIntent();
        if (intent.hasExtra("package")){
            final Packages packages = Objects.requireNonNull(intent.getExtras()).getParcelable("package");
            setPrice(packages);
            configButtonPaymentConfirm(packages);
        }






    }

    private void configButtonPaymentConfirm(final Packages packages) {
        Button finalizePurchase = findViewById(R.id.activity_payment_button_finalize_payment);
        finalizePurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentActivity.this, PurchaseResumeActivity.class);
                intent.putExtra("package", packages);
                startActivity(intent);
            }
        });
    }

    private void setPrice(Packages packages) {
        TextView price = findViewById(R.id.activity_payment_price_package);
        String currencyBr = FormatCurrencyUtil.formatCurrencyBr(packages.getPrice());
        price.setText(currencyBr);
    }
}
