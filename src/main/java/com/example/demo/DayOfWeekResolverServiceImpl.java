package com.example.demo;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class DayOfWeekResolverServiceImpl implements DayOfWeekResolverService
{
  @Override
  public String determineDayOfWeek(int year, int month, int dayOfMonth)
  {
    LocalDate resolvedLocalDate = LocalDate.of(year, month, dayOfMonth);
    return convertToDayOfWeekName(resolvedLocalDate.getDayOfWeek());
  }
 
  public String convertToDayOfWeekName(DayOfWeek dayOfWeek)
  {
    return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
  }
  
}