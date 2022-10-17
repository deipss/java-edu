package edu.java.deipss.web.controller;

import edu.java.deipss.spring.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.web.request.QueryRequest;
import edu.java.deipss.web.response.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mapper")
@Slf4j
public class MapperController {

    @Autowired
    private MapperQueryService mapperQueryService;

    @PostMapping("/queryAll")
    public HttpResponse<List<SchedulingTask>> queryAll(@RequestBody @Valid QueryRequest queryRequest, BindingResult result) {
        if(result.hasErrors()){
            return HttpResponse.failed(null);
        }
        log.info("{}", queryRequest);
        return HttpResponse.suucess(mapperQueryService.query());
    }

    @GetMapping("/query")
    public String query() {
        return "123";
    }
}
