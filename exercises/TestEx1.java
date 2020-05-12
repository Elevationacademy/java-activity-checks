package com;

import junit.framework.TestCase;
import org.junit.Test;
import static com.DateCalculatorTestSetup.*;
import java.time.LocalDate;
import com.DateCalculator;
import static org.junit.Assert.assertEquals;

public class TestEx1 {

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
