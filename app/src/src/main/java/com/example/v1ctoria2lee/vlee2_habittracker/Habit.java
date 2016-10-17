package com.example.v1ctoria2lee.vlee2_habittracker;

import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Date;


public class Habit extends AppCompatActivity implements Serializable {

    private static final long serialVersionUID = 50L;
    protected String habitname;
    protected Date date;

    public Habit(String habitname) {
        this.habitname = habitname;
    }

    public String getName(){
        return this.habitname;
    }

    public String toString(){
        return getName();
    }


    public Date getDate() {
        return date;
    }



    public boolean equals(Object compareHabit) {
        if (compareHabit != null && compareHabit.getClass() == this.getClass()) {
            return  this.equals((Habit)compareHabit);
        }else {return false;}
    }

    public boolean equals(Habit compareHabit){
        if (compareHabit==null){
            return false;
        }
        return getName().equals(compareHabit.getName());
    }












    /*

    private String message;
    private Date date;


    public Habit(String message) {
        this.message = message;
        this.date = new Date();
    }


    public Habit(String message, Date date){
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString(){
        return message;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
*/
}
