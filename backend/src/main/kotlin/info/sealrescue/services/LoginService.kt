package info.sealrescue.services

import org.springframework.stereotype.Service

@Service
class LoginService {

    fun retrieveLoginPage(): String{
        return "Hello Login Page"
    }
}