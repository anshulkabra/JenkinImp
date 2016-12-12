package org.uitestingespresso.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.uitestingespresso.model.ExpenseTable;
import org.uitestingespresso.model.ExpenseType;
import org.uitestingespresso.model.ExpenseTypeTable;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "demo.db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ExpenseTypeTable.CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void addExpenseType(ExpenseType type) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ExpenseTable.TYPE, type.getType());

        database.insert(ExpenseTypeTable.TABLE_NAME, null, values);
    }

    public void deleteAllRecord(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(ExpenseTypeTable.TABLE_NAME, null,null);
    }
    public List<String> getExpenseTypes() {
        ArrayList<String> expenseTypes = new ArrayList<>();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(ExpenseTypeTable.SELECT_ALL, null);

        if(isCursorPopulated(cursor)){
            do {
                String type = cursor.getString(cursor.getColumnIndex(ExpenseTypeTable.TYPE));
                expenseTypes.add(type);
            } while(cursor.moveToNext());
        }

        return expenseTypes;
    }

    private boolean isCursorPopulated(Cursor cursor) {
        return cursor != null && cursor.moveToFirst();
    }
}
