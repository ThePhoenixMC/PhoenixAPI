/*
 * MIT License
 *
 * Copyright (c) 2018 PhoenixMC and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.lss233.phoenix.text;

public enum TextColor {
    BLACK('0',"Black",0,0,0,0x000000,0,0,0,0x000000),
    DARK_BLUE('1',"Dark Blue",0,0,170,0x0000AA,0,0,42,0x00002A),
    DARK_GREEN('2',"Dark Green",0,170,0,0x00AA00,0,42, 0, 0x002A00),
    DARK_AQUA('3',"Dark Aqua",0,170,170,0x00AAAA,0,42,42,0x002A2A),
    DARK_RED('4',"Dark Red",170,0,0,0xAA0000,42,0,0,0x2A0000),
    DARK_PURPLE('5',"Dark Purple",170,0,170,0xAA00AA,42,0,42,0x2A002A),
    GOLD('6',"Gold",255,170,0,0xFFAA00,42,42,0,0x2A2A00),
    GRAY('7',"Gray",170,170,170,0xAAAAAA,42,42,42,0x2A2A2A),
    DARK_GRAY('8',"Dark Gray",85,85,85,0x555555,21,21,21,0x151515),
    BLUE('9',"Blue",85,85,255,0x5555FF,21,21,63,0x15153F),
    GREEN('a',"Green",85,255,85,0x55FF55,21,63,21,0x153F15),
    AQUA('b',"Aqua",85,255,255,0x55FFFF,21,63,63,0x153F3F),
    RED('c',"Red",255,85,85,0xFF5555,63,21,21,0x3F1515),
    LIGHT_PURPLE('d',"Light Purple",255,85,255,0xFF55FF,63,21,63,0x3F153F),
    YELLOW('e',"Yellow",255,255,85,0xFFFF55,63,63,21,0x3F3F15),
    WHITE('f',"White",255,255,255,0xFFFFFF,63,63,63,0x3F3F3F);

    private final char code;
    private final String officialName;
    private final int foregroundR;
    private final int foregroundG;
    private final int foregroundB;
    private final int foregroundHex;
    private final int backgroundR;
    private final int backgroundG;
    private final int backgroundB;
    private final int backgroundHex;

    TextColor(char code, String officialName, int foregroundR, int foregroundG, int foregroundB, int foregroundHex, int backgroundR, int backgroundG, int backgroundB, int backgroundHex) {
        this.code = code;
        this.officialName = officialName;
        this.foregroundR = foregroundR;
        this.foregroundG = foregroundG;
        this.foregroundB = foregroundB;
        this.foregroundHex = foregroundHex;
        this.backgroundR = backgroundR;
        this.backgroundG = backgroundG;
        this.backgroundB = backgroundB;
        this.backgroundHex = backgroundHex;
    }

    /**
     * Gets the code of this color.
     *
     * @return The code
     */
    public char getCode() {
        return code;
    }

    /**
     * Gets the official name of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The officialName
     */
    public String getOfficialName() {
        return officialName;
    }

    /**
     * Gets the foreground red value of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The foreground red value of this color.
     */
    public int getForegroundR() {
        return foregroundR;
    }

    /**
     * Gets the foreground green value of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The foreground green value of this color.
     */
    public int getForegroundG() {
        return foregroundG;
    }

    /**
     * Gets the foreground blue value of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The foreground blue value of this color.
     */
    public int getForegroundB() {
        return foregroundB;
    }

    /**
     * Gets the foreground color hex of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The hex of foreground color
     */
    public int getForegroundHex() {
        return foregroundHex;
    }

    /**
     * Gets the background red value of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The background red value
     */
    public int getBackgroundR() {
        return backgroundR;
    }

    /**
     * Gets the background green value of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The background green value
     */
    public int getBackgroundG() {
        return backgroundG;
    }

    /**
     * Gets the background blue value of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The background blue value
     */
    public int getBackgroundB() {
        return backgroundB;
    }

    /**
     * Gets the backgroundHex of this color.
     * See <a href="https://minecraft.gamepedia.com/Formatting_codes#Color_codes">here</a>.
     *
     * @return The hex of background color
     */
    public int getBackgroundHex() {
        return backgroundHex;
    }
}
