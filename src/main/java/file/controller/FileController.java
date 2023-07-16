package file.controller;

import com.itextpdf.text.*;
import file.util.GeneratePDF;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private GeneratePDF generatePDF;

    @Autowired
    file.FileRepository fileRepository;


    @GetMapping("/files")
    public ResponseEntity<List<file.model.File>> getAllFiles (@RequestParam(required = true) String email){
        try {
            List <file.model.File> Files = new ArrayList<>();

            fileRepository.findAllByEmail(email).forEach(Files::add);
            return new ResponseEntity<>(Files, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/convertFiles")
    public ResponseEntity<byte[]> convertToPdf(@RequestParam(required = true) String[] requestFiles, String email) throws IOException, DocumentException {
        try {
            /**
             * Get all files for the username
             */
            List<file.model.File> allFiles = new ArrayList<>(fileRepository.findAllByEmail(email));
            /**
             * Filter the files based on the request
             */
            List<file.model.File> filteredList = allFiles.stream()
                    .filter(f -> Arrays.asList(requestFiles).contains(f.getName()))
                    .toList();

            /**
             * convert to pdf
             */
            /**
             * To do
             * Throw new error if filteredList is empty
             */
            ByteArrayInputStream bis = generatePDF.convertImageToPdf(filteredList);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                    .body((Base64.getEncoder().encode(IOUtils.toByteArray(bis))));
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
