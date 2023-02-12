package net.baroi.watermarker;

import static org.junit.jupiter.api.Assertions.fail;
import java.io.File;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WatermarkerTests {

    @Test
    void manualText() {
        try {
            final String sourceFileName = "resources/pdfClown_userGuide.pdf";
            final String targetFileName = "resources/pdfClown_userGuide_watermarked.pdf";
            final String watermarkText = "My Watermark 1 2023/02/11";
            //
            final FontColor rgbColor = new FontColor(255f, 0f, 0f);
            final Font watermarkFont = new Font(FontType.HELVETICA_BOLD, 50f, rgbColor);
            final File sourcePdfFile = new File(sourceFileName);
            final File targetPdfFile = new File(targetFileName);
            Watermarker.satermarkPdfFile(watermarkText, watermarkFont, sourcePdfFile, targetPdfFile);
        } catch (Exception e) {
            fail("Wartermarking failed.", e);
        }
    }

}
