package namespacebug

class UserController {

    def index() { 
        def model = [namespace: '']
        respond model, formats: ['json']
    }
}
