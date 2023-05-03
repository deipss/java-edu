package edu.java.deipss.web.db;

import edu.java.deipss.sql.config.SchedulingMysqlDataSourceConfig;
import edu.java.deipss.sql.dal.entity.SchedulingTaskHistory;
import edu.java.deipss.sql.dal.mapper.SchedulingTaskHistoryMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = SchedulingMysqlDataSourceConfig.class)
@RunWith(SpringRunner.class)
public class MapperTest {
    @Autowired
    private SchedulingTaskHistoryMapper mapper;

    @Test
    public void test() {
        List<SchedulingTaskHistory> schedulingTaskHistories;
        ArrayList<Long> integers = Lists.newArrayList(1652346921202569218L, 2L, 3L);
        Date date = DateUtils.addDays(new Date(), -190);
        schedulingTaskHistories = mapper.query(integers,null, "192", new Date(), date);
        for (SchedulingTaskHistory schedulingTaskHistory : schedulingTaskHistories) {
            System.out.println(schedulingTaskHistory
            );
        }
    }
}