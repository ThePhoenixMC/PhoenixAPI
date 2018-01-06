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
    private List<Text> children;

    public Text(List<Text> children) {
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

    public static class Builder {
        private List<Text> children = new ArrayList<>();
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
        public final List getChildren() {
            return Collections.unmodifiableList(this.children);
        }

        /**
         * Builds an instance of the current state of this text
         * builder.
         *
         * @return A {@link Text} with the current properties of this
         *         builder
         */
        public Text build() {
            return new Text(this.children);
        }
    }
}
