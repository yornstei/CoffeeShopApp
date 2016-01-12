package com.example.yehudaornstein.coffeeshop;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class AddCustomerScreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_cus_layout);

        Intent activityForAddCus = getIntent();
    }

    public void onAddCusWindoClick(View view) {
        try{
            CoffeeDBManagerApp db = new CoffeeDBManagerApp();
            EditText newCustomerName = (EditText)findViewById(R.id.new_customers_name);
            db.addCustomer(newCustomerName.getText().toString());
            Toast.makeText(this, "Customer added successfully", Toast.LENGTH_LONG).show();
            finish();
        }catch(SQLException a){
            Toast.makeText(this, "Customer not added successfully", Toast.LENGTH_LONG).show();
        }
    }
}
