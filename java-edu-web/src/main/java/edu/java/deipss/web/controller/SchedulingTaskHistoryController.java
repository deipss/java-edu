package edu.java.deipss.web.controller;

import edu.java.deipss.service.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.sql.dal.entity.SchedulingTaskHistory;
import edu.java.deipss.sql.dal.service.impl.SchedulingTaskHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hxl
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/schedulingTaskHistory")
public class SchedulingTaskHistoryController {

    @Autowired
    private SchedulingTaskHistoryServiceImpl schedulingTaskHistoryService;

    @Autowired
    private MapperQueryService mapperQueryService;


    @RequestMapping("/query")
    public List<SchedulingTaskHistory> query() {
        List<SchedulingTaskHistory> list = schedulingTaskHistoryService.list();
        mapperQueryService.query();
        String name = ThreadLocalRandom.current().nextLong(1,100)+"任务";
        mapperQueryService.save(build(name));
        return list;
    }

    @RequestMapping("/transaction")
    public Boolean transaction() {
        String name = ThreadLocalRandom.current().nextLong(1,100)+"任务";
        return mapperQueryService.saveThrow(build(name),buildHistory(name));
    }

    @RequestMapping("/transactionDone")
    public Boolean transactionDone() {
        String name = ThreadLocalRandom.current().nextLong(1,100)+"任务";
        return mapperQueryService.saveTwo(build(name),buildHistory(name));
    }


    private SchedulingTask build(String name){
        SchedulingTask schedulingTask = new SchedulingTask();
        schedulingTask.setLockName(ThreadLocalRandom.current().nextLong(1,100)+"");
        schedulingTask.setTaskStatus("");
        schedulingTask.setStartTime(LocalTime.MAX);
        schedulingTask.setEndTime(LocalTime.MAX);
        schedulingTask.setNextStart(new Date());
        schedulingTask.setTryLockCnt(0);
        schedulingTask.setTimeGap("");
        schedulingTask.setOwnerIp("");
        schedulingTask.setTmCreate(new Date());
        schedulingTask.setTmModify(new Date());
        return schedulingTask;
    }

    private SchedulingTaskHistory buildHistory(String name){
        SchedulingTaskHistory schedulingTaskHistory = new SchedulingTaskHistory();
        schedulingTaskHistory.setLockName(name);
        schedulingTaskHistory.setTaskStatus("OK");
        schedulingTaskHistory.setStartTime(LocalTime.MAX);
        schedulingTaskHistory.setEndTime(LocalTime.MIN);
        schedulingTaskHistory.setNextStart(new Date());
        schedulingTaskHistory.setTryLockCnt(1);
        schedulingTaskHistory.setTimeGap("1s");
        schedulingTaskHistory.setOwnerIp("");
        return schedulingTaskHistory;
    }

}
