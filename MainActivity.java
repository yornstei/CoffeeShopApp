package com.example.yehudaornstein.coffeeshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onPlaceOrderClick(View view) {

        Intent PlaceOrderScreenIntent = new Intent(this,PlaceOrderScreen.class);

        final int result = 1;

        PlaceOrderScreenIntent.putExtra("callingActivity", "MainActivity");

        startActivity(PlaceOrderScreenIntent);
    }

    public void onAddCustomerClick(View view) {

        Intent AddCustomerScreenIntent = new Intent(this, AddCustomerScreen.class);

        startActivity(AddCustomerScreenIntent);
    }

    public void onAddCoffeeClick(View view) {

        Intent AddCoffeeScreenIntent = new Intent(this, AddCoffeeScreen.class);

        startActivity(AddCoffeeScreenIntent);
    }

    public void onCustomerBalanceClick(View view) {

        Intent CustomersBalanceScreenIntent = new Intent(this, CustomersBalanceScreen.class);

        startActivity(CustomersBalanceScreenIntent);
    }

    public void onGetAllCusBalClick(View view) {

        Intent AllCustomersBalanceScreenIntent = new Intent(this, AllCustomersBalanceScreen.class);

        startActivity(AllCustomersBalanceScreenIntent);
    }
}
