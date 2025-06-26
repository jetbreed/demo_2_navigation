package com.example.demo;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class DayOfWeekResolverForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int year;
    private int month;
    private int dayOfMonth;
    
    private String dayOfWeek;

    // Getter and setter methods
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        // resolveDayOfWeek(); // Recompute the day of the week whenever year changes
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        // resolveDayOfWeek(); // Recompute the day of the week whenever month changes
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        // resolveDayOfWeek(); // Recompute the day of the week whenever day changes
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    // // Method to resolve the day of the week from year, month, and day
    // private void resolveDayOfWeek() {
    //     try {
    //         LocalDate date = LocalDate.of(year, month, dayOfMonth);
    //         DayOfWeek dayOfWeekEnum = date.getDayOfWeek();
    //         this.dayOfWeek = dayOfWeekEnum.name(); // Converts to uppercase day of the week
    //     } catch (Exception e) {
    //         this.dayOfWeek = "Invalid Date"; // Handle invalid date input
    //     }
    // }
}
