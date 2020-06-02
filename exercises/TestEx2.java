package com;

import junit.framework.TestCase;
import org.junit.Test;
import static com.DateCalculatorTestSetup.*;
import java.time.LocalDate;
import com.DateCalculator;
import static org.junit.Assert.assertEquals;

public class TestEx2 {

    @Test
    public void testDateAdd() {
        for (Date d: invalidData) {
            String actual_result = DateCalculator.DateAdd(d.Year, d.Month, d.Day,5);
            String expected_result = "INVALID_DATE";
            assertEquals(String.format("DateAdd(%d,%d,%d,%d) Function should return INVALID_DATE but it returned %s",
                    d.Year, d.Month, d.Day, 5, actual_result.toString()),
                    expected_result, actual_result);

            actual_result = DateCalculator.DateAdd(d.toString(), 5);
            assertEquals(String.format("DateAdd(%s,%d) Function should return INVALID_DATE but it returned %s",
                    d.toString(), 5, actual_result),
                    expected_result, actual_result);
        }

        for (Date d: data) {
            LocalDate today = LocalDate.of(d.Year, d.Month, d.Day);
            int days_period = randGenerator.nextInt(5000);
            LocalDate calc_day =  today.plusDays(days_period);
            assertEquals(String.format("Error testing DateAdd(%s,%d)", today.format(foramtter), days_period),
                calc_day.format(foramtter),
                DateCalculator.DateAdd(d.toString(), days_period));
            calc_day =  today.minusDays(days_period);
            assertEquals(String.format("Error testing DateAdd(%s,-%d)", today.format(foramtter), days_period),
                    calc_day.format(foramtter),
                    DateCalculator.DateAdd(d.toString(), -days_period));
        }
    }

    @Test
    public void testDateDiff() {
        for (Date d: invalidData) {
            int actual_result;
            actual_result = DateCalculator.DateDiff(d.Year, d.Month, d.Day, 1991, 4, 2);
            int expected_result = Integer.MAX_VALUE;
            assertEquals(String.format("DateDiffDateDiff Function should return %d but it returned %d",
                    d.Year, d.Month, d.Day, expected_result, actual_result),
                    expected_result, actual_result);

            actual_result = DateCalculator.DateDiff(1991, 4, 2, d.Year, d.Month, d.Day);
            int expected_result = Integer.MAX_VALUE;
            assertEquals(String.format("DateDiff(1991, 4, 2, d.Year, d.Month, d.Day) Function should return %d but it returned %d",
                    d.Year, d.Month, d.Day, expected_result, actual_result),
                    expected_result, actual_result);

            String par1 = d.toString();
            String par2 = new Date(1991, 4, 2).toString();
            actual_result = DateCalculator.DateDiff(par1, par2);
            assertEquals(String.format("DateDiff(%s, %s) Function should return %d but it returned %d",
                    par1, par2, expected_result, actual_result),
                expected_result, actual_result);

            actual_result = DateCalculator.DateDiff(par2, par1);
            assertEquals(String.format("DateDiff(%s, %s) Function should return %d but it returned %d",
                    par2, par1, expected_result, actual_result),
                    expected_result, actual_result);
        }

        for (Date d: data) {
            int actual_result;
            int expected_result;
            LocalDate calc_day;

            LocalDate today = LocalDate.of(d.Year, d.Month, d.Day);
            int days_period = randGenerator.nextInt(5000);

            actual_result = DateCalculator.DateAdd(d.toString(), days_period));
            calc_day =  today.plusDays(days_period);

            assertEquals(String.format("DateDiff(%s,%s) Function should return %d but it returned %d",
                    today.format(foramtter), calc_day.format(formatter), days_period, actual_result),
                    days_period, actual_result);

            actual_result = DateCalculator.DateAdd(d.toString(), -days_period));
            calc_day =  today.minusDays(days_period);
            assertEquals(String.format("DateDiff(%s,%s) Function should return %d but it returned %d",
                    today.format(foramtter), calc_day.format(formatter), -days_period, actual_result),
                    -days_period, actual_result);
        }
    }
}
