package com.example.motorsapp.service

import com.example.motorsapp.model.Motor
import com.example.motorsapp.repository.MotorRepository
import com.example.motorsapp.repository.PlaneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class MotorService {
    @Autowired
    lateinit var motorRepository: MotorRepository
    @Autowired
    lateinit var planeRepository: PlaneRepository

    fun save(motor: Motor):Motor{
        try {
            planeRepository.findById(motor.clientId)
                ?: throw Exception("Id del cliente no encontrada")
            return motorRepository.save(motor)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }



    fun list ():List<Motor>{
        return motorRepository.findAll()
    }

    fun update(motor: Motor): Motor{
        try {
            motorRepository.findById(motor.id)
                ?: throw Exception("ID no existe")

            return motorRepository.save(motor)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateMotor(motor: Motor): Motor{
        try{
            val response = motorRepository.findById(motor.id)
                ?: throw Exception("ID no existe")
            response.apply {
                brand=motor.brand
            }
            return motorRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}