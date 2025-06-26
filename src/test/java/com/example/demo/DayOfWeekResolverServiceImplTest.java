package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
// import java.time.LocalDate;
import java.util.Locale;

public class DayOfWeekResolverServiceImplTest {

    private DayOfWeekResolverServiceImpl dayOfWeekResolverService;

    @BeforeEach
    void setUp() {
        // Initialize the service
        dayOfWeekResolverService = new DayOfWeekResolverServiceImpl();
    }

    @Test
    void testDetermineDayOfWeek_withValidDate() {
        // Input date: 25th January 2025, which is a Saturday
        int year = 2025;
        int month = 1;
        int dayOfMonth = 25;
        
        // Expected output
        String expectedDayOfWeek = "Saturday"; // Default locale is English
        
        // Call the method
        String result = dayOfWeekResolverService.determineDayOfWeek(year, month, dayOfMonth);
        
        // Verify the result
        assertNotNull(result, "Result should not be null");
        assertEquals(expectedDayOfWeek, result, "Day of week should be Saturday");
    }

    @Test
    void testDetermineDayOfWeek_onLeapYear() {
        // Input date: 29th February 2024, which is a Thursday
        int year = 2024;
        int month = 2;
        int dayOfMonth = 29;

        // Expected output
        String expectedDayOfWeek = "Thursday"; // Default locale is English
        
        // Call the method
        String result = dayOfWeekResolverService.determineDayOfWeek(year, month, dayOfMonth);

        // Verify the result
        assertNotNull(result, "Result should not be null");
        assertEquals(expectedDayOfWeek, result, "Day of week should be Thursday");
    }

    @Test
    void testDetermineDayOfWeek_forEdgeDate() {
        // Input date: 1st January 2025, which is a Wednesday
        int year = 2025;
        int month = 1;
        int dayOfMonth = 1;

        // Expected output
        String expectedDayOfWeek = "Wednesday"; // Default locale is English
        
        // Call the method
        String result = dayOfWeekResolverService.determineDayOfWeek(year, month, dayOfMonth);

        // Verify the result
        assertNotNull(result, "Result should not be null");
        assertEquals(expectedDayOfWeek, result, "Day of week should be Wednesday");
    }

    @Test
    void testDetermineDayOfWeek_forEndOfYear() {
        // Input date: 31st December 2025, which is a Thursday
        int year = 2025;
        int month = 12;
        int dayOfMonth = 31;

        // Expected output
        String expectedDayOfWeek = "Thursday"; // Default locale is English
        
        // Call the method
        String result = dayOfWeekResolverService.determineDayOfWeek(year, month, dayOfMonth);

        // Verify the result
        assertNotNull(result, "Result should not be null");
        assertEquals(expectedDayOfWeek, result, "Day of week should be Thursday");
    }

    @Test
    void testDetermineDayOfWeek_withInvalidDate_shouldThrowException() {
        // Input: Invalid date (February 30th does not exist)
        int year = 2025;
        int month = 2;
        int dayOfMonth = 30;

        try {
            // Call the method with invalid date
            dayOfWeekResolverService.determineDayOfWeek(year, month, dayOfMonth);
        } catch (Exception e) {
            // Verify the exception is thrown for invalid date
            assertEquals("Invalid date", e.getMessage(), "Exception message should be 'Invalid date'");
        }
    }

    @Test
    void testConvertToDayOfWeekName() {
        // Test for all days of the week
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            String dayName = dayOfWeekResolverService.convertToDayOfWeekName(dayOfWeek);
            assertNotNull(dayName, "Day name should not be null");
            assertEquals(dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()), dayName,
                    "Day name should match the expected display name");
        }
    }
}
