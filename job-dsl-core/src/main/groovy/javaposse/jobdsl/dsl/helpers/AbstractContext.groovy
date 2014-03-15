package javaposse.jobdsl.dsl.helpers

import javaposse.jobdsl.dsl.JobManagement;

abstract class AbstractContext implements Context {
    
    JobManagement jobManagement
    
    AbstractContext(JobManagement jobManagement) {
        this.jobManagement = jobManagement
    }
    
    def methodMissing(String name, args) {
        Node node = jobManagement.callExtension(this.getClass(), name, args)
        if (!node) {
            throw new MissingMethodException(name, this.getClass(), args)
        }
        addExtensionNode(node)
    }
    
    abstract void addExtensionNode(Node node)

}
