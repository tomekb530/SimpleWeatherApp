package me.tomekb530.weatherApp;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//http://ip-api.com/json
public class LocationHandler {
    //from geoip api
    private String city;
    private String lat;
    private String lon;

    public LocationHandler() throws IOException {
        URLConnection conn = new URL("http://ip-api.com/json").openConnection();
        conn.connect();
        InputStream is = conn.getInputStream();
        StringBuilder sb = new StringBuilder();
        int b;
        while ((b = is.read()) != -1) {
            sb.append((char) b);
        }
        is.close();
        String json = sb.toString();
        JSONObject jsonObject = new JSONObject(json);
        city = jsonObject.getString("city");
        lat = jsonObject.getDouble("lat") + "";
        lon = jsonObject.getDouble("lon") + "";
    }

    public String getLocation(){
        return city;
    }
    public String getLat(){
        return lat;
    }
    public String getLon(){
        return lon;
    }
}
