package com.paris.aluratravels.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.paris.aluratravels.DAO.PackageDao;
import com.paris.aluratravels.R;
import com.paris.aluratravels.model.Packages;
import com.paris.aluratravels.ui.adapter.PackageListAdapter;

import java.util.List;

public class ListTravelsActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_travels);
        setTitle(TITLE_APPBAR);
        configListPackage();
    }

    private void configListPackage() {
        ListView list = findViewById(R.id.activity_list_travels_list_package);
        PackageDao dao = new PackageDao();
        List<Packages> packages = dao.list();
        list.setAdapter(new PackageListAdapter(packages, this));
    }
}
