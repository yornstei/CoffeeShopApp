package com.example.yehudaornstein.coffeeshop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;

public class AllCustomersBalanceScreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.all_customers_balance_layout);

        Intent activityForAllCusBal = getIntent();


    }

    public void onGetAllCusDataClick(View view) {

        try{
            CoffeeDBManagerApp db = new CoffeeDBManagerApp();
            Object[][] CusData = db.getCusData();
            ListAdapter myAdapter = new MyAdapter(this, CusData);
            ListView theListView = (ListView) findViewById(R.id.theListView);
            theListView.setAdapter(myAdapter);
        }catch(SQLException a){
            Toast.makeText(this, "Not Successful", Toast.LENGTH_LONG).show();
        }
    }
}
