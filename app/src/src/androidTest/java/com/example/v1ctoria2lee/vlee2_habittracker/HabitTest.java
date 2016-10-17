package com.example.v1ctoria2lee.vlee2_habittracker;

/**
 * Created by V1CTORIA2LEE on 2016-10-01.
 */

import junit.framework.TestCase;


public class HabitTest extends TestCase {

    public void testHabit() {
        String habitname = "A habit";
        Habit habit = new Habit(habitname);
        assertTrue("Habit name is not equal", habitname.equals(habit.getName()));
    }

    public void testHabitToString() {
        String habitname = "A habit";
        Habit habit = new Habit(habitname);
        assertTrue("Habit name.toString is not equal", habitname.toString().equals(habit.getName()));
    }

    public void testHabitEquals(){
        String habitname = "A habit";
        String habitnameB = "B habit";
        Habit habitA = new Habit(habitname);
        Habit habitC = new Habit(habitname);
        Habit habitB = new Habit(habitnameB);

        assertTrue("A !=B", habitA.equals(habitB));
        assertTrue("B !=A", habitB.equals(habitA));
        assertFalse("A==C", habitA.equals(habitC));
        assertFalse("B==C", habitB.equals(habitC));
        assertFalse("C==A", habitC.equals(habitA));
        assertTrue("A==A", habitA.equals(habitA));
        assertTrue("B==B", habitB.equals(habitB));
        assertTrue("C==C", habitC.equals(habitC));
        assertTrue("A==(Object)B", habitA.equals((Object)(habitB)));

    }

}
