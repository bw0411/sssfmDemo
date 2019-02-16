package com.yonyougov.sssfm.file;

import com.yonyougov.sssfm.utils.FastDFSClientUtils;
import com.yonyougov.sssfm.vo.FastDFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: zhangshc
 * @Date: 2019/1/27 14:04
 * @Version 1.0
 */
@RestController
public class FileUploadController {

    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @PostMapping("/fileUpload") //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "";
        }
        try {
            // Get the file and save it somewhere
            String path=saveFile(file);
            return path;
        } catch (Exception e) {
            logger.error("upload file failed",e);
        }
        return "";
    }


    public String saveFile(MultipartFile multipartFile) throws IOException {
        String path="";
        String fileName=multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream=multipartFile.getInputStream();
        if(inputStream!=null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            path = FastDFSClientUtils.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            logger.error("upload file Exception!",e);
        }
        if (StringUtils.isEmpty(path)) {
            logger.error("upload file failed,please upload again!");
        }
        return path;
    }
}
