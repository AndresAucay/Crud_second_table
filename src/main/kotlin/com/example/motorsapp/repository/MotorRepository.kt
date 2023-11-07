package com.example.motorsapp.repository

import com.example.motorsapp.model.Motor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MotorRepository : JpaRepository<Motor, Long?> {

    fun findById (id: Long?): Motor?


}