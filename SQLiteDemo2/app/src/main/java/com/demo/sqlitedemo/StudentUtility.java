package com.demo.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by intel on 12/15/2016.
 */

public class StudentUtility extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase;
    private Context mContext;

    public static final String DATABASE_NAME = "students.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";

    private static final String TABLE_CREATE_QUERY =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER primary key autoincrement," +
                    COLUMN_NAME + " VARCHAR," +
                    COLUMN_AGE + " VARCHAR);";


    public StudentUtility(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            //closeDB();
            mContext.deleteDatabase(DATABASE_NAME);
            onCreate(db);
        } catch (SQLException e) {

        }
    }

    public void addStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        long id = sqLiteDatabase.insert(TABLE_NAME, null, values);
        Toast.makeText(mContext, "Insert Success " + id, Toast.LENGTH_SHORT).show();
    }

    public void listStudents() {
        //String query = "SELECT * from " + TABLE_NAME;
        String[] columns = {COLUMN_ID,
                COLUMN_NAME,
                COLUMN_AGE
        };

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, columns, null, null, null, null, null);


        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String age = cursor.getString(cursor.getColumnIndex(COLUMN_AGE));

                Toast.makeText(mContext, id + " " + name + " " + age, Toast.LENGTH_LONG).show();

            } while (cursor.moveToNext());
        }

        cursor.close();
    }

    public void updateStudent(int id, String name) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        int numRowsUpdated = sqLiteDatabase.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)});

        Toast.makeText(mContext, "Rows Updated " + numRowsUpdated,Toast.LENGTH_SHORT).show();
    }

    public void deleteStudent(int id) {
        String whereClause = COLUMN_ID + " = ?";
        String[] whereArgs = new String[]{String.valueOf(id)};
        sqLiteDatabase.delete(TABLE_NAME, whereClause, whereArgs);
        Toast.makeText(mContext, "Rows Deleted ", Toast.LENGTH_SHORT).show();
    }

    public void deleteAll() {
        String delete = "DELETE FROM " + TABLE_NAME;
        sqLiteDatabase.rawQuery(delete, null);
        sqLiteDatabase.delete(TABLE_NAME, null, null);
        Toast.makeText(mContext, "All row deleted", Toast.LENGTH_SHORT).show();
    }



}
