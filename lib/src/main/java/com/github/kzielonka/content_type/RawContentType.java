package com.github.kzielonka.content_type;

public class RawContentType {

    private final String raw;

    public RawContentType(String raw) {
        this.raw = raw;
    }

    public ContentType contentType() {
        final var splitRaw = raw.split("/");
        final var type = splitRaw[0];
        final var subtype = splitRaw[1];
        return new ContentType(type, subtype);
    }

    public String toString() {
        return raw;
    }
}
