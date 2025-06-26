package com.example.demo;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class DayOfWeekResolverAction {
  
  private final DayOfWeekResolverForm dayOfWeekResolverForm;
  private final DayOfWeekResolverService dayOfWeekResolverService;
  
  // Constructor injection of dependencies
  // @Autowired
  public DayOfWeekResolverAction(
      DayOfWeekResolverForm dayOfWeekResolverForm, 
      DayOfWeekResolverService dayOfWeekResolverService
    ) {
    this.dayOfWeekResolverForm = dayOfWeekResolverForm;
    this.dayOfWeekResolverService = dayOfWeekResolverService;
  }

  // Method to determine the day of the week
  public void determineDayOfWeek() {
    // Extract data from the form
    int year = dayOfWeekResolverForm.getYear();
    int month = dayOfWeekResolverForm.getMonth();
    int dayOfMonth = dayOfWeekResolverForm.getDayOfMonth();
    
    // Call service to get the day of the week
    String dayOfWeekName = dayOfWeekResolverService.determineDayOfWeek(year, month, dayOfMonth);
    
    // Set the determined day of the week into the form
    dayOfWeekResolverForm.setDayOfWeek(dayOfWeekName);
  }
}
