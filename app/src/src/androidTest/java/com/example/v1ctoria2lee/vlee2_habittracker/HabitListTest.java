package com.example.v1ctoria2lee.vlee2_habittracker;

/**
 * Created by V1CTORIA2LEE on 2016-10-01.
 */

import android.location.GpsStatus;

import junit.framework.TestCase;

import java.util.Collection;

public class HabitListTest extends TestCase {

    public void testEmptyHabitList() {
        HabitList habitList = new HabitList();
        assertTrue("Empty studen list", habitList.size() == 0);
    }

    public void testAddHabitList() {
        HabitList habitList = new HabitList();
        String habitname = "A Habit name";
        Habit testHabit = new Habit(habitname);
        habitList.addHabit(testHabit);
        assertTrue("habit list size", habitList.size() == 1);
        assertTrue("Test Student Not Contained", habitList.contains(testHabit));
    }

    public void testGetHabit() {
        HabitList habitList = new HabitList();
        String habitname = "A Habit name";
        Habit testHabit = new Habit(habitname);
        habitList.addHabit(testHabit);
        Collection<Habit> habit = habitList.getHabit();
        assertTrue("habit list size", habit.size() == 1);
        assertTrue("Test Student Not Contained", habit.contains(testHabit));
    }

    public void testRemoveHabit() {
        HabitList habitList = new HabitList();
        String habitname = "A Habit name";
        Habit testHabit = new Habit(habitname);
        habitList.addHabit(testHabit);
        assertTrue("habit list size isn't big enough", habitList.size() == 1);
        assertTrue("", habitList.contains(testHabit));
        habitList.removeHabit(testHabit);
        assertTrue("habit list size isnt small enough", habitList.size() == 0);
        assertFalse("Test Student Still contained?", habitList.contains(testHabit));

    }

    public void testChooseHabitList() {
            HabitList habitList = new HabitList();
            String habitname = "A Habit name";
            Habit testHabit = new Habit(habitname);
            habitList.addHabit(testHabit);
            //testing for one habit
            for (int i = 0; i < 10; i++) {
                Habit habit = habitList.chooseHabit();
                assertTrue("habit is not null", habit != null);
                assertTrue("didn't choose the right habit", habit.equals(testHabit));
            }
            String habitnameB = "B Habit name";
            Habit testHabitB = new Habit(habitnameB);
            habitList.addHabit(testHabitB);
            Habit[] habitArray = {testHabit, testHabitB};
            for (int i = 0; i < habitArray.length; i++) {
                Habit targetHabit = habitArray[i];
                int maxcount = 1000;
                while (maxcount > 0 && !targetHabit.equals(habitList.chooseHabit())) {
                    //do nothing
                    maxcount--;
                }
                assertTrue("Too many iterations", maxcount > 0);
            }

    }
    boolean updated = false;

    public void testNotifyListeners() {
        HabitList habitList = new HabitList();
        updated = false;
        Listener l = new Listener(){
            public void update(){
                HabitListTest.this.updated = true;
            }
        };
        habitList.addListener (l);
        Habit testHabit = new Habit("Newbie");
        habitList.addHabit(testHabit );
        assertTrue("Habit  list didn't fire an update", this.updated);
        updated = false;
        habitList.removeHabit(testHabit);
        assertTrue("Removing a habit from the list update", this.updated);
    }

    public void testRemoveListeners() {
        HabitList habitList = new HabitList();
        updated = false;
        Listener l = new Listener(){
            public void update(){
                HabitListTest.this.updated = true;
            }
        };
        habitList.addListener (l);
        habitList.removeListener(l);
        habitList.addHabit(new Habit("new"));
        assertFalse("Student list didn't fire an update", this.updated);
    }

}
