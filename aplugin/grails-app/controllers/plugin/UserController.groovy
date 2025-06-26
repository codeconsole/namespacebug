package plugin

class UserController {

    static namespace = 'plugin'

    def index() { 
        def model = [namespace: namespace]
        respond model, formats: ['json']
    }
}
