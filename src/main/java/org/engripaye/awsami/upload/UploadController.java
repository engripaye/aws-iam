package org.engripaye.awsami.upload;

import org.engripaye.awsami.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

    @Autowired
    private MinioService minioService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("image") MultipartFile file, Model model) {
        String url = minioService.uploadFile(file);
        model.addAttribute("url", url);
        model.addAttribute("message", "Upload successful!");
        return "upload";
    }
}
