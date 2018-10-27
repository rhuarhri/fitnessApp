package com.example.rhuarhri.fitnessapp;


import org.junit.Test;


import static org.junit.Assert.*;



public class MainActivityTest {

    /*Example of using unit tests in java android studio
    Step 1 highlight the method you want to test
    Step 2 press control shift T
    Step 3 select the function you want to test
    Step 4 select one of these files
    files to choose from
    1 src/androidTest/java
    this file allows you to perform UI tests (with espresso) and function tests (with junit)
    problem must run on emulator or device
    2 src/test/java
    this file allows you to perform function tests (with junit) in android studio
    problem can not run espresso tests

    EXAMPLE espresso test
    No need to specify the layout just the id of the widget

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText(mStringToBeTyped), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText(mStringToBeTyped)));
    }
     */


    @Test
    public void exmapleFunction() {

        int output;
        int expected = 10;
        double delta = 0.1;//margin of error


        MainActivity test = new MainActivity();

        output = test.exmapleFunction();

        assertEquals(expected, output);
        assertNotNull(test);


    }

    @Test
    public  void exxmapleFunction2()
    {
        int input = 1;

        boolean expected = false;

        boolean output;

        MainActivity test = new MainActivity();

        output = test.exampleFunction2(input);

        assertEquals(expected, output);
    }


}