package com.paris.aluratravels.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.paris.aluratravels.R;
import com.paris.aluratravels.model.Packages;
import com.paris.aluratravels.util.DaysUtil;
import com.paris.aluratravels.util.FormatCurrencyUtil;
import com.paris.aluratravels.util.ResourcerUtil;

import java.util.List;


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

        View viewCreated = LayoutInflater.from(context)
                .inflate(R.layout.item_package, parent, false);

        Packages listPackage = packages.get(position);

        setCity(viewCreated, listPackage);
        setImage(viewCreated, listPackage);
        setDays(viewCreated, listPackage);
        setPrice(viewCreated, listPackage);

        return viewCreated;
    }

    private void setPrice(View viewCreated, Packages listPackage) {
        TextView price = viewCreated.findViewById(R.id.item_package_price);
        String formattedPrice = FormatCurrencyUtil.formatCurrencyBr(listPackage.getPrice());

        price.setText(formattedPrice);
    }

    private void setDays(View viewCreated, Packages listPackage) {
        TextView days = viewCreated.findViewById(R.id.item_package_days);
        String phraseNumberOfDays = DaysUtil.formatDaysInText(listPackage.getDays());

        days.setText(phraseNumberOfDays);
    }

    private void setImage(View viewCreated, Packages listPackage) {
        ImageView image = viewCreated.findViewById(R.id.item_package_image);
        Drawable drawableImage = ResourcerUtil.getDrawableText(context, listPackage.getImage());
        image.setImageDrawable(drawableImage);
    }

    private void setCity(View viewCreated, Packages listPackage) {
        TextView city = viewCreated.findViewById(R.id.item_package_city);
        city.setText(listPackage.getCity());
    }
}
