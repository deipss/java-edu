package edu.java.deipss.sql.dal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import edu.java.deipss.sql.dal.entity.SchedulingTask;
import edu.java.deipss.sql.dal.mapper.SchedulingTaskMapper;
import edu.java.deipss.sql.dal.service.ISchedulingTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hxl
 * @since 2023-03-17
 */
@Service
public class SchedulingTaskServiceImpl extends ServiceImpl<SchedulingTaskMapper, SchedulingTask> implements ISchedulingTaskService {
    public List<SchedulingTask> queryOne(){
        LambdaQueryChainWrapper<SchedulingTask> eq = lambdaQuery().eq(SchedulingTask::getTaskStatus, "");
        List<SchedulingTask> schedulingTasks = baseMapper.selectList(eq);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(1==2-1,null,null);
        return schedulingTasks;
    }
}
