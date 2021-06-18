package com.ros.documentHandler.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentHandlerService {
    public void init();
    String uploadFile(String type, MultipartFile[] multipartFiles);
}
