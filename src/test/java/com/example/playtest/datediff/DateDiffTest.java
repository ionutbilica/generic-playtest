package com.example.playtest.datediff;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class DateDiffTest {

    @Test
    public void getDaysBetween() {
        test(new DateDiff());
        test(new DateDiffOptimized());
        test(new DateDiffOptimizedStrict());
    }

    private void test(DateDiff dateDiff) {
        LocalDate start = LocalDate.of(2019, 12, 13);
        LocalDate end = LocalDate.of(2019, 12, 13);
        for (int i = 1; i < 4000; i++) {
            start = start.minusDays(1);
            assertEquals(i, dateDiff.getDaysBetween(start, end), dateDiff.getClass().getSimpleName() + " " + start + " " + end);
        }
    }
}
