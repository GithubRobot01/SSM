package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@ResponseBody
public class UploadController {

    @RequestMapping("/upload")
    public void upload(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\FileTest\\"+originalFilename));
        }
        /*String originalFilename1 = uploadFile1.getOriginalFilename();
        uploadFile1.transferTo(new File("D:\\FileTest\\"+originalFilename1));
        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("D:\\FileTest\\"+originalFilename2));*/
    }
}
