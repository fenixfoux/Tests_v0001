package com.example.tests_v0001;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

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

    //@ColumnInfo(name = "col_password_not_encrypt")
    //public String password_not_encrypt;

    @ColumnInfo(name = "col_email")
    public String email;

    @ColumnInfo(name = "col_phone")
    public String phone;

    public User(String firstName, String last_name,
                String login, String password_encrypt, //String password_not_encrypt,
                String email, String phone){
        this.u_Id = u_Id;
        this.firstName = firstName;
        this.last_name = last_name;
        this.login = login;
        this.password_encrypt = password_encrypt;
        //this.password_not_encrypt = password_not_encrypt;
        this.email = email;
        this.phone = phone;
    }

    public int getU_Id() {
        return u_Id;
    }

    public void setU_Id(int u_Id) {
        this.u_Id = u_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword_encrypt() {
        return password_encrypt;
    }

    public void setPassword_encrypt(String password_encrypt) {
        this.password_encrypt = password_encrypt;
    }
/*
    public String getPassword_not_encrypt() {
        return password_not_encrypt;
    }

    public void setPassword_not_encrypt(String password_not_encrypt) {
        this.password_not_encrypt = password_not_encrypt;
    }
*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof User)) return false;

        User user = (User) obj;

        if(u_Id != user.u_Id) return false;
        return Objects.equals(password_encrypt, user.password_encrypt);
        // return title != null ? title.equals(note.title) : note.title == null;
    }
    /*
    @Override
    public int hasCode(){
        int result = u_Id;
        result = 31 * result + (password_encrypt != null ? password_encrypt.hashCode() : 0);
        return result;
    }*/
    @Override
    public String toString(){
        return "User " +
                "u_id " + u_Id +
                ", first_name " + firstName +
                ", last_name " + last_name +
                ", login " + login +
                ", password_encrypt " + password_encrypt +
                //", password_not_encrypt " + password_not_encrypt +
                ", email " + email +
                ", phone " + phone + "}" ;
    }
}
