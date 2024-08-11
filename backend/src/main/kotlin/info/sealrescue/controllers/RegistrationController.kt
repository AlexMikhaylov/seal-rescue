package info.sealrescue.controllers

import info.sealrescue.services.RegistrationService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/register")
class RegistrationController(val registrationService: RegistrationService) {

    companion object: KLogging()

    @GetMapping
    fun retrieveRegistrationPage(): String{
        logger.info("Received request to retrieve registration page")
        return registrationService.retrieveRegistrationPage()
    }
}