package javaposse.jobdsl.plugin;

import hudson.Extension;
import javaposse.jobdsl.dsl.JobManagement;
import javaposse.jobdsl.dsl.helpers.wrapper.WrapperContext;

@Extension
public class TestPoint extends JobDslContextExtensionPoint {

    @DslMethod(context = WrapperContext.class)
    public Object xxx(JobManagement jobManagement, Runnable closure) {
        String xml = "<hudson.plugins.timestamper.TimestamperBuildWrapper/>";
        return xml;
    }

    @Override
    public void notifyJobConfigCreated(String jobname) {
        System.out.println(jobname);
        System.out.println(getContext());
    }

    @Override
    public void notifyJobConfigUpdated(String jobname) {
        System.out.println(jobname);
        System.out.println(getContext());
    }

}
