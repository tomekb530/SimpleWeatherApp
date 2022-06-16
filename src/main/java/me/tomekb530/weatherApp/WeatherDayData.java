package me.tomekb530.weatherApp;

public class WeatherDayData {
    java.time.LocalDate date;
    double maxtemp_c;
    double mintemp_c;
    double avgtemp_c;
    double maxwind_kph;
    double avghumidity;

    public WeatherHourData[] hours;
}
