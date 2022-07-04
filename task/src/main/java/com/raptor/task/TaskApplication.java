package com.raptor.task;

import com.google.common.collect.Lists;
import com.raptor.task.com.raptor.invoker.TaskInvoker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        args = new String[2];
        args[0]="ad";
        args[1]="cg.raptor.access_shopify_accelerator";
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
        new SpringApplicationBuilder().sources(TaskApplication.class).web(WebApplicationType.NONE).run(args);
        System.out.println("exit......");
        System.exit(0);
    }
    @Resource
    private ConfigurableApplicationContext context;

    @Resource
    private TaskInvoker taskInvoker;
    @Override
    public void run(String... args) throws Exception {
//        if (args == null || args.length < 2) {
//            throw new RuntimeException("定时任务参数不能为空");
//        }
        System.out.println("CommandLineRunner.......");
        String taskName = args[1];
        List<String> argList = Lists.newArrayList(args);
        argList.remove(0);
        argList.remove(0);
        taskInvoker.invoke(taskName, argList);
        context.close();
    }
}
