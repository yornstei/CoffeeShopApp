package com.example.yehudaornstein.coffeeshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Object>{

    public MyAdapter(Context context, Object[][] data) {
        super(context, R.layout.layout_for_table, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.layout_for_table, parent, false);

        Object[] item = (Object[]) getItem(position);
        String customerId = ""+item[0];

        String customerName = ""+item[1];

        String customerBalance = ""+item[2];

        if(customerBalance.equals("null")){

            customerBalance = "0";
        }


//        long positionid = getItemId(position);
//
//        String customerBalance2 = (String) getItem(position);


        TextView customerIdView = (TextView) theView.findViewById(R.id.customer_id_in_table);

        TextView customerNameView = (TextView) theView.findViewById(R.id.customer_name_in_table);

        TextView customerBalanceView = (TextView) theView.findViewById(R.id.customer_balance_in_table);

        customerIdView.setText(customerId);

        customerNameView.setText(customerName);

        customerBalanceView.setText("$"+customerBalance);

        return theView;
    }
}