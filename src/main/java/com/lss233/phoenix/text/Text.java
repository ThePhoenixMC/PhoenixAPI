package com.lss233.phoenix.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Represents an tree-structure of formatted (text) components. Each
 * instance consists of content and a list of children texts appended after the
 * content of this text. The content of the text is available through one of the
 * subclasses.
 *
 * <p>Text is primarily used for sending formatted chat messages to players, but
 * also in other places like books or signs.</p>
 *
 * <p>Text instances can be created through the available {@link #of(String)} methods
 * or using one of the {@link Builder}s available through one of the
 * {@link #builder()} methods.</p>
 *
 * @see Text#builder()
 * @see Builder
 */

public class Text {

    private static final char MINECRAFT_COLOR_CHARACTER = '§';
    private String content;
    private TextStyle style;
    private TextColor color;
    private List<Text> children;

    public Text(String content, TextStyle style, TextColor color, List<Text> children) {
        this.content = content;
        this.style = style;
        this.color = color;
        this.children = children;
    }

    /**
     * Creates a {@link Text.Builder} with empty text.
     *
     * @return A new text builder with empty text
     */
    public static Text.Builder builder() {
        return new Builder("");
    }

    /**
     * Creates a {@link Text.Builder} with empty text.
     *
     * @param content The content of the text
     * @return A new text builder with text
     */
    public static Text.Builder builder(String content) {
        return new Builder(content);
    }

    /**
     * Creates a {@link Text} with the specified plain text
     * and using an alternate color code character into a
     * string that uses the internal Minecraft color code.
     *
     * @param content The content of the text
     * @param character  The character that wants to replace
     * @return The created text
     */
    public static Text of(String content, char character){
        content = content.replace(character, Text.MINECRAFT_COLOR_CHARACTER);
        return of(content);
    }

    /**
     * Creates a {@link Text} with the specified plain text.
     *
     * @param content The content of the text
     * @return The created text
     */
    public static Text of(String content){
        return new Builder(content).build();
    }

    /**
     * Returns the immutable list of children appended after the content of this
     * {@link Text}.
     *
     * @return The immutable list of children
     */
    public final List<Text> getChildren() {
        return this.children;
    }

    /**
     * Gets the content of this instance.
     *
     * @return The content
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets the style of this instance.
     *
     * @return The style
     */
    public TextStyle getStyle() {
        return style;
    }

    /**
     * Gets the color of this instance.
     *
     * @return The color
     */
    public TextColor getColor() {
        return color;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MINECRAFT_COLOR_CHARACTER).append(getStyle().getCode());
        stringBuilder.append(MINECRAFT_COLOR_CHARACTER).append(getColor().getCode());
        stringBuilder.append(content);
        for (Text text : getChildren()) {
            stringBuilder.append(text.toString());
        }
        return stringBuilder.toString();
    }

    public static class Builder {
        private List<Text> children = new ArrayList<>();
        private TextStyle style = TextStyle.RESET;
        private TextColor color = TextColor.WHITE;
        private String content;

        Builder(String content) {
            this.content = content;
        }

        /**
         * Appends the specified {@link Text} to the end of this text.
         *
         * @param children The texts to append
         * @return This text builder
         * @see Text#getChildren()
         */
        public Builder append(Text... children){
            Collections.addAll(this.children, children);
            return this;
        }

        /**
         * Returns a view of the current children of this builder.
         *
         * <p>The returned list is unmodifiable, but not immutable. It will
         * change if new children get added through this builder.</p>
         *
         * @return An unmodifiable list of the current children
         * @see Text#getChildren()
         */
        public final List<Text> getChildren() {
            return Collections.unmodifiableList(this.children);
        }

        /**
         * Returns the children.
         *
         * @param children The children
         * @return The builder instance.
         */
        public Builder setChildren(List<Text> children) {
            this.children = children;
            return this;
        }

        /**
         * Gets the style of this instance.
         *
         * @return The style
         */
        public TextStyle getStyle() {
            return style;
        }

        /**
         * Returns the style.
         *
         * @param style The style
         * @return The builder instance.
         */
        public Builder setStyle(TextStyle style) {
            this.style = style;
            return this;
        }

        /**
         * Gets the color of this instance.
         *
         * @return The color
         */
        public TextColor getColor() {
            return color;
        }

        /**
         * Returns the color.
         *
         * @param color The color
         * @return The builder instance.
         */
        public Builder setColor(TextColor color) {
            this.color = color;
            return this;
        }

        /**
         * Gets the content of this instance.
         *
         * @return The content
         */
        public String getContent() {
            return content;
        }

        /**
         * Returns the content.
         *
         * @param content The content
         * @return The builder instance.
         */
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * Builds an instance of the current state of this text
         * builder.
         *
         * @return A {@link Text} with the current properties of this
         *         builder
         */
        public Text build() {
            return new Text(getContent(), getStyle(), getColor(), getChildren());
        }
    }
}
