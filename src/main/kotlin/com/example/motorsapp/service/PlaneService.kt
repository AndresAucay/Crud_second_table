package com.example.motorsapp.service

import com.example.motorsapp.model.Plane
import com.example.motorsapp.repository.PlaneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlaneService {
    @Autowired
    lateinit var planeRepository: PlaneRepository

    fun list ():List<Plane>{
        return planeRepository.findAll()
    }
    fun save(plane: Plane): Plane{
        try{
            return planeRepository.save(plane)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(plane: Plane): Plane{
        try {
            planeRepository.findById(plane.id)
                ?: throw Exception("ID no existe")

            return planeRepository.save(plane)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updatePlane(plane: Plane): Plane{
        try{
            val response = planeRepository.findById(plane.id)
                ?: throw Exception("ID no existe")
            response.apply {
                modelo=plane.modelo
            }
            return planeRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Plane?{
        return planeRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = planeRepository.findById(id)
                ?: throw Exception("ID no existe")
            planeRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}