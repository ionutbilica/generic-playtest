package com.example.playtest.datediff;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

import static java.util.stream.IntStream.range;

public class DateDiff {

    public int getDaysBetween(LocalDate start, LocalDate end) {
        // You're not allowed to use:
            // Fields and local variables.
            // Any loop (for, while) but streams are ok.
            // Ifs but ternary operator is fine.
        // Have the code as readable as possible.
        // Compute the result, don't use existing code. Don't use shortcuts like timestamp diff.
        // Can use YearMonth.of(y, m).lengthOfMonth() for daysInMonth, Year.of(y).length() for daysInYear
        return fullYears(start, end)
                + fullMonths(start, end)
                + remainingDays(start, end);
    }

    private int fullYears(LocalDate start, LocalDate end) {
        return range(start.getYear() + 1, end.getYear())
                .map(y -> Year.of(y).length())
                .sum();
    }

    private int fullMonths(LocalDate start, LocalDate end) {
        return sameYear(start, end)
                ? fullMonthsSameYear(start, end)
                : fullMonthsUntilEndOfYear(start) + fullMonthsSinceBeginningOfYear(end);
    }

    private boolean sameYear(LocalDate d1, LocalDate d2) {
        return d1.getYear() == d2.getYear();
    }

    private int fullMonthsSameYear(LocalDate start, LocalDate end) {
        return fullMonths(start.getMonthValue() + 1, end.getMonthValue(), start.getYear());
    }

    private int fullMonths(int firstMonth, int untilMonth, int y) {
        return range(firstMonth, untilMonth)
                .map(m -> lengthOfMonth(y, m))
                .sum();
    }

    private int fullMonthsSinceBeginningOfYear(LocalDate d) {
        return fullMonths(1, d.getMonthValue(), d.getYear());
    }

    private int fullMonthsUntilEndOfYear(LocalDate d) {
        return fullMonths(d.getMonthValue() + 1, Month.values().length + 1, d.getYear());
    }

    private int lengthOfMonth(int y, int m) {
        return YearMonth.of(y, m).lengthOfMonth();
    }

    private int remainingDays(LocalDate start, LocalDate end) {
        return sameYear(start, end) && sameMonth(start, end)
                ? end.getDayOfMonth() - start.getDayOfMonth()
                : end.getDayOfMonth() + lengthOfMonth(start.getYear(), start.getMonthValue()) - start.getDayOfMonth();
    }

    private boolean sameMonth(LocalDate d1, LocalDate d2) {
        return d1.getMonthValue() == d2.getMonthValue();
    }
}
