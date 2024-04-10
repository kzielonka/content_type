package com.github.kzielonka.content_type;

import org.junit.jupiter.api.Test;

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
}
