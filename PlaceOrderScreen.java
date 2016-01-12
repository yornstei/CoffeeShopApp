package com.example.yehudaornstein.coffeeshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class PlaceOrderScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.place_order_layout);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().toString();
    }

    public void onSubmitOrderClick(View view) {

        try{
            CoffeeDBManagerApp db = new CoffeeDBManagerApp();
            EditText customerName = (EditText) findViewById(R.id.customer_name);
            EditText coffeeType = (EditText) findViewById(R.id.coffee_type);
            EditText quantity = (EditText) findViewById(R.id.quantity_coffee);
            db.submitOrder(db.getCustomerID(customerName.getText().toString()),
                    db.getCoffeeID(coffeeType.getText().toString()), Integer.parseInt(quantity.getText().toString()));
            Toast.makeText(this, "Order was placed successfully", Toast.LENGTH_LONG).show();
            finish();
        }catch(SQLException a){
            Toast.makeText(this, "No Success placing the order", Toast.LENGTH_LONG).show();
        }
    }
}
