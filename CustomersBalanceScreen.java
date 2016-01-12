package com.example.yehudaornstein.coffeeshop;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class CustomersBalanceScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.customers_balance);


    }

    public void onGetCusBalClick(View view) {
        try{
            CoffeeDBManagerApp db = new CoffeeDBManagerApp();
            EditText te = (EditText) findViewById(R.id.customers_name_for_balance);
            //int s = db.getCustomerBalance(te.getText().toString());
            Toast.makeText(this, "Customer "+te.getText().toString()+" balance is "+"$"+Integer.toString(db.getCustomerBalance(te.getText().toString())),
                    Toast.LENGTH_LONG).show();
            finish();
        }catch(SQLException a){
            Toast.makeText(this, "Not Success", Toast.LENGTH_LONG).show();
        }
    }
}
