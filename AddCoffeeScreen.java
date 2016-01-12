package com.example.yehudaornstein.coffeeshop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class AddCoffeeScreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_coffee_layout);

        Intent activityForAddCus = getIntent();
    }


    public void onAddCoffeeWindowClick(View view) {
        try{
            CoffeeDBManagerApp db = new CoffeeDBManagerApp();
            EditText newCoffeeName = (EditText) findViewById(R.id.new_coffees_name);
            EditText newCoffeePrice = (EditText) findViewById(R.id.new_coffees_price);
            db.addCoffee(newCoffeeName.getText().toString(), Double.parseDouble(newCoffeePrice.getText().toString()));
            Toast.makeText(this, "Coffee added successfully", Toast.LENGTH_LONG).show();
            finish();
        }catch(Exception a){
            Toast.makeText(this, "Coffee not added successfully" + a.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
