package edu.java.deipss.web.controller;

import com.google.common.base.Strings;
import edu.java.deipss.common.util.ValidUtil;
import edu.java.deipss.service.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.web.request.QueryRequest;
import edu.java.deipss.web.response.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mapper")
@Slf4j
public class MapperController {

    @Autowired
    private MapperQueryService mapperQueryService;

    /**
     * http post 支持的Content-Type
     * 1. application/x-www-form-urlencoded
     * 2. multipart/form-data 如excel文件等
     * 3. application/json
     * 4. text/plain
     * <a href="https://www.runoob.com/http/http-content-type.html">...</a>
     *
     * @param queryRequest 请求
     * @param result       结果
     * @return task
     */
    @PostMapping("/queryAll")
    public HttpResponse<List<SchedulingTask>> queryAll(@RequestBody @Valid QueryRequest queryRequest, BindingResult result) {
        if (result.hasErrors()) {
            return HttpResponse.failed(null);
        }
        log.info("{}", queryRequest);
        return HttpResponse.suucess(mapperQueryService.query());
    }

    @GetMapping("/query")
    public String query() {
        return "123";
    }

    /**
     * ModelAttribute annotation that binds a method parameter or method return value
     * to a named model attribute, exposed to a web view. Supported
     * for controller classes with {@link RequestMapping @RequestMapping}
     * methods.
     */
    @GetMapping("/getAnnotation")
    public QueryRequest getAnnotation(@ModelAttribute QueryRequest queryRequest) {
        String check = ValidUtil.check(queryRequest);
        if (Strings.isNullOrEmpty(check)) {
            return null;
        }
        return queryRequest;
    }

    /**
     * ModelAttribute annotation that binds a method parameter or method return value
     * to a named model attribute, exposed to a web view. Supported
     * for controller classes with {@link RequestMapping @RequestMapping}
     * methods.
     */
    @GetMapping("/path/{name}/{age}")
    public QueryRequest path(@PathVariable("name") String name,@PathVariable("age") Integer age) {
        System.out.printf("name=%s,age=%d%n", name,age);
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setName("");
        queryRequest.setPhone("");
        queryRequest.setPassword("");
        queryRequest.setAge(0);
        return queryRequest;
    }





}
