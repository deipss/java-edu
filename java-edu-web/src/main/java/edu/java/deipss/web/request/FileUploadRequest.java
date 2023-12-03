package edu.java.deipss.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadRequest {




    private String file1Name;
    private MultipartFile file1;



    private String file2Name;
    private MultipartFile file2;
}
