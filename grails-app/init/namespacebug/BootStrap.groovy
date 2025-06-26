package namespacebug

import grails.boot.config.GrailsApplicationPostProcessor

class BootStrap {

    GrailsApplicationPostProcessor grailsApplicationPostProcessor

    def init = {
        println "${grailsApplicationPostProcessor.classes.length} classes detected."
        grailsApplicationPostProcessor.classes.each {
            println "${it.name}"
        }
    }

    def destroy = {
    }

}
