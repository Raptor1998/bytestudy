package com.raptor.task.com.raptor.invoker;

import com.google.common.base.Stopwatch;
import com.raptor.task.com.raptor.core.Task;
import com.raptor.task.com.raptor.common.TaskRegisterListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class TaskInvoker {

    @Resource
    private TaskRegisterListener taskRegisterListener;

    public void invoke(String taskName, List<String> args) {
        log.info("invoke task:{} param:{} begin", taskName, args);
        Stopwatch stopwatch = Stopwatch.createStarted();
        Object object = taskRegisterListener.getInvokerByName(taskName);
        if (object == null) {
            throw new RuntimeException("task is missing with name is: " + taskName);
        }
        ((Task) object).execTask(args);
        log.info("invoke task:{} param:{} success", taskName, args, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
