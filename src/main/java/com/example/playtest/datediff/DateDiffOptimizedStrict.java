package com.example.playtest.datediff;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

import java.util.stream.*;
import static java.util.stream.IntStream.*;

public class DateDiffOptimizedStrict extends DateDiff {

    public int getDaysBetween(LocalDate start, LocalDate end) {
        // Also optimized (see DateDiffOptimized).
        // Not allowed to use:
            // Fields and local variables.
            // Any loop (for, while). Streams are ok.
            // Ifs, ternary operator is fine.
        // Have the code as readable as possible.
        // Compute, don't use existing code.
        return 0;
    }
}
