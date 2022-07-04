package com.raptor.task.com.raptor.common;

import com.google.common.collect.Maps;
import com.raptor.task.com.raptor.annotation.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

@Component
@Slf4j
public class TaskRegisterListener implements ApplicationListener<ContextRefreshedEvent> {

    private Map<String, Object> taskRegMap = Maps.newHashMap();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Map<String, Object> map = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(Schedule.class);
        System.out.println(map.keySet());
        for (String key : map.keySet()) {
            Object taskObject = map.get(key);
            Schedule schedule = AnnotationUtils.findAnnotation(taskObject.getClass(), Schedule.class);

            String taskName = schedule.taskName();
            if (StringUtils.isEmpty(schedule.taskName())) {
                taskName = taskObject.getClass().getSimpleName();
            }
            if (map.containsKey(taskName)) {
                throw new RuntimeException("Multiple task name was found with name is " + taskName);
            }
            taskRegMap.put(taskName, taskObject);
            log.info("load task.taskName:{} beanName:{}", schedule.taskName(), key);
        }
    }

    public Object getInvokerByName(String taskName) {
        return taskRegMap.get(taskName);
    }
}
