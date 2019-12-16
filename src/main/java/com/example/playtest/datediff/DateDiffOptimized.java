package com.example.playtest.datediff;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

import java.util.stream.*;
import static java.util.stream.IntStream.*;

public class DateDiffOptimized extends DateDiff {

    public int getDaysBetween(LocalDate start, LocalDate end) {
        // Don't count each day. Calculate for full years, full months.
        // Have the code as readable as possible.
        // Compute, don't use existing code.
        // Can use YearMonth.of(y, m).lengthOfMonth() for daysInMonth, Year.of(y).length() for daysInYear
        return 0;
    }
}
