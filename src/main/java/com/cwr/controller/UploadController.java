package com.cwr.controller;

import com.cwr.pojo.Result;
import com.cwr.service.OssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    private final OssService ossService;

    public UploadController(OssService ossService) {
        this.ossService = ossService;
    }

    @PostMapping("/upload")
    //public Result upload(@RequestParam("image") MultipartFile file)
    public Result<String> upload(@RequestParam("image") MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString().replace("-", "") + originalFilename.substring(originalFilename.lastIndexOf("."));
        log.info("文件上传: {} ", newFileName);
        PutObjectResponse putObjectResponse = ossService.putObject(image,newFileName);
        return Result.success("https://tlias.oss.whoa.world/" + newFileName);
    }

    @GetMapping("/list")
    public Result<Object> list() {
        ossService.listObjects();
        return Result.success();
    }
}
