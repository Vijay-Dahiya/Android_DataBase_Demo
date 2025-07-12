package com.vijay.androiddatabase.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.vijay.androiddatabase.presenter.utils.UserData

class DbHelper(context: Context?) : SQLiteOpenHelper(context,DB_NAME,null,version) {

    companion object {
        const val DB_NAME = "demo_db"
        const val version = 3
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = "CREATE TABLE register(id INTEGER PRIMARY KEY AUTOINCREMENT, key_name TEXT, key_email TEXT, key_pass TEXT, key_gender TEXT)"
        db?.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS register")
        onCreate(db)
    }

    fun getAllUsersHelper() : List<UserData?> {
        val database = this.readableDatabase
        val userList = mutableListOf<UserData>()

        val cursor = database.rawQuery("SELECT * FROM register",null)
        if (cursor.moveToFirst()) {
            do {
                val userData =  UserData(
                    name = cursor.getString(1),
                    email = cursor.getString(2),
                    gender = cursor.getString(4)
                )
                userList.add(userData)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return userList
    }

    fun getUserDetails(email: String) : UserData? {
        val database = this.readableDatabase
        var userData : UserData? = null
        val cursor = database.rawQuery("SELECT * FROM register WHERE key_email = '$email'", null)
        if (cursor.moveToFirst()) {
            userData =  UserData(
                name = cursor.getString(1),
                email = cursor.getString(2),
                gender = cursor.getString(4)
            )
        }
        cursor.close()
        return userData
    }

    fun loginHelper(
        email: String,
        pass : String
    ) : Boolean {
        val database = this.readableDatabase
        var isSuccess = false
        val cursor = database.rawQuery("SELECT * FROM register WHERE key_email = '$email' AND key_pass= '$pass'", null)
        if (cursor.moveToFirst()) {
            isSuccess = true
        }
        cursor.close()
        return isSuccess
    }

    fun registerUserHelper(
        name : String,
        email: String,
        pass : String,
        gender: String
    ) : Boolean{
        val dataBase = this.writableDatabase

        val contentValues= ContentValues()
        contentValues.put("key_name",name)
        contentValues.put("key_email", email)
        contentValues.put("key_pass",pass)
        contentValues.put("key_gender",gender)

        val longValue = dataBase.insert("register", null, contentValues)
        dataBase.close()

        return longValue > 0
    }

}