package file.util;
import com.itextpdf.text.DocumentException;
import file.model.File;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GeneratePDFTest {

    @Test
    void convertImageToPdfWithEmptyList() throws DocumentException, IOException {
        List<file.model.File> filteredList = new ArrayList<>();
        var generate = new GeneratePDF();
        assertNull(generate.convertImageToPdf(filteredList));
    }

    @Test
    void convertSingleImageToPdf() throws IOException, DocumentException {
        List<File> filteredList = TestUtil.createSingleFiles();
        var generate = new GeneratePDF();
        ByteArrayInputStream result = generate.convertImageToPdf(filteredList);
        assertThat(result).isInstanceOf(ByteArrayInputStream.class);
    }

    @Test
    void convertMultipleImagesToPdf() throws IOException, DocumentException {
        List<File> filteredList = TestUtil.createMultipleFiles();
        var generate = new GeneratePDF();
        ByteArrayInputStream result = generate.convertImageToPdf(filteredList);
        assertThat(result).isInstanceOf(ByteArrayInputStream.class);
    }

    @Test
    void convertTextToPdf() throws IOException, DocumentException {
        try{
            List<File> filteredList = TestUtil.createTextFile();
            var generate = new GeneratePDF();
            ByteArrayInputStream result = generate.convertImageToPdf(filteredList);
        }
        catch (Exception e){
            assertThatExceptionOfType(IOException.class);
        }
    }
}