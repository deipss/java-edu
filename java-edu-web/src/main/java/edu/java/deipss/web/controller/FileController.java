package edu.java.deipss.web.controller;


import edu.java.deipss.web.listener.UploadDataListener;
import edu.java.deipss.web.request.FileUploadRequest;
import edu.java.deipss.web.vo.UploadData;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {




    /**
     * 文件上传
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link UploadData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>
     * 3. 直接读即可
     */
    @PostMapping("upload")
    @ResponseBody
    public String upload(FileUploadRequest request) throws IOException {

        System.out.println(request.getFile1Name());
        System.out.println(request.getFile2Name());
        String path = "/Users/deipss/logs/";
        File file1 = new File(path + request.getFile1Name());
        File file2 = new File(path + request.getFile2Name());
        file1.createNewFile();
        file2.createNewFile();
        request.getFile2().transferTo(file2);
        request.getFile1().transferTo(file1);

        return "success";
    }


    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link}
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("download/{path}")
    public void download(@PathVariable("path") String  path,HttpServletResponse response) throws IOException {
        response.setContentType("APPLICATION/OCTET-STREAM");
        File file = new File("/Users/deipss/logs/" + path);
        response.setHeader("Content-Disposition", "attachment;filename="+file.getName());
        FileUtils.copyFile(file,response.getOutputStream());
    }


}
