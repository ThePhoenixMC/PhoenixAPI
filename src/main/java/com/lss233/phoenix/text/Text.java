package com.lss233.phoenix.text;

public class Text {



    public static Builder builder(String text) {
        return new Builder(text);
    }

    public static class Builder {

        private String text;

        Builder(String text) {
            this.text = text;
        }
    }
}
