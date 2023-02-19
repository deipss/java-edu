package edu.java.deipss.web.controller;

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
     * 2. multipart/form-data
     * 3. application/json
     * 4.text/plain
     *
     * @param queryRequest 请求
     * @param result       结果
     * @return
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

    @GetMapping("/getAnnotation")
    public QueryRequest getAnnotation(@ModelAttribute QueryRequest queryRequest) {
        return queryRequest;
    }
}
