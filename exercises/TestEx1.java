package com;

import org.junit.*;
import static com.DateCalculatorTestSetup.*;
import static org.junit.Assert.assertEquals;

public class TestEx1 {
    @Test
    public void DateStringTest() {
        for (Date d : data) {
            String actual_result = DateCalculator.DateString(d.Year, d.Month, d.Day);
            String expected_result = d.toString();
            assertEquals(String.format("DateString(int,int,int) Function should return %s but it returned %s", expected_result, actual_result),
                expected_result, actual_result);
        }

        for (Date d: invalidData) {
            String actual_result = DateCalculator.DateString(d.Year, d.Month, d.Day);
            assertEquals(String.format("DateString(int,int,int) Function should return INVALID_DATE when given year=%d, month=%d day=%d", d.Year, d.Month, d.Day )
                ,"INVALID_DATE", actual_result);
        }
    }

    @Test
    public void DateStringTestInvalidDates() {
        for (Date d: invalidData) {
            String actual_result = DateCalculator.DateString(d.Year, d.Month, d.Day);
            assertEquals(String.format("DateString(int,int,int) Function should return INVALID_DATE when given year=%d, month=%d day=%d", d.Year, d.Month, d.Day )
                    ,"INVALID_DATE", actual_result);
        }
    }
}
