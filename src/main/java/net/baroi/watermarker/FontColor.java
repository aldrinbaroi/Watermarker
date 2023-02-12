package net.baroi.watermarker;

public class FontColor {
    private float red;
    private float green;
    private float blue;

    /**
     * 
     * @param red 
     * @param green
     * @param blue
     * 
     * Aceptable values: 0 - 255
     */
    public FontColor(float red, float green, float blue) {
        this.red = red / 255;
        this.green = green / 255;
        this.blue = blue / 255;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }
    
}