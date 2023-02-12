package watermarker;

public class RGBColor {
    private float red;
    private float green;
    private float blue;

    public RGBColor(float red, float green, float blue) {
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