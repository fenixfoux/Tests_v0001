package com.example.tests_v0001.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int u_Id;

    @ColumnInfo(name = "col_first_name")
    public String firstName;

    @ColumnInfo(name = "col_last_name")
    public String last_name;

    @ColumnInfo(name = "col_login")
    public String login;

    @ColumnInfo(name = "col_password_encrypt")
    public String password_encrypt;

    @ColumnInfo(name = "col_password_not_encrypt")
    public String password_not_encrypt;

    @ColumnInfo(name = "col_email")
    public String email;

    @ColumnInfo(name = "col_phone")
    public String phone;



}
