package com.paris.aluratravels.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.paris.aluratravels.R;
import com.paris.aluratravels.model.Packages;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class PackageListAdapter extends BaseAdapter {

    private List<Packages> packages;
    private Context context;

    public PackageListAdapter(List<Packages> packages, Context context) {
        this.packages = packages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Packages getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View viewCreated = LayoutInflater.from(context).inflate(R.layout.item_package, parent, false);

        Packages listPackage = packages.get(position);

        TextView city = viewCreated.findViewById(R.id.item_package_city);
        city.setText(listPackage.getCity());
        ImageView image = viewCreated.findViewById(R.id.item_package_image);
        Resources resources = context.getResources();
        int idDrwanble = resources.getIdentifier(listPackage.getImage(), "drawable", context.getPackageName());
        Drawable drawableImage = resources.getDrawable(idDrwanble);
        image.setImageDrawable(drawableImage);

        TextView days = viewCreated.findViewById(R.id.item_package_days);
        int numberOfDays = listPackage.getDays();
        String phraseNumberOfDays = "";
        if (numberOfDays > 1){
            phraseNumberOfDays = numberOfDays + " dias";
        }else {
            phraseNumberOfDays = numberOfDays + " dia";
        }

        days.setText(phraseNumberOfDays);

        TextView price = viewCreated.findViewById(R.id.item_package_price);
        BigDecimal priceValue = listPackage.getPrice();
        NumberFormat formatBr = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String formattedPrice = formatBr.format(priceValue).replace("R$", "R$ ");

        price.setText(formattedPrice);



        return viewCreated;
    }
}
