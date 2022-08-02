package edu.java.deipss.web.controller;

import edu.java.deipss.spring.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/mapper")
public class MapperController {

    @Autowired
    private MapperQueryService mapperQueryService;

    @PostMapping("/query")
    public List<SchedulingTask> query(){
        return mapperQueryService.query();
    }
}
