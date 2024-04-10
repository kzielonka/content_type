package com.github.kzielonka.content_type;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RawContentTypeTest {

    @Test
    void convertsToContentTypeAndBack() {
        final var rawString = "application/json";
        final var raw = new RawContentType(rawString);
        final var contentType = raw.contentType();
        final var rawAgain = contentType.raw();
        final var rawAgainString = rawAgain.toString();
        assertThat(rawAgainString).isEqualTo(rawString);
    }

    @ParameterizedTest
    @ValueSource(strings = { "application", "audio", "image", "message", "multipart", "video", "text" })
    void parsesType(String type) {
        final var rawString = "%s/subtype".formatted(type);
        final var raw = new RawContentType(rawString);
        final var contentType = raw.contentType();
        assertThat(contentType.type).isEqualTo(type);
        assertThat(contentType.subtype).isEqualTo("subtype");
    }
}
