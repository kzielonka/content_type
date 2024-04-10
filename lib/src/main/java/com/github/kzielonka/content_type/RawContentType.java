package com.github.kzielonka.content_type;

import com.github.kzielonka.content_type.parser.TypeStep;

public class RawContentType {

    private final String raw;

    public RawContentType(String raw) {
        this.raw = raw;
    }

    public ContentType contentType() {
        final var parser = new TypeStep(raw);
        final var type = parser.type();
        final var subtype = parser.rest();
        return new ContentType(type, subtype);
    }

    public String toString() {
        return raw;
    }
}
