package java8tutorial.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class DateTimeExamples
{
    public static void main(String[] args)
    {
        // Monatsende
        LocalDate today = LocalDate.now();
        LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);

        // Geburtstage
        LocalDate dateOfBirth = LocalDate.of(2012, Month.MAY, 14);
        LocalDate firstBirthday = dateOfBirth.plusYears(1);

        // Datumsberechnung TemporalAdjusters
        LocalDate date = LocalDate.of(2000, Month.OCTOBER, 15);
        DayOfWeek dotw = date.getDayOfWeek();
        System.out.printf("%s is on a %s%n", date, dotw);

        System.out.printf("first day of Month: %s%n", date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.printf("first Monday of Month: %s%n", date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.printf("last day of Month: %s%n", date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.printf("first day of next Month: %s%n", date.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.printf("first day of next Year: %s%n", date.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.printf("first day of Year: %s%n", date.with(TemporalAdjusters.firstDayOfYear()));

        // Zahltag
        LocalDate now = LocalDate.now();
        LocalDate nextPayday = now.with(new PaydayAdjuster());

    }
}
