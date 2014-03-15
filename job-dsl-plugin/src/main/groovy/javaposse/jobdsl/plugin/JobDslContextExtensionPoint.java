package javaposse.jobdsl.plugin;

import hudson.ExtensionList;
import hudson.ExtensionPoint;
import javaposse.jobdsl.dsl.helpers.Context;
import jenkins.model.Jenkins;

public abstract class JobDslContextExtensionPoint implements ExtensionPoint {

    private Context context;

    protected void setContext(Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }

    public static ExtensionList<JobDslContextExtensionPoint> all() {
        return Jenkins.getInstance().getExtensionList(
                JobDslContextExtensionPoint.class);
    }

    public abstract void notifyJobConfigCreated(String jobname);

    public abstract void notifyJobConfigUpdated(String jobname);

}
