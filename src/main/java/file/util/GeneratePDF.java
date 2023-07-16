package file.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import file.controller.FileController;
import file.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.List;

@Component
public class GeneratePDF {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    public GeneratePDF(){}

    public ByteArrayInputStream convertImageToPdf(List<File> filteredList) throws DocumentException, IOException {
        if(filteredList.size() == 0){
            return null;
        }
        ByteArrayOutputStream FILE = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, FILE);
        document.open();
        for (File file : filteredList) {
            logger.info("Creating pdf for " + file.getName());
            Image img = Image.getInstance(file.getFileDate());
            img.setAlignment(Element.ALIGN_CENTER);
            img.scaleToFit(400, 400);
            document.add(img);
            document.add(new Paragraph(" "));
        }
        document.addTitle("File Management Pdf");
        document.close();
        return new ByteArrayInputStream(FILE.toByteArray());
    }
}
