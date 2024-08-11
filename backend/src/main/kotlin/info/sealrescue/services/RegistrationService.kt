package info.sealrescue.services

import org.springframework.stereotype.Service

@Service
class RegistrationService {

    fun retrieveRegistrationPage(): String{
        return "Hello Registration Page"
    }
}