package com.sportspunchin.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileAction {

  // 文件存储路径
  private static String UPLOADED_FOLDER = "D:\\DATA\\";

  @CrossOrigin
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String file(@RequestParam("file") MultipartFile file) {
    if (file.isEmpty()) {
      return "文件为空";
    }

    File path = new File(UPLOADED_FOLDER + file.getOriginalFilename());

    try {
      byte[] fileSize = file.getBytes();
      file.transferTo(path);
      return "上传成功";
    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "上传成功";
  }
}
