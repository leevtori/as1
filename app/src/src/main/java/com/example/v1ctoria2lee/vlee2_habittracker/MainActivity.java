/*
vlee2-HabitTracker: todo list

*/

package com.example.v1ctoria2lee.vlee2_habittracker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ArrayList<Habit> HabitList =  new ArrayList<Habit>();
    private Button addButton;
    private Button historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitListManager.initManager(this.getApplicationContext() );

        ListView listView = (ListView) findViewById(R.id.currentHabits);
        Collection<Habit> habit = HabitListController.getHabitList().getHabit();
        final ArrayList<Habit> list = new ArrayList<>(habit);
        final ArrayAdapter<Habit> habitAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(habitAdapter);

        //this is an observer
        HabitListController.getHabitList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Habit> habit = HabitListController.getHabitList().getHabit();
                list.addAll(habit);
                habitAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,"Delete "+list.get(position).toString(), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("Delete "+ list.get(position).toString()+ "?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Habit habit = list.get(finalPosition);
                        HabitListController.getHabitList().removeHabit(habit);
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                Toast.makeText(MainActivity.this,"deleting a habit", Toast.LENGTH_SHORT).show();
                adb.show();
                return false;
            }
        });

//        listView.setOnItemClickListener(new OnItemClickListener(){
//            @Override
//            public void onItemClick(){
//                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
//                adb.setMessage("Completed ?");
//                adb.setPositiveButton("OK", null);
//                adb.show();
//            }
//        });







        addButton = (Button) findViewById(R.id.add);
        historyButton = (Button) findViewById(R.id.history);
    }

    public void sendAddpage(View v) {
        Intent intent = new Intent(MainActivity.this, AddHabit.class);
        startActivity(intent);
    }

    public void logPage(View v) {
        Intent intent = new Intent(MainActivity.this, HistoryLog.class);
        startActivity(intent);
    }





//    @Override
//    protected void onStart() {
//        // TODO Auto-generated method stub
//        super.onStart();
//        loadFromFile();
//        adapter = new ArrayAdapter<Habit>(this,
//                R.layout.list_item, HabitList);
//        todaysHabits.setAdapter(adapter);
//    }
//
//    private void loadFromFile() {
//        try {
//            FileInputStream fis = openFileInput(FILENAME);
//            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//            Gson gson = new Gson();
//            //Code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22,2016
//            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
//            HabitList = gson.fromJson(in, listType);
//
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            HabitList = new ArrayList<Habit>();
//            //IOException
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            //throw new RuntimeException();
//        }
//    }
//
//    private void saveInFile() {
//        try {
//            FileOutputStream fos = openFileOutput(FILENAME,0);
//            OutputStreamWriter writer = new OutputStreamWriter(fos);
//            Gson gson = new Gson();
//            gson.toJson(HabitList, writer);
//            writer.flush();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            throw new RuntimeException();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            throw new RuntimeException();
//        }
//    }


}












