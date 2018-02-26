package com.powerbroker.resource.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.JSR310DateTimeDeserializerBase;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by wjwjtftf on 2017/3/14.
 */
@JsonComponent
public class DateTimeJsonComponent {

    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;

    public static class DateTimeSerializer extends LocalDateTimeSerializer {
        public DateTimeSerializer() {
            super(DEFAULT_DATETIME_FORMATTER);
        }
    }

    public static class DateTimeDeserializer extends JSR310DateTimeDeserializerBase<LocalDateTime> {

        public DateTimeDeserializer() {
            super(LocalDateTime.class, DEFAULT_DATETIME_FORMATTER);
        }

        @Override
        protected JsonDeserializer<LocalDateTime> withDateFormat(DateTimeFormatter dtf) {
            return null;
        }

        @Override
        public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {

            if (parser.hasTokenId(JsonTokenId.ID_STRING)) {
                String string = parser.getText().trim();
                if (string.length() == 0) {
                    return null;
                }
                if (string.length() == 10) {
                    string += "T00:00:00";
                }

                try {
                    return LocalDateTime.parse(string, _formatter);
                } catch (DateTimeException e) {
                    _rethrowDateTimeException(parser, context, e, string);
                }
            }

            return null;
        }
    }

    public static class DateSerializer extends LocalDateSerializer {
        public DateSerializer() {
            super(DEFAULT_DATE_FORMATTER);
        }
    }

    public static class DateDeserializer extends LocalDateDeserializer {
        public DateDeserializer() {
            super(DEFAULT_DATE_FORMATTER);
        }
    }

    public static class TimeSerializer extends LocalTimeSerializer {
        public TimeSerializer() {
            super(DEFAULT_TIME_FORMATTER);
        }
    }

    public static class TimeDeserializer extends LocalTimeDeserializer {
        public TimeDeserializer() {
            super(DEFAULT_TIME_FORMATTER);
        }
    }
}
