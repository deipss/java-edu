package edu.java.deipss.web.controller;

import edu.java.deipss.spring.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.web.request.QueryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/mapper")
@Slf4j
public class MapperController {

    @Autowired
    private MapperQueryService mapperQueryService;

    @PostMapping("/queryAll")
    public List<SchedulingTask> queryAll(QueryRequest queryRequest) {
        log.info("{}", queryRequest);
        return mapperQueryService.query();
    }

    @GetMapping("/query")
    public String query() {
        return "123";
    }
}
