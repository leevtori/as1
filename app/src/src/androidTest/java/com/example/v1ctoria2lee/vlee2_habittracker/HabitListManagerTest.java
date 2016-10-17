package com.example.v1ctoria2lee.vlee2_habittracker;

import android.test.AndroidTestCase;

import java.io.IOException;
import java.util.EmptyStackException;

/**
 * Created by V1CTORIA2LEE on 2016-10-02.
 */
public class HabitListManagerTest extends AndroidTestCase {

    public void testHabitToString(){
        HabitList hl = new HabitList();
        Habit testHabit = new Habit("test habit");
        hl.addHabit(testHabit);
        try {
            String str = HabitListManager.habitListToString(hl);
            assertTrue("String is too small", str.length() > 0 );
            HabitList hl2 = HabitListManager.habitListFromString(str);
            assertTrue("hl2 size >0", hl2.size()>0);
            assertTrue(" Collection containment",hl2.getHabit().contains(testHabit));
            assertTrue(" hl does not contain testHabit",hl.contains(testHabit));
            assertTrue(" hl2 does not contain testHabit",hl2.contains(testHabit));
        } catch (IOException e){
            e.printStackTrace();
            assertTrue("IOException " + e, false);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            assertTrue("ClassNotFoundException  " + e, false);
        }//catch (EmptyHabitListException e){
           // e.printStackTrace();
        // }
    }

    public void testHabitListManager()  {
        try {
            HabitList hl = new HabitList();
            Habit testHabit = new Habit("test habit");
            hl.addHabit(testHabit);
            HabitListManager hlm = new HabitListManager(getContext());
            hlm.saveHabitList(hl);
            HabitList hl2 = hlm.loadHabitList();
            //compare
            assertTrue("hl2 size is not consistent  ", hl2.size()==1 );
            assertTrue("Test habit is not in habit list 2", hl2.contains(testHabit));
            assertTrue("Test habit is in habit list 1 ", hl.contains(testHabit));
        } catch (IOException e){
            e.printStackTrace();

            assertTrue("IOException Thrown"+ e.toString(), false);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            assertTrue("ClassNotFoundException Thrown"+ e.toString(), false);

        }
    }
}
