package com.example.yehudaornstein.coffeeshop;


import java.io.Serializable;
import java.util.Vector;

public class CoffeeSerialObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sqlStatment;
    private String exception;
    private boolean success;
    private Vector<Vector<Object>> table;
    private String methodType;
    public void SetSqlStatment(String sqlStatment)
    {
        this.sqlStatment = sqlStatment;
    }
    public void SetException(String exception)
    {
        this.exception = exception;
    }
    public void SetSuccess(boolean success)
    {
        this.success = success;
    }
    public void SetTable(Vector<Vector<Object>> table)
    {
        this.table = table;
    }
    public void SetMethodType(String methodType)
    {
        this.methodType = methodType;
    }
    public String GetSqlStatment()
    {
        return sqlStatment;
    }
    public String GetException()
    {
        return exception;
    }
    public boolean GetSuccess()
    {
        return success;
    }
    public Vector<Vector<Object>>  GetTable()
    {
        return table;
    }
    public String GetMethodType()
    {
        return methodType;
    }
}
