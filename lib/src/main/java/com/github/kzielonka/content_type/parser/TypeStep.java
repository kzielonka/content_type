package com.github.kzielonka.content_type.parser;

public class TypeStep {

    private static String[] buildInTypes = new String[]{
            "application", "audio", "image", "message", "multipart", "text", "video"
    };

    private final String text;

    public TypeStep(String text) {
        this.text = text;
    }

    public String type() {
        for (String buildInType : buildInTypes) {
            if (text.startsWith(buildInType + "/")) {
                return buildInType;
            }
        }
        throw new RuntimeException("invalid type");
    }

    public String rest() {
        return text.substring(type().length() + 1);
    }
}
