package com.example.v1ctoria2lee.vlee2_habittracker;

import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by V1CTORIA2LEE on 2016-09-28.
 */
public class HistoryLog extends MainActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_page);
        HabitListManager.initManager(this.getApplicationContext() );





    }




}





