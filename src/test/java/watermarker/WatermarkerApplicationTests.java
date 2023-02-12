package watermarker;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
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
            final RGBColor rgbColor = new RGBColor(255f, 0f, 0f);
            final Font watermarkFont = new Font(PDType1Font.HELVETICA_BOLD, 50f, rgbColor);
            final File sourcePdfFile = new File(sourceFileName);
            final File targetPdfFile = new File(targetFileName);
            Watermarker.satermarkPdfFile(watermarkText, watermarkFont, sourcePdfFile, targetPdfFile);
        } catch (Exception e) {
            fail("Wartermarking failed.", e);
        }
    }

}
