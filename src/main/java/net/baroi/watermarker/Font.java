package net.baroi.watermarker;

import org.apache.pdfbox.pdmodel.font.PDFont;

public class Font {

    private final PDFont font;
    private final float size;
    private final float heightAdjustmentFactor;
    private FontColor rgbColor;

    public Font(PDFont font, float size, float heightAdjustmentFactor, FontColor rgbColor) {
        this.font = font;
        this.size = size;
        this.heightAdjustmentFactor = heightAdjustmentFactor;
        this.rgbColor = rgbColor;
    }

    public Font(PDFont font, float size, FontColor rgbColor) {
        this(font, size, 4, rgbColor);
    }

    public PDFont getFont() {
        return font;
    }

    public float getSize() {
        return size;
    }

    public float getHeightAdjustmentFactor() {
        return heightAdjustmentFactor;
    }

    public FontColor getFontColor() {
        return rgbColor;
    }

}
