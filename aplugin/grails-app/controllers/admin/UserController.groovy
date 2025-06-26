package admin

class UserController {

    static namespace = 'admin'

    def index() { 
        def model = [namespace: namespace]
        respond model, formats: ['json']
    }
}
