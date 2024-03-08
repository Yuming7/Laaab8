package com.example.lab8;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.lab8", appContext.getPackageName());
    }

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Before
    public void setUp() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        ArrayList<City> cityDataList = new ArrayList<>();
        cityDataList.add(new City("Edmonton", "AB"));
        cityDataList.add(new City("Vancouver", "BC"));
        cityDataList.add(new City("Toronto", "ON"));
        list = new CustomList(appContext, cityDataList);
    }

    @Test
    public void testHasCity() {
        City existingCity = new City("Edmonton", "AB");
        City nonExistingCity = new City("Calgary", "AB");

        assertTrue(list.hasCity(existingCity));
        assertFalse(list.hasCity(nonExistingCity));
    }

    @Test
    public void testDeleteCity() {
        City cityToDelete = new City("Vancouver", "BC");
        list.delete(cityToDelete);
        assertFalse(list.hasCity(cityToDelete));
    }

    @Test
    public void testCountCities() {
        assertEquals(3, list.countCities());
    }

}