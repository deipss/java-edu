package edu.java.deipss.spring.client.file;

import com.alibaba.fastjson.JSONObject;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileClient<T> {

    /**
     * @param path  file path
     * @param clazz a specific DTO,BO
     * @return T Object
     */
    public T readJson(String path, Class<T> clazz) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            return JSONObject.parseObject(fileInputStream, StandardCharsets.UTF_8, clazz);
        } catch (IOException e) {
            return null;
        }
    }

    public boolean writeJson(String path, JSONObject object) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            JSONObject.writeJSONString(fileWriter, object);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
