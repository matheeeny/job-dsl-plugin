package javaposse.jobdsl.dsl.helpers

import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.JobType
import javaposse.jobdsl.dsl.WithXmlAction

class BuildParametersContextHelper extends AbstractContextHelper<BuildParametersContext> {
    
    JobManagement jobManagement

    BuildParametersContextHelper(List<WithXmlAction> withXmlActions, JobType jobType, JobManagement jobManagement) {
        super(withXmlActions, jobType)
        this.jobManagement = jobManagement
    }

    def parameters(Closure closure) {
        execute(closure, new BuildParametersContext(jobManagement))
    }

    Closure generateWithXmlClosure(BuildParametersContext context) {
        return { Node project ->
            def parameterDefinitions = project / 'properties' / 'hudson.model.ParametersDefinitionProperty' / parameterDefinitions
            context.buildParameterNodes.values().each {
                parameterDefinitions << it
            }
        }
    }
}


