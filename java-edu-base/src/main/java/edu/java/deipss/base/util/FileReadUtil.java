package edu.java.deipss.base.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Slf4j
public class FileReadUtil {


    public static String getResourceFile(String path) {
        String configString = "";
        try {
            URL url = FileReadUtil.class.getClassLoader().getResource(path);
            assert url != null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            configString = result.toString();
        } catch (IOException e) {
            log.error("读取源文件异常，", e);
        }
        return configString;
    }
}
