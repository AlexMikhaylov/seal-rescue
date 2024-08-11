package info.sealrescue.controllers

import info.sealrescue.services.LoginService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(val loginService: LoginService) {

    companion object: KLogging()

    @GetMapping
    fun retrieveLoginPage(): String{
        logger.info("Received request to retrieve login page")
        return loginService.retrieveLoginPage()
    }
}