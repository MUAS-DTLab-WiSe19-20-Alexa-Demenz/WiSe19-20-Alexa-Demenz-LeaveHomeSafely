package leavehomesafely.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import leavehomesafely.PhrasesAndConstants;
import leavehomesafely.model.GoogleCalendar;
import leavehomesafely.model.OWMAPI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class LeaveHomeSafelyHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("LeaveHomeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speech = "";

        speech = speech + GoogleCalendar.checkEventsWithinNextHour();

        if (LocalDate.now().getDayOfMonth() <= 3) {
            speech = speech + PhrasesAndConstants.TRAVELTICKET;
        }

        speech = speech + PhrasesAndConstants.WINDOW + PhrasesAndConstants.ITEMS;

        speech = speech + getWeatherInformation();

        return input.getResponseBuilder()
                .withSimpleCard(PhrasesAndConstants.CARD_TITLE, speech)
                .withSpeech(speech)
                .withShouldEndSession(false)
                .build();
    }

    public static String getWeatherInformation () {
        String speech = "";

        JSONObject obj = OWMAPI.getCurrentWeather();

        if (obj != null) {

            String we_desc = "";
            String we = "";

            JSONArray arr = obj.getJSONArray("weather");
            for (int i = 0; i < arr.length(); i++) {
                we_desc = arr.getJSONObject(i).getString("description");
                we = arr.getJSONObject(i).getString("main");
            }
            speech = speech + "Das Wetter draußen: " + we_desc + ". ";

            Double rain = Double.NaN;
            try {
                arr = obj.getJSONArray("rain");
                for (int i = 0; i < arr.length(); i++) {
                    rain = Double.parseDouble(arr.getJSONObject(i).getString("1h"));
                }
            } catch (Exception  e) {}

            if (we.toLowerCase().contains("rain")) {
                speech = speech + PhrasesAndConstants.RAIN;
            } else if (rain != Double.NaN && rain > 0.75) {
                speech = speech + PhrasesAndConstants.RAIN_PROB;
            }

            double temp = Double.NaN;
            try {
                JSONObject ma = obj.getJSONObject("main");
                temp = ma.getDouble("temp");
            } catch (Exception e) {}

            if (temp != Double.NaN && temp < 15 && temp > 5) {
                speech = speech + PhrasesAndConstants.JACKET_NORMAL;
            } else if (temp != Double.NaN && temp <= 5) {
                speech = speech + PhrasesAndConstants.JACKET_COLD;
            }
        }
        return speech;
    }
}
