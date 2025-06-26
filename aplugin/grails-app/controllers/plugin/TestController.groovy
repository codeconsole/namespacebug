package plugin

class TestController {

    static namespace = 'plugin'

    def index() { 
        def model = [namespace: namespace]
        respond model, formats: ['json']
    }
}
