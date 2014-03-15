package javaposse.jobdsl.dsl.helpers.step

import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.JobType

class StepContext extends AbstractStepContext {

    JobType type

    StepContext(JobType jobType, JobManagement jobManagement) {
        super(jobManagement)
        this.type = jobType
    }

    StepContext(List<Node> stepNodes, JobType jobType, JobManagement jobManagement) {
        super(jobManagement, stepNodes)
        this.type = jobType
    }

}
