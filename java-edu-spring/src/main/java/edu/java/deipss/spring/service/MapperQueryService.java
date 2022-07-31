package edu.java.deipss.spring.service;

import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.sql.dal.mapper.SchedulingTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapperQueryService {

    @Autowired
    private SchedulingTaskMapper mapper;

    public List<SchedulingTask> query(){
        return mapper.selectList(null);
    }
}
