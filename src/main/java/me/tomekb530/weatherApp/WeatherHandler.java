package me.tomekb530.weatherApp;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class WeatherHandler {
    String apikey = "b2490ec472e94ffc95d103706220606";
    String baseUrl = "http://api.weatherapi.com/v1";
    String currentUrl = baseUrl + "/current.json?key=" + apikey + "&q=";
    String forecastUrl = baseUrl + "/forecast.json?key=" + apikey + "&q=";
    String historyUrl = baseUrl + "/history.json?key=" + apikey + "&q=";
    String searchUrl = baseUrl + "/search.json?key=" + apikey + "&q=";

    //{"location":{"name":"Rososz","region":"","country":"Poland","lat":52.9,"lon":21.65,"tz_id":"Europe/Warsaw","localtime_epoch":1655226436,"localtime":"2022-06-14 19:07"},"forecast":{"forecastday":[{"date":"2022-06-14","date_epoch":1655164800,"day":{"maxtemp_c":16.9,"maxtemp_f":62.4,"mintemp_c":7.8,"mintemp_f":46.0,"avgtemp_c":14.8,"avgtemp_f":58.6,"maxwind_mph":16.1,"maxwind_kph":25.9,"totalprecip_mm":0.9,"totalprecip_in":0.04,"avgvis_km":8.0,"avgvis_miles":4.0,"avghumidity":81.0,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"uv":0.0},"astro":{"sunrise":"04:08 AM","sunset":"09:00 PM","moonrise":"09:40 PM","moonset":"03:33 AM","moon_phase":"Full Moon","moon_illumination":"100"},"hour":[{"time_epoch":1655157600,"time":"2022-06-14 00:00","temp_c":9.1,"temp_f":48.4,"is_day":0,"condition":{"text":"Mist","icon":"//cdn.weatherapi.com/weather/64x64/night/143.png","code":1030},"wind_mph":7.2,"wind_kph":11.5,"wind_degree":269,"wind_dir":"W","pressure_mb":1015.0,"pressure_in":29.98,"precip_mm":0.0,"precip_in":0.0,"humidity":95,"cloud":20,"feelslike_c":7.3,"feelslike_f":45.1,"windchill_c":7.3,"windchill_f":45.1,"heatindex_c":9.1,"heatindex_f":48.4,"dewpoint_c":8.3,"dewpoint_f":46.9,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":2.0,"vis_miles":1.0,"gust_mph":15.0,"gust_kph":24.1},{"time_epoch":1655161200,"time":"2022-06-14 01:00","temp_c":8.7,"temp_f":47.6,"is_day":0,"condition":{"text":"Mist","icon":"//cdn.weatherapi.com/weather/64x64/night/143.png","code":1030},"wind_mph":7.2,"wind_kph":11.6,"wind_degree":267,"wind_dir":"W","pressure_mb":1015.0,"pressure_in":29.98,"precip_mm":0.0,"precip_in":0.0,"humidity":95,"cloud":16,"feelslike_c":6.8,"feelslike_f":44.2,"windchill_c":6.8,"windchill_f":44.2,"heatindex_c":8.7,"heatindex_f":47.6,"dewpoint_c":7.9,"dewpoint_f":46.2,"will_it_rain":0,"chance_of_rain":10,"will_it_snow":0,"chance_of_snow":0,"vis_km":2.0,"vis_miles":1.0,"gust_mph":15.1,"gust_kph":24.4},{"time_epoch":1655164800,"time":"2022-06-14 02:00","temp_c":8.2,"temp_f":46.8,"is_day":0,"condition":{"text":"Mist","icon":"//cdn.weatherapi.com/weather/64x64/night/143.png","code":1030},"wind_mph":7.3,"wind_kph":11.8,"wind_degree":265,"wind_dir":"W","pressure_mb":1015.0,"pressure_in":29.98,"precip_mm":0.0,"precip_in":0.0,"humidity":95,"cloud":12,"feelslike_c":6.2,"feelslike_f":43.2,"windchill_c":6.2,"windchill_f":43.2,"heatindex_c":8.2,"heatindex_f":46.8,"dewpoint_c":7.4,"dewpoint_f":45.4,"will_it_rain":0,"chance_of_rain":10,"will_it_snow":0,"chance_of_snow":0,"vis_km":2.0,"vis_miles":1.0,"gust_mph":15.3,"gust_kph":24.6},{"time_epoch":1655168400,"time":"2022-06-14 03:00","temp_c":7.8,"temp_f":46.0,"is_day":0,"condition":{"text":"Mist","icon":"//cdn.weatherapi.com/weather/64x64/night/143.png","code":1030},"wind_mph":7.4,"wind_kph":11.9,"wind_degree":264,"wind_dir":"W","pressure_mb":1016.0,"pressure_in":29.99,"precip_mm":0.0,"precip_in":0.0,"humidity":95,"cloud":7,"feelslike_c":5.7,"feelslike_f":42.3,"windchill_c":5.7,"windchill_f":42.3,"heatindex_c":7.8,"heatindex_f":46.0,"dewpoint_c":7.0,"dewpoint_f":44.6,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":2.0,"vis_miles":1.0,"gust_mph":15.4,"gust_kph":24.8},{"time_epoch":1655172000,"time":"2022-06-14 04:00","temp_c":9.0,"temp_f":48.1,"is_day":0,"condition":{"text":"Mist","icon":"//cdn.weatherapi.com/weather/64x64/night/143.png","code":1030},"wind_mph":8.9,"wind_kph":14.4,"wind_degree":267,"wind_dir":"W","pressure_mb":1016.0,"pressure_in":30.0,"precip_mm":0.0,"precip_in":0.0,"humidity":92,"cloud":11,"feelslike_c":6.8,"feelslike_f":44.3,"windchill_c":6.8,"windchill_f":44.3,"heatindex_c":9.0,"heatindex_f":48.1,"dewpoint_c":7.7,"dewpoint_f":45.9,"will_it_rain":0,"chance_of_rain":10,"will_it_snow":0,"chance_of_snow":0,"vis_km":4.7,"vis_miles":2.0,"gust_mph":15.6,"gust_kph":25.1},{"time_epoch":1655175600,"time":"2022-06-14 05:00","temp_c":10.1,"temp_f":50.2,"is_day":1,"condition":{"text":"Sunny","icon":"//cdn.weatherapi.com/weather/64x64/day/113.png","code":1000},"wind_mph":10.5,"wind_kph":16.9,"wind_degree":271,"wind_dir":"W","pressure_mb":1016.0,"pressure_in":30.0,"precip_mm":0.0,"precip_in":0.0,"humidity":89,"cloud":16,"feelslike_c":8.0,"feelslike_f":46.3,"windchill_c":8.0,"windchill_f":46.3,"heatindex_c":10.1,"heatindex_f":50.2,"dewpoint_c":8.4,"dewpoint_f":47.1,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":7.3,"vis_miles":4.0,"gust_mph":15.7,"gust_kph":25.3},{"time_epoch":1655179200,"time":"2022-06-14 06:00","temp_c":11.3,"temp_f":52.3,"is_day":1,"condition":{"text":"Sunny","icon":"//cdn.weatherapi.com/weather/64x64/day/113.png","code":1000},"wind_mph":12.1,"wind_kph":19.4,"wind_degree":275,"wind_dir":"W","pressure_mb":1016.0,"pressure_in":30.01,"precip_mm":0.0,"precip_in":0.0,"humidity":86,"cloud":20,"feelslike_c":9.1,"feelslike_f":48.4,"windchill_c":9.1,"windchill_f":48.4,"heatindex_c":11.3,"heatindex_f":52.3,"dewpoint_c":9.1,"dewpoint_f":48.4,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":15.9,"gust_kph":25.6},{"time_epoch":1655182800,"time":"2022-06-14 07:00","temp_c":12.7,"temp_f":54.9,"is_day":1,"condition":{"text":"Sunny","icon":"//cdn.weatherapi.com/weather/64x64/day/113.png","code":1000},"wind_mph":13.1,"wind_kph":21.1,"wind_degree":275,"wind_dir":"W","pressure_mb":1016.0,"pressure_in":30.01,"precip_mm":0.0,"precip_in":0.0,"humidity":80,"cloud":38,"feelslike_c":11.2,"feelslike_f":52.2,"windchill_c":11.2,"windchill_f":52.2,"heatindex_c":12.7,"heatindex_f":54.9,"dewpoint_c":9.2,"dewpoint_f":48.6,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":16.4,"gust_kph":26.4},{"time_epoch":1655186400,"time":"2022-06-14 08:00","temp_c":14.1,"temp_f":57.4,"is_day":1,"condition":{"text":"Cloudy","icon":"//cdn.weatherapi.com/weather/64x64/day/119.png","code":1006},"wind_mph":14.2,"wind_kph":22.8,"wind_degree":274,"wind_dir":"W","pressure_mb":1017.0,"pressure_in":30.02,"precip_mm":0.0,"precip_in":0.0,"humidity":74,"cloud":56,"feelslike_c":13.4,"feelslike_f":56.1,"windchill_c":13.4,"windchill_f":56.1,"heatindex_c":14.1,"heatindex_f":57.4,"dewpoint_c":9.4,"dewpoint_f":48.9,"will_it_rain":0,"chance_of_rain":2,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":16.9,"gust_kph":27.2},{"time_epoch":1655190000,"time":"2022-06-14 09:00","temp_c":15.5,"temp_f":59.9,"is_day":1,"condition":{"text":"Cloudy","icon":"//cdn.weatherapi.com/weather/64x64/day/119.png","code":1006},"wind_mph":15.2,"wind_kph":24.5,"wind_degree":274,"wind_dir":"W","pressure_mb":1017.0,"pressure_in":30.02,"precip_mm":0.0,"precip_in":0.0,"humidity":67,"cloud":74,"feelslike_c":15.5,"feelslike_f":59.9,"windchill_c":15.5,"windchill_f":59.9,"heatindex_c":15.5,"heatindex_f":59.9,"dewpoint_c":9.5,"dewpoint_f":49.1,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":17.4,"gust_kph":28.1},{"time_epoch":1655193600,"time":"2022-06-14 10:00","temp_c":15.5,"temp_f":59.8,"is_day":1,"condition":{"text":"Cloudy","icon":"//cdn.weatherapi.com/weather/64x64/day/119.png","code":1006},"wind_mph":15.2,"wind_kph":24.5,"wind_degree":275,"wind_dir":"W","pressure_mb":1017.0,"pressure_in":30.03,"precip_mm":0.0,"precip_in":0.0,"humidity":69,"cloud":78,"feelslike_c":15.5,"feelslike_f":59.8,"windchill_c":15.5,"windchill_f":59.8,"heatindex_c":15.5,"heatindex_f":59.8,"dewpoint_c":9.9,"dewpoint_f":49.8,"will_it_rain":0,"chance_of_rain":2,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":18.6,"gust_kph":29.9},{"time_epoch":1655197200,"time":"2022-06-14 11:00","temp_c":15.4,"temp_f":59.8,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":15.2,"wind_kph":24.5,"wind_degree":276,"wind_dir":"W","pressure_mb":1017.0,"pressure_in":30.03,"precip_mm":0.1,"precip_in":0.0,"humidity":71,"cloud":81,"feelslike_c":15.4,"feelslike_f":59.8,"windchill_c":15.4,"windchill_f":59.8,"heatindex_c":15.4,"heatindex_f":59.8,"dewpoint_c":10.2,"dewpoint_f":50.4,"will_it_rain":1,"chance_of_rain":80,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":19.7,"gust_kph":31.7},{"time_epoch":1655200800,"time":"2022-06-14 12:00","temp_c":15.4,"temp_f":59.7,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":15.2,"wind_kph":24.5,"wind_degree":278,"wind_dir":"W","pressure_mb":1017.0,"pressure_in":30.03,"precip_mm":0.13,"precip_in":0.01,"humidity":73,"cloud":85,"feelslike_c":15.4,"feelslike_f":59.7,"windchill_c":15.4,"windchill_f":59.7,"heatindex_c":15.4,"heatindex_f":59.7,"dewpoint_c":10.6,"dewpoint_f":51.1,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":20.8,"gust_kph":33.5},{"time_epoch":1655204400,"time":"2022-06-14 13:00","temp_c":15.9,"temp_f":60.6,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":15.5,"wind_kph":25.0,"wind_degree":280,"wind_dir":"W","pressure_mb":1017.0,"pressure_in":30.03,"precip_mm":0.07,"precip_in":0.0,"humidity":71,"cloud":76,"feelslike_c":15.9,"feelslike_f":60.6,"windchill_c":15.9,"windchill_f":60.6,"heatindex_c":15.9,"heatindex_f":60.6,"dewpoint_c":10.6,"dewpoint_f":51.0,"will_it_rain":1,"chance_of_rain":80,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":20.5,"gust_kph":33.0},{"time_epoch":1655208000,"time":"2022-06-14 14:00","temp_c":16.4,"temp_f":61.5,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":15.8,"wind_kph":25.4,"wind_degree":282,"wind_dir":"WNW","pressure_mb":1017.0,"pressure_in":30.03,"precip_mm":0.1,"precip_in":0.0,"humidity":68,"cloud":67,"feelslike_c":16.4,"feelslike_f":61.5,"windchill_c":16.4,"windchill_f":61.5,"heatindex_c":16.4,"heatindex_f":61.5,"dewpoint_c":10.5,"dewpoint_f":51.0,"will_it_rain":1,"chance_of_rain":80,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":20.2,"gust_kph":32.5},{"time_epoch":1655211600,"time":"2022-06-14 15:00","temp_c":16.9,"temp_f":62.4,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":16.1,"wind_kph":25.9,"wind_degree":284,"wind_dir":"WNW","pressure_mb":1017.0,"pressure_in":30.03,"precip_mm":0.13,"precip_in":0.01,"humidity":66,"cloud":58,"feelslike_c":16.9,"feelslike_f":62.4,"windchill_c":16.9,"windchill_f":62.4,"heatindex_c":16.9,"heatindex_f":62.4,"dewpoint_c":10.5,"dewpoint_f":50.9,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":19.9,"gust_kph":32.0},{"time_epoch":1655215200,"time":"2022-06-14 16:00","temp_c":16.2,"temp_f":61.2,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":14.7,"wind_kph":23.6,"wind_degree":284,"wind_dir":"WNW","pressure_mb":1017.0,"pressure_in":30.04,"precip_mm":0.07,"precip_in":0.0,"humidity":70,"cloud":61,"feelslike_c":15.8,"feelslike_f":60.4,"windchill_c":15.8,"windchill_f":60.4,"heatindex_c":16.2,"heatindex_f":61.2,"dewpoint_c":10.6,"dewpoint_f":51.1,"will_it_rain":1,"chance_of_rain":80,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":18.9,"gust_kph":30.5},{"time_epoch":1655218800,"time":"2022-06-14 17:00","temp_c":15.6,"temp_f":60.0,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":13.3,"wind_kph":21.4,"wind_degree":284,"wind_dir":"WNW","pressure_mb":1017.0,"pressure_in":30.04,"precip_mm":0.1,"precip_in":0.0,"humidity":73,"cloud":65,"feelslike_c":14.7,"feelslike_f":58.5,"windchill_c":14.7,"windchill_f":58.5,"heatindex_c":15.6,"heatindex_f":60.0,"dewpoint_c":10.8,"dewpoint_f":51.4,"will_it_rain":1,"chance_of_rain":80,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":18.0,"gust_kph":28.9},{"time_epoch":1655222400,"time":"2022-06-14 18:00","temp_c":14.9,"temp_f":58.8,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":11.9,"wind_kph":19.1,"wind_degree":285,"wind_dir":"WNW","pressure_mb":1018.0,"pressure_in":30.05,"precip_mm":0.13,"precip_in":0.01,"humidity":77,"cloud":68,"feelslike_c":13.6,"feelslike_f":56.5,"windchill_c":13.6,"windchill_f":56.5,"heatindex_c":14.9,"heatindex_f":58.8,"dewpoint_c":10.9,"dewpoint_f":51.6,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":17.0,"gust_kph":27.4},{"time_epoch":1655226000,"time":"2022-06-14 19:00","temp_c":13.5,"temp_f":56.4,"is_day":1,"condition":{"text":"Light rain shower","icon":"//cdn.weatherapi.com/weather/64x64/day/353.png","code":1240},"wind_mph":10.4,"wind_kph":16.8,"wind_degree":277,"wind_dir":"W","pressure_mb":1018.0,"pressure_in":30.06,"precip_mm":0.07,"precip_in":0.0,"humidity":81,"cloud":60,"feelslike_c":12.1,"feelslike_f":53.8,"windchill_c":12.1,"windchill_f":53.8,"heatindex_c":13.5,"heatindex_f":56.4,"dewpoint_c":10.3,"dewpoint_f":50.6,"will_it_rain":1,"chance_of_rain":80,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":16.6,"gust_kph":26.8},{"time_epoch":1655229600,"time":"2022-06-14 20:00","temp_c":12.2,"temp_f":53.9,"is_day":1,"condition":{"text":"Partly cloudy","icon":"//cdn.weatherapi.com/weather/64x64/day/116.png","code":1003},"wind_mph":9.0,"wind_kph":14.5,"wind_degree":270,"wind_dir":"W","pressure_mb":1018.0,"pressure_in":30.06,"precip_mm":0.0,"precip_in":0.0,"humidity":86,"cloud":52,"feelslike_c":10.7,"feelslike_f":51.2,"windchill_c":10.7,"windchill_f":51.2,"heatindex_c":12.2,"heatindex_f":53.9,"dewpoint_c":9.8,"dewpoint_f":49.6,"will_it_rain":0,"chance_of_rain":1,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":16.3,"gust_kph":26.2},{"time_epoch":1655233200,"time":"2022-06-14 21:00","temp_c":10.8,"temp_f":51.4,"is_day":0,"condition":{"text":"Partly cloudy","icon":"//cdn.weatherapi.com/weather/64x64/night/116.png","code":1003},"wind_mph":7.6,"wind_kph":12.2,"wind_degree":263,"wind_dir":"W","pressure_mb":1018.0,"pressure_in":30.07,"precip_mm":0.0,"precip_in":0.0,"humidity":90,"cloud":44,"feelslike_c":9.2,"feelslike_f":48.6,"windchill_c":9.2,"windchill_f":48.6,"heatindex_c":10.8,"heatindex_f":51.4,"dewpoint_c":9.2,"dewpoint_f":48.6,"will_it_rain":0,"chance_of_rain":0,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":15.9,"gust_kph":25.6},{"time_epoch":1655236800,"time":"2022-06-14 22:00","temp_c":10.2,"temp_f":50.4,"is_day":0,"condition":{"text":"Partly cloudy","icon":"//cdn.weatherapi.com/weather/64x64/night/116.png","code":1003},"wind_mph":7.8,"wind_kph":12.5,"wind_degree":262,"wind_dir":"W","pressure_mb":1018.0,"pressure_in":30.07,"precip_mm":0.0,"precip_in":0.0,"humidity":91,"cloud":48,"feelslike_c":8.5,"feelslike_f":47.2,"windchill_c":8.5,"windchill_f":47.2,"heatindex_c":10.2,"heatindex_f":50.4,"dewpoint_c":8.8,"dewpoint_f":47.9,"will_it_rain":0,"chance_of_rain":1,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":16.3,"gust_kph":26.2},{"time_epoch":1655240400,"time":"2022-06-14 23:00","temp_c":9.6,"temp_f":49.3,"is_day":0,"condition":{"text":"Partly cloudy","icon":"//cdn.weatherapi.com/weather/64x64/night/116.png","code":1003},"wind_mph":7.9,"wind_kph":12.7,"wind_degree":262,"wind_dir":"W","pressure_mb":1018.0,"pressure_in":30.08,"precip_mm":0.0,"precip_in":0.0,"humidity":92,"cloud":52,"feelslike_c":7.7,"feelslike_f":45.9,"windchill_c":7.7,"windchill_f":45.9,"heatindex_c":9.6,"heatindex_f":49.3,"dewpoint_c":8.5,"dewpoint_f":47.2,"will_it_rain":0,"chance_of_rain":1,"will_it_snow":0,"chance_of_snow":0,"vis_km":10.0,"vis_miles":6.0,"gust_mph":16.6,"gust_kph":26.8}]}]}}
    // get history weather
    public WeatherDayData getHistoryWeather(String city, java.time.LocalDate date) throws IOException {
        String histDate = date.toString();
        //encode url
        String url = historyUrl + URLEncoder.encode(city,"UTF-8") + "&dt=" + URLEncoder.encode(histDate, "UTF-8") + "&lang=pl";
        URLConnection conn = new URL(url).openConnection();
        conn.connect();
        // MAKE UTF8 SUPPORT!@!!!

        Charset charset = Charset.forName("UTF8");
        InputStreamReader stream = new InputStreamReader(conn.getInputStream(), charset);
        BufferedReader reader = new BufferedReader(stream);
        StringBuffer responseBuffer = new StringBuffer();

        String read = "";
        while ((read = reader.readLine()) != null) {
            responseBuffer.append(read);
        }
        String json = responseBuffer.toString();


        JSONObject jsonObject = new JSONObject(json);
        JSONObject main = jsonObject.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(0);
        JSONObject current = main.getJSONObject("day");
        WeatherDayData weatherDayData = new WeatherDayData();
        String dateString = main.getString("date");
        weatherDayData.date = java.time.LocalDate.parse(dateString);
        weatherDayData.maxtemp_c = current.getDouble("maxtemp_c");
        weatherDayData.mintemp_c = current.getDouble("mintemp_c");
        weatherDayData.avgtemp_c = current.getDouble("avgtemp_c");
        weatherDayData.maxwind_kph = current.getDouble("maxwind_kph");
        weatherDayData.avghumidity = current.getDouble("avghumidity");
        weatherDayData.hours = new WeatherHourData[24];
        JSONArray hourly = main.getJSONArray("hour");
        for (int i = 0; i < 24; i++) {
            JSONObject hour = hourly.getJSONObject(i);
            weatherDayData.hours[i] = new WeatherHourData();
            weatherDayData.hours[i].temp_c = hour.getDouble("temp_c");
            weatherDayData.hours[i].condition = hour.getJSONObject("condition").getString("text");
            weatherDayData.hours[i].wind_kph = hour.getDouble("wind_kph");
            weatherDayData.hours[i].humidity = hour.getDouble("humidity");
            weatherDayData.hours[i].cloud = hour.getDouble("cloud");
            weatherDayData.hours[i].chance_of_rain = hour.getDouble("chance_of_rain");
            weatherDayData.hours[i].feelslike_c = hour.getDouble("feelslike_c");
            weatherDayData.hours[i].date = hour.getString("time");
        }

        return weatherDayData;
    }

    public WeatherDayData getForecastWeather(String city, java.time.LocalDate date) throws IOException {
        String histDate = date.toString();
        String url = forecastUrl + URLEncoder.encode(city,"UTF-8") + "&dt=" + URLEncoder.encode(histDate, "UTF-8") + "&lang=pl";
        URLConnection conn = new URL(url).openConnection();
        conn.connect();
        Charset charset = Charset.forName("UTF8");
        InputStreamReader stream = new InputStreamReader(conn.getInputStream(), charset);
        BufferedReader reader = new BufferedReader(stream);
        StringBuffer responseBuffer = new StringBuffer();

        String read = "";
        while ((read = reader.readLine()) != null) {
            responseBuffer.append(read);
        }
        String json = responseBuffer.toString();
        JSONObject jsonObject = new JSONObject(json);
        JSONObject main = jsonObject.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(0);
        JSONObject current = main.getJSONObject("day");
        WeatherDayData weatherDayData = new WeatherDayData();
        String dateString = main.getString("date");
        weatherDayData.date = java.time.LocalDate.parse(dateString);
        weatherDayData.maxtemp_c = current.getDouble("maxtemp_c");
        weatherDayData.mintemp_c = current.getDouble("mintemp_c");
        weatherDayData.avgtemp_c = current.getDouble("avgtemp_c");
        weatherDayData.maxwind_kph = current.getDouble("maxwind_kph");
        weatherDayData.avghumidity = current.getDouble("avghumidity");
        weatherDayData.hours = new WeatherHourData[24];
        JSONArray hourly = main.getJSONArray("hour");
        for (int i = 0; i < 24; i++) {
            JSONObject hour = hourly.getJSONObject(i);
            weatherDayData.hours[i] = new WeatherHourData();
            weatherDayData.hours[i].temp_c = hour.getDouble("temp_c");
            weatherDayData.hours[i].condition = hour.getJSONObject("condition").getString("text");
            weatherDayData.hours[i].wind_kph = hour.getDouble("wind_kph");
            weatherDayData.hours[i].humidity = hour.getDouble("humidity");
            weatherDayData.hours[i].cloud = hour.getDouble("cloud");
            weatherDayData.hours[i].chance_of_rain = hour.getDouble("chance_of_rain");
            weatherDayData.hours[i].feelslike_c = hour.getDouble("feelslike_c");
            weatherDayData.hours[i].date = hour.getString("time");
        }

        return weatherDayData;
    }

    public WeatherDayData getCurrentWeather(String city) throws IOException {
        return getForecastWeather(city, java.time.LocalDate.now());
    }
}
