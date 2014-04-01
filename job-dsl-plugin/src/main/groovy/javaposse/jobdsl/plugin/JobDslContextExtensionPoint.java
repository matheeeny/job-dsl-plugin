package javaposse.jobdsl.plugin;

import hudson.ExtensionList;
import hudson.ExtensionPoint;
import javaposse.jobdsl.dsl.helpers.Context;
import jenkins.model.Jenkins;

/**
 * An ExtensionPoint for the job-dsl-plugin to extend it with new DSL methods.
 */
public abstract class JobDslContextExtensionPoint implements ExtensionPoint {

    /**
     * Internaly shared object.
     */
    private Context context;

    /**
     * Set the context to use it later inside the notification methods.
     * @param context The context object.
     */
    protected void setContext(Context context) {
        this.context = context;
    }

    /**
     * The previously stored context.
     * @return The context object.
     */
    protected Context getContext() {
        return context;
    }

    /**
     * Jenkins ExtensionPoint convention.
     * @return List of all registered ExtensionPoints.
     */
    public static ExtensionList<JobDslContextExtensionPoint> all() {
        return Jenkins.getInstance().getExtensionList(
                JobDslContextExtensionPoint.class);
    }

    /**
     * Notifies the ExtensionPoint if a new job config was created by the job-dsl-plugin.
     * @param jobname The name of the job.
     */
    public abstract void notifyJobConfigCreated(String jobname);

    /**
     * Notifies the ExtensionPoint if the job config was updated by the job-dsl-plugin.
     * @param jobname The name of the job.
     */
    public abstract void notifyJobConfigUpdated(String jobname);

}
