package com.github.kzielonka.content_type;

public class ContentType {

    public final String type;
    public final String subtype;

    public ContentType(String type, String subtype) {
        this.type = type;
        this.subtype = subtype;
    }

    public RawContentType raw() {
        return new RawContentType(type + "/" + subtype);
    }
}
