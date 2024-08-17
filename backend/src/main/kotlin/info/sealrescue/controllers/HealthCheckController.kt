package info.sealrescue.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/api/health")
class HealthCheckController {

    @GetMapping
    fun healthCheck(): ResponseEntity<Map<String, Any>> {
        val dbStatus = checkDatabaseConnection()
        val healthStatus = mutableMapOf(
            "status" to "OK",
            "database" to if (dbStatus) "Connected" else "Disconnected",
            "timestamp" to Instant.now().toString(),
            "service" to "Seal Rescue API"
        )

        return ResponseEntity.ok(healthStatus)
    }

    fun checkDatabaseConnection(): Boolean {
        // Add logic to check database connection later, return true if healthy, false otherwise
        return true // Placeholder for actual database connection check
    }

}