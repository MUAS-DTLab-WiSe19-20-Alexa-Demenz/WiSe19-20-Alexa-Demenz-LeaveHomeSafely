package leavehomesafely.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.model.Slot;
import com.amazon.ask.request.RequestHelper;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import leavehomesafely.PhrasesAndConstants;
import leavehomesafely.model.GoogleCalendar;

import static com.amazon.ask.request.Predicates.intentName;

public class GetEventsHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("GetEventsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String speech = "";

        RequestHelper requestHelper = RequestHelper.forHandlerInput(input);
        Optional<String> string = requestHelper.getSlotValue("Anzahl");

        int number = Integer.parseInt(string.orElse("5"));

        List<Event> items = GoogleCalendar.getNextAppointments(number);

        if (items.isEmpty()) {
            speech = speech + PhrasesAndConstants.NO_EVENTS;
        } else {
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    speech = speech + event.getSummary() + " ";
                } else {
                    speech = speech + event.getSummary() + " " + start + " ";
                }
            }
        }

        return input.getResponseBuilder()
                .withSimpleCard(PhrasesAndConstants.CARD_TITLE, speech)
                .withSpeech(speech)
                .withShouldEndSession(false)
                .build();
    }
}
