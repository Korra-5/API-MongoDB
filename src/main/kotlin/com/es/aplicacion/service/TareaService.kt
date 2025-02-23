package com.es.aplicacion.service

import com.es.aplicacion.model.Tarea
import com.es.aplicacion.repository.TareaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TareaService {

    @Autowired
    private lateinit var tareaRepository: TareaRepository

    fun verTareas(username:String): Optional<Tarea> {
        println("d")
        return tareaRepository.findByUsuario(username)
    }
}