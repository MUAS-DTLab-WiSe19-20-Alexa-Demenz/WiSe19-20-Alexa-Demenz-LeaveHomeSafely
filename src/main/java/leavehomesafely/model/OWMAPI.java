package leavehomesafely.model;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OWMAPI {

    public static JSONObject getCurrentWeather () {
        try {
            int loc_id = 2867714;
            String key = "&APPID=" + System.getenv("OWM_API_KEY");
            //String key = "&APPID=4219aa4c3208d03913982923614a7d6d"; //ID ist hier nur zu Debug und lokalen Testzwecken eingetragen!
            String metric = "&units=metric";
            String lang = "&lang=de";

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=" + loc_id + metric + lang + key);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            output = br.readLine();

            JSONObject obj = new JSONObject(output);
            conn.disconnect();
            return obj;
        } catch (Exception e) {}
        return null;
    }
}
