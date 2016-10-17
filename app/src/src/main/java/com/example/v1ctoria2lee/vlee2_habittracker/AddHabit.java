package com.example.v1ctoria2lee.vlee2_habittracker;


import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 * Created by V1CTORIA2LEE on 2016-09-28.
 */
public class AddHabit extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    //private Button cancel;
    //private Button add_addPage;
    private ArrayList<Habit> HabitList =  new ArrayList<Habit>();
    //private ArrayAdapter<Habit> habitAdapter;
    //private TextView habitString;
    //private TextView Date;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);
        HabitListManager.initManager(this.getApplicationContext() );

        TextView Date = (TextView) findViewById(R.id.addHabitDate);
        String newDate = DateFormat.getDateInstance().format(new Date());
        Date.setText(newDate);


    }

    public void backPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void add_button(View view){
        Toast.makeText(this,"adding a habit", Toast.LENGTH_SHORT).show();
        HabitListController hc = new HabitListController();
        EditText textView = (EditText) findViewById(R.id.addNewHabitText);
        hc.addHabit(new Habit(textView.getText().toString()));
        finish();

    }












}


