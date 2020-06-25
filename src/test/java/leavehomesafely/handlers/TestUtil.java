package leavehomesafely.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import leavehomesafely.PhrasesAndConstants;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TestUtil {
/*
    public static HandlerInput mockHandlerInput(String favoriteColor,
                                                Map<String, Object> sessionAttributes,
                                                Map<String, Object> persistentAttributes,
                                                Map<String, Object> requestAttributes) {
        final AttributesManager attributesManagerMock = Mockito.mock(AttributesManager.class);
        when(attributesManagerMock.getSessionAttributes()).thenReturn(sessionAttributes);
        when(attributesManagerMock.getPersistentAttributes()).thenReturn(persistentAttributes);
        when(attributesManagerMock.getRequestAttributes()).thenReturn(requestAttributes);


        // Mock Slots
        final RequestEnvelope requestEnvelopeMock = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                        .withIntent(Intent.builder()
                                .putSlotsItem(PhrasesAndConstants.COLOR_SLOT, Slot.builder()
                                        .withName(PhrasesAndConstants.COLOR_SLOT)
                                        .withValue(favoriteColor)
                                        .build())
                                .build())
                        .build())
                .build();


        // Mock Handler input attributes
        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getAttributesManager()).thenReturn(attributesManagerMock);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(input.getRequestEnvelope()).thenReturn(requestEnvelopeMock);

        return input;
    }

    public static Response standardTestForHandle(RequestHandler handler) {
        final Map<String, Object> sessionAttributes = new HashMap<>();
        final Map<String, Object> persistentAttributes = new HashMap<>();
        sessionAttributes.put(PhrasesAndConstants.COLOR_KEY, "Test");
        persistentAttributes.put(PhrasesAndConstants.COLOR_KEY, "Test");
        final HandlerInput inputMock = TestUtil.mockHandlerInput(null, sessionAttributes, persistentAttributes, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        //assertFalse(response.getShouldEndSession());
        assertNotEquals("Test", response.getReprompt());
        assertNotNull(response.getOutputSpeech());
        return response;
    }
    public static Response sessionAttributesTestForHandle(RequestHandler handler) {
        final Map<String, Object> sessionAttributes = new HashMap<>();
        sessionAttributes.put(PhrasesAndConstants.COLOR_KEY, "rot");
        final HandlerInput inputMock = TestUtil.mockHandlerInput(null, sessionAttributes, null, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        //in the WhatsMyColorIntentHandler
        //assertTrue(response.getShouldEndSession());
        assertNotNull(response.getOutputSpeech());
        return response;
    }
    public static Response persistentAttributesTestForHandle(RequestHandler handler) {
        final Map<String, Object> persistentAttributes = new HashMap<>();
        persistentAttributes.put(PhrasesAndConstants.COLOR_KEY, "blau");
        final HandlerInput inputMock = TestUtil.mockHandlerInput(null, null, persistentAttributes, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        //in the WhatsMyColorIntentHandler
        //assertTrue(response.getShouldEndSession());
        assertNotNull(response.getOutputSpeech());
        return response;
    }

    public static Response noAttributesTestForHandle(RequestHandler handler) {
        final HandlerInput inputMock = TestUtil.mockHandlerInput(null, null, null, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        assertFalse(response.getShouldEndSession());
        assertNotNull(response.getOutputSpeech());
        return response;
    }
    public static Response sessionEndedTestForHandle(RequestHandler handler) {
        final HandlerInput inputMock = TestUtil.mockHandlerInput(null, null, null, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();
        assertTrue(response.getShouldEndSession());
        return response;
    }
*/
}
