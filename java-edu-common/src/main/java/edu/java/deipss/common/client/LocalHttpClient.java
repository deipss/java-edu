package edu.java.deipss.common.client;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@Slf4j
public class LocalHttpClient<T> {

    @Autowired
    @Qualifier(HttpClientConfiguration.CLOSEABLE_HTTP_CLIENT)
    private HttpClient httpClient;


    public HttpResult post(String url, T body, List<Header> headers) {
        HttpPost post = new HttpPost(url);
        HttpResult result = HttpResult.builder().build();
        if (null != headers && headers.size() > 0) {
            headers.forEach(post::addHeader);
        }
        post.addHeader("Content-Type", "application/json");
        try {
            HttpEntity httpEntity = new StringEntity(JSON.toJSONString(body));
            post.setEntity(httpEntity);
            HttpResponse response = httpClient.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code == HttpStatus.SC_OK) {
                result.setSuccess(true);
                result.setHttpStatus(code);
                result.setData(IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8));
                return result;
            }
        } catch (IOException e) {
            log.error("http post异常，url={}", url, e);
        }
        result.setSuccess(false);
        return result;
    }

    public HttpResult get(String url, T body, List<Header> headers) {
        HttpGet httpGet = new HttpGet(url);
        HttpResult result = HttpResult.builder().build();
        if (null != headers && headers.size() > 0) {
            headers.forEach(httpGet::addHeader);
        }
        try {
            HttpResponse response = httpClient.execute(httpGet);
            int code = response.getStatusLine().getStatusCode();
            if (code == HttpStatus.SC_OK) {
                result.setSuccess(true);
                result.setHttpStatus(code);
                result.setData(IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8));
                return result;
            }
        } catch (IOException e) {
            log.error("http get异常，url={}", url, e);
        }
        result.setSuccess(false);
        return result;
    }

}
