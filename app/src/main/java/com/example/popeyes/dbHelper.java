package com.example.popeyes;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.popeyes.Models.CartModel;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {

    final static String DBNAME="mydatabase.db";
    final static int DBVERSION=5;


    public dbHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders"+
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text)"
                      /*   "price int )"
                        "image int," +
                        "quantity int,"+
                        "foodname text," +
                        "description text)"*/
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists orders");
        onCreate(sqLiteDatabase);

    }

    public boolean insertOrder(String name,String phone){
         SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);

   long id=database.insert("orders",null,values);
   if (id==-1)
       return false;

   else return true;
    }
    public boolean updateOrder(String name,String phone){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        Cursor cursor=sqLiteDatabase.rawQuery("select * from orders where name=?",new String[]{name});

        if (cursor.getCount()>0) {
            long id = sqLiteDatabase.update("orders", values, "name=?", new String[]{name});

            if (id==-1)  return false;
            else     return true;
        }
        return false;
    }

    public boolean deleteOrder(String name){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from orders where name=?",new String[]{name});

        if (cursor.getCount()>0) {
            long id = sqLiteDatabase.delete("orders", "name=?", new String[]{name});

            if (id==-1)  return false;
            else     return true;
        }
        return false;
    }
    public Cursor getData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from orders",null);
        return  cursor;

    }

    public ArrayList<CartModel> getOrders(){
      ArrayList<CartModel> orders=new ArrayList<>();
      SQLiteDatabase database=this.getWritableDatabase();
      Cursor cursor= database.rawQuery("select image,soldItemName,price,order_number from orders",null);
      if(cursor.moveToFirst())
          while (cursor.moveToNext()){
              CartModel model=new CartModel();
              model.setImage(cursor.getInt(0));
              model.setSoldItemName(cursor.getString(1));
              model.setPrice(cursor.getInt(2)+"");
              model.setOrder_number(cursor.getInt(3)+"");

              orders.add(model);
          }
      cursor.close();
          database.close();
          return orders;
    }
}



