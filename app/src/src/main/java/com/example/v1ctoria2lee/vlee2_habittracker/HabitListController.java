package com.example.v1ctoria2lee.vlee2_habittracker;

import java.io.IOException;

/**
 * Created by V1CTORIA2LEE on 2016-10-02.
 */
public class HabitListController {


    //lazy singleton
    private static  HabitList habitListSingleton = null;

    static public HabitList getHabitList() {
        if (habitListSingleton == null) {
            try {
                habitListSingleton = HabitListManager.getManager().loadHabitList();
                habitListSingleton.addListener(new Listener() {
                    @Override
                    public void update() {
                        saveHabitList();
                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize HabitList from HabitListManager");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize from HabitListManager");
            }
            //habitListSingleton = new HabitList();
        }
        return habitListSingleton;
    }

    static public void saveHabitList(){
        HabitListManager.getManager().saveHabitList(getHabitList());
    }

    public void addHabit(Habit habit) {
        getHabitList().addHabit(habit);
    }
}
