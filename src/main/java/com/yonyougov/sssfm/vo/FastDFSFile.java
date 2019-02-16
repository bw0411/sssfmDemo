package com.yonyougov.sssfm.vo;

import lombok.Data;

/**
 * @Author: zhangshc
 * @Date: 2019/1/27 14:13
 * @Version 1.0
 */
@Data
public class FastDFSFile {

    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
}
