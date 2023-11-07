package com.example.motorsapp.repository

import com.example.motorsapp.model.Plane
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaneRepository : JpaRepository<Plane, Long?> {

    fun findById (id: Long?): Plane?


}