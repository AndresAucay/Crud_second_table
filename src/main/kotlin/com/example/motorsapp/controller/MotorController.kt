package com.example.motorsapp.controller

import com.example.motorsapp.model.Motor
import com.example.motorsapp.service.MotorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/motor-app")   //endpoint
class MotorController {
    @Autowired
    lateinit var motorService: MotorService

    @GetMapping
    fun list ():List <Motor>{
        return motorService.list()
    }
    @PostMapping
    fun save (@RequestBody motor: Motor):ResponseEntity<Motor>{
        return ResponseEntity(motorService.save(motor), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody motor: Motor):ResponseEntity<Motor>{
        return ResponseEntity(motorService.update(motor), HttpStatus.OK)
    }
    @PatchMapping
    fun updateMotor (@RequestBody motor: Motor):ResponseEntity<Motor>{
        return ResponseEntity(motorService.updateMotor(motor), HttpStatus.OK)
    }

}