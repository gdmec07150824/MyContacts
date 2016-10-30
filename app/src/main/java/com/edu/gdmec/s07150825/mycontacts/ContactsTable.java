package com.edu.gdmec.s07150825.mycontacts;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by hasee on 2016/10/23.
 */
public class ContactsTable {

    private final static String TABLENAME = "contactsTable";
    private MyDB db;

    public ContactsTable(Context context) {
        db = new MyDB(context);
        if (!db.isTableExits(TABLENAME)) {
            String createTableSql = "create table if not exists" + TABLENAME + "(id_DB integer primary key AUTOINCREMENT,"+User.NAME+"varchar,"+User.MOBILE+"varchar,"+User.DANWEI+"varchar,"+User.QQ+"varchar,"+User.ADDRESS+"varchar)";
            db.createTable(createTableSql);
        }
    }

    public boolean addData(User user){
        ContentValues values =new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        return db.save(TABLENAME,values);

    }

}
