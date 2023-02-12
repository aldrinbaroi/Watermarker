package net.baroi.watermarker;

import static org.junit.jupiter.api.Assertions.fail;
import java.io.File;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WatermarkerApplicationTests {

    @Test
    void manualText() {
        try {
            final String sourceFileName = "/Users/m_825068/ws/code/wm/watermark/pdfClown_userGuide.pdf";
            final String targetFileName = "/Users/m_825068/ws/code/wm/watermark/Tmp_1_pdfClown_userGuide.pdf";
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
