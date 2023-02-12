package net.baroi.watermarker;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;

public class Watermarker {

    public static void satermarkPdfFile(final String watermarkText,
            final Font watermarkFont, final File sourcePdfFile, final File targetPdfFile) throws WatermarkerException {

        try (PDDocument doc = PDDocument.load(sourcePdfFile)) {
            PDPageContentStream cs = null;

            float width = 0;
            float height = 0;
            int rotation = 0;

            final float fontSize = watermarkFont.getSize();
            final PDFont font = watermarkFont.getFont();
            final float rgbRed = watermarkFont.getFontColor().getRed();
            final float rgbGreen = watermarkFont.getFontColor().getGreen();
            final float rgbBlue = watermarkFont.getFontColor().getBlue();
            //
            final float stringWidth = font.getStringWidth(watermarkText) / 1000 * fontSize;
            float diagonalLength = 0;
            float angle = 0;
            // x: "horizontal" position in rotated state
            float x = 0; 
            // y: Adjusted height
            final float heightAdjustmentFactor = watermarkFont.getHeightAdjustmentFactor();
            final float y = -fontSize / heightAdjustmentFactor;
            for (PDPage page : doc.getPages()) {
                cs = new PDPageContentStream(doc, page, AppendMode.APPEND, true, true);
                width = page.getMediaBox().getWidth();
                height = page.getMediaBox().getHeight();
                rotation = page.getRotation();
                switch (rotation) {
                    case 90:
                        width = page.getMediaBox().getHeight();
                        height = page.getMediaBox().getWidth();
                        cs.transform(Matrix.getRotateInstance(Math.toRadians(90), height, 0));
                        break;
                    case 180:
                        cs.transform(Matrix.getRotateInstance(Math.toRadians(180), width, height));
                        break;
                    case 270:
                        width = page.getMediaBox().getHeight();
                        height = page.getMediaBox().getWidth();
                        cs.transform(Matrix.getRotateInstance(Math.toRadians(270), 0, width));
                        break;
                    default:
                        break;
                }
                diagonalLength = (float) Math.sqrt(width * width + height * height);
                angle = (float) Math.atan2(height, width);
                // x : "horizontal" position in rotated state
                x = (diagonalLength - stringWidth) / 2;
                cs.transform(Matrix.getRotateInstance(angle, 0, 0));
                cs.setFont(font, fontSize);
                // cs.setRenderingMode(RenderingMode.STROKE); // for "hollow" effect
                PDExtendedGraphicsState gs = new PDExtendedGraphicsState();
                gs.setNonStrokingAlphaConstant(0.2f);
                gs.setStrokingAlphaConstant(0.2f);
                gs.setBlendMode(BlendMode.MULTIPLY);
                cs.setGraphicsStateParameters(gs);
                cs.setNonStrokingColor(rgbRed, rgbGreen, rgbBlue);
                cs.setStrokingColor(rgbRed, rgbGreen, rgbBlue);
                cs.beginText();
                cs.newLineAtOffset(x, y);
                cs.showText(watermarkText);
                cs.endText();
                cs.close();
            }
            doc.save(targetPdfFile);
        } catch (Exception e) {
            throw new WatermarkerException("Failed to watermark the document.  Error: " + e.getMessage(), e);
        }
    }

}
