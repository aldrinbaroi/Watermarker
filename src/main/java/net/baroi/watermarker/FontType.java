package net.baroi.watermarker;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;

public class FontType extends PDType1Font {
    public FontType(COSDictionary fontDictionary) throws IOException {
        super(fontDictionary);
    }

    public FontType(PDDocument doc, InputStream pfbIn) throws IOException {
        super(doc, pfbIn);
    }

    public FontType(PDDocument doc, InputStream pfbIn, Encoding encoding) throws IOException {
        super(doc, pfbIn, encoding);
    }
}
