package edu.yacoubi.employeemanagementsystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RunSampleDataInitializer
        implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SampleDataInitializer sampleDataInitializer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        sampleDataInitializer.generateEmployeeData();
    }
}
