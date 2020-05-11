package com;

import junit.framework.TestCase;
import org.junit.Test;
import static com.DateCalculatorTestSetup.*;

public class TestEx1 extends TestCase {

    @Test
    public void DateStringTest() {
        for (Date d : data) {
            assertEquals(d.toString(), DateCalculator.DateString(d.Year, d.Month, d.Day));
        }

        for (Date d: invalidData) {
            assertEquals("INVALID_DATE", DateCalculator.DateString(d.Year, d.Month, d.Day));
            assertEquals("INVALID_DATE", DateCalculator.DateString(d.Year, d.Month, d.Day).toString());
        }
    }


    @Test
    public void DateStringTestInvalidDates() {
        for (Date d: invalidData) {
            assertEquals("INVALID_DATE", DateCalculator.DateString(d.Year, d.Month, d.Day));
            assertEquals("INVALID_DATE", DateCalculator.DateString(d.Year, d.Month, d.Day).toString());
        }
    }
}
