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
            var actual_result = DateCalculator.DateAdd(d.Year, d.Month, d.Day,5);
            var expected_result = "INVALID_DATE";
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
            assertEquals(Integer.MAX_VALUE, DateCalculator.DateDiff(d.Year, d.Month, d.Day, 1991, 4, 2));
            assertEquals(Integer.MAX_VALUE, DateCalculator.DateDiff(1991, 4, 2, d.Year, d.Month, d.Day));
            assertEquals(Integer.MAX_VALUE, DateCalculator.DateDiff(d.toString(), new Date(1991, 4, 2).toString()));
            assertEquals(Integer.MAX_VALUE, DateCalculator.DateDiff(new Date(1991, 4, 2).toString(), d.toString()));
        }

        for (Date d: data) {
            LocalDate today = LocalDate.of(d.Year, d.Month, d.Day);
            LocalDate yesterday =  today.minusDays(1);
            assertEquals(yesterday.format(foramtter), DateCalculator.Yesterday(d.Year, d.Month, d.Day));
        }
    }
}
