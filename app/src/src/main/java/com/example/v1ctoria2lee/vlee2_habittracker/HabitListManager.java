package com.example.v1ctoria2lee.vlee2_habittracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by V1CTORIA2LEE on 2016-10-02.
 */
public class HabitListManager {
    static final String prefFile = "HabitList";
    static final String hlkey = "habitList";

    Context context;


    static private HabitListManager habitListManager = null;

    public static void initManager(Context context){
        if (habitListManager== null){
            if (context== null){
                throw new RuntimeException("missing context for habitlistmanager");
            }
            habitListManager = new HabitListManager(context);
        }
    }

    //new singleton
    public static HabitListManager getManager(){
        if (habitListManager== null) {
            throw new RuntimeException("did not initialize manager");
        }
        return habitListManager;
    }


    public HabitListManager(Context context) {
        this.context = context;
    }

    public HabitList loadHabitList() throws IOException, ClassNotFoundException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String habitListData =  settings.getString("hlkey", "");
        if (habitListData.equals("")){
            return new HabitList();
        } else {
            return habitListFromString(habitListData);
        }
    }

    static public HabitList habitListFromString(String habitListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(habitListData, Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (HabitList)oi.readObject();

    }

    static public String habitListToString(HabitList hl) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(hl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString( bytes, Base64.DEFAULT );
    }

    public void SaveHabitList(HabitList hl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(hlkey, habitListToString(hl));
        prefEditor.commit();

    }


    public void saveHabitList(HabitList hl) {
    }
}
