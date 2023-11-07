package com.example.motorsapp.controller

import com.example.motorsapp.model.Plane
import com.example.motorsapp.service.PlaneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plane-app")   //endpoint
class PlaneController {
    @Autowired
    lateinit var planeService: PlaneService
    @GetMapping
    fun list ():List <Plane>{
        return planeService.list()
    }
    @PostMapping
    fun save (@RequestBody plane: Plane):ResponseEntity<Plane>{
        return ResponseEntity(planeService.save(plane), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody plane: Plane):ResponseEntity<Plane>{
        return ResponseEntity(planeService.update(plane), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody plane: Plane):ResponseEntity<Plane>{
        return ResponseEntity(planeService.updatePlane(plane), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(planeService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return planeService.delete(id)
    }
}
