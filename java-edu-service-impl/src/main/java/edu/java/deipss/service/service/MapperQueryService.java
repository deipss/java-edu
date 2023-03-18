package edu.java.deipss.service.service;

import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.sql.dal.entity.SchedulingTaskHistory;
import edu.java.deipss.sql.dal.mapper.SchedulingTaskMapper;
import edu.java.deipss.sql.dal.service.impl.SchedulingTaskHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class MapperQueryService {

    @Autowired
    private SchedulingTaskMapper mapper;

    @Autowired
    private SchedulingTaskHistoryServiceImpl historyService;

    @Autowired
    @Qualifier("schedulingTransactionTemplate")
    private TransactionTemplate transactionTemplate;

    @Async("executeThreadPoolExecutor")
    public List<SchedulingTask> query() {
        return mapper.selectList(null);
    }

    public boolean save(SchedulingTask task) {
        return mapper.insert(task) > 0;
    }


    /**
     *
     * @param task
     * @param history
     * @return 事务执行结果
     */
    public boolean saveThrow(SchedulingTask task, SchedulingTaskHistory history) {
        return Boolean.TRUE.equals(transactionTemplate.execute(i -> {
            mapper.insert(task);
            int a = 1 / 0;
            return historyService.save(history);
        }));

    }

    /**
     *
     * @param task
     * @param history
     * @return 事务执行结果
     */
    public boolean saveTwo(SchedulingTask task, SchedulingTaskHistory history) {
        return Boolean.TRUE.equals(transactionTemplate.execute(i -> {
            mapper.insert(task);
            return historyService.save(history);
        }));

    }
}
