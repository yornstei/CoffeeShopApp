package com.example.yehudaornstein.coffeeshop;

import android.os.StrictMode;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Vector;

public class CoffeeDBManagerApp {
    ObjectOutputStream out;
    ObjectInputStream in;
    CoffeeSerialObject result;
    public CoffeeDBManagerApp()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    public int getCustomerBalance(String name) throws SQLException
    {
        int customerBalance;
        CoffeeSerialObject cso = new CoffeeSerialObject();
        cso.SetSqlStatment("SELECT balance FROM Customers WHERE name = '" + name + "'");
        cso.SetMethodType("select");
        SendAndGetObject(cso);
        Vector<Vector<Object>> mt = result.GetTable();
        customerBalance = (int) Double.parseDouble(mt.get(0).get(0).toString());
        return customerBalance;
    }
    public int getCustomerID(String name) throws SQLException
    {
        int customerID;
        CoffeeSerialObject cso = new CoffeeSerialObject();
        cso.SetSqlStatment("SELECT customerID FROM customers WHERE name = '"+name+"'");
        cso.SetMethodType("select");
        SendAndGetObject(cso);
        Vector<Vector<Object>> mt = result.GetTable();
        customerID = (int) Double.parseDouble(mt.get(0).get(0).toString());
        return customerID;
    }
    public int getCoffeeID(String coffeeName) throws SQLException
    {
        int coffeeID;
        CoffeeSerialObject cso = new CoffeeSerialObject();
        cso.SetSqlStatment("SELECT coffeeID FROM Coffees WHERE Description = '"+coffeeName+"'");
        cso.SetMethodType("select");
        SendAndGetObject(cso);
        Vector<Vector<Object>> mt = result.GetTable();
        coffeeID = (int) Double.parseDouble(mt.get(0).get(0).toString());
        return coffeeID;
    }
    public void submitOrder(int customerID, int coffeeID, int quantity) throws SQLException
    {
        CoffeeSerialObject cso = new CoffeeSerialObject();
        cso.SetSqlStatment("INSERT INTO Orders (customerID,coffeeID,quantity) VALUES("+customerID+","+coffeeID+","+quantity+")");
        cso.SetMethodType("insert");
        SendAndGetObject(cso);
    }
    public void addCoffee(String descroption, double price) throws SQLException
    {
        CoffeeSerialObject cso = new CoffeeSerialObject();
        cso.SetSqlStatment("INSERT INTO coffees (description,price) VALUES ('"+descroption+"',"+price+")");
        cso.SetMethodType("insert");
        SendAndGetObject(cso);


    }
    public void addCustomer(String name) throws SQLException
    {
        CoffeeSerialObject cso = new CoffeeSerialObject();
        cso.SetSqlStatment("INSERT INTO customers(name)  VALUES ('" + name + "')");
        cso.SetMethodType("insert");
        SendAndGetObject(cso);
    }
    public Object[][] getCusData() throws SQLException
    {
        Object[][] data;
        CoffeeSerialObject cso = new CoffeeSerialObject();
        cso.SetSqlStatment("SELECT * FROM customers");
        cso.SetMethodType("select");
        SendAndGetObject(cso);
        Vector<Vector<Object>> mt = result.GetTable();
        data = new Object[mt.size()][mt.get(0).size()];
        for(int row = 0; row < mt.size(); row++)
        {
            for(int col = 0; col <mt.get(0).size(); col++)
            {
                data[row][col] =mt.get(row).get(col);
            }
        }
        return data;
    }
    public void SendAndGetObject(CoffeeSerialObject cso)
    {
        try{
            URL myURL = new URL("http://54.174.169.58:8080/ycoffee/MachonCoffee");
            HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty ("Content-Type", "application/octet-stream");
            conn.setUseCaches(false);
            conn.setDefaultUseCaches(false);
            out = new ObjectOutputStream(conn.getOutputStream());
            out.writeObject(cso);
            out.flush();
            out.close();
            in = new ObjectInputStream(conn.getInputStream());
            if(cso.GetMethodType().equals("select"))
            {
                result = (CoffeeSerialObject) in.readObject();
            }
            in.close();
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IllegalStateException o){
            o.printStackTrace();
        }
    }
}
