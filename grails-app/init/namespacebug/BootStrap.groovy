package namespacebug

import grails.boot.config.GrailsApplicationPostProcessor
import grails.core.GrailsApplication

class BootStrap {

    GrailsApplicationPostProcessor grailsApplicationPostProcessor
    GrailsApplication grailsApplication

    def init = {
        println "${grailsApplicationPostProcessor.classes.length} classes detected."
        grailsApplicationPostProcessor.classes.each {
            println "${it.name}"
        }

        println "Namespace of logical controller is '${grailsApplication.getArtefactByLogicalPropertyName('Controller', 'user').namespace}'"
    }

    def destroy = {
    }

}
