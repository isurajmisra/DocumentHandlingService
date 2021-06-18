package com.ros.documentHandler.controller;

import com.ros.documentHandler.service.DocumentHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/document")
@CrossOrigin("*")
@Slf4j
public class DocumentHandlingController {

    private static final Logger log = LogManager.getLogger(DocumentHandlingController.class);

    @Autowired
    DocumentHandlerService documentHandlerService;


    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String upload(@RequestPart("file") MultipartFile[] multipartFiles) {
        log.info("Start file upload...");
        if (multipartFiles == null || multipartFiles.length == 0) {
            return "Upload failed, please select file";
        }

        return documentHandlerService.uploadFile("PICTURE", multipartFiles);
    }
}
