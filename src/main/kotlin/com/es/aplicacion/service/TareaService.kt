package com.es.aplicacion.service

import com.es.aplicacion.model.Tarea
import com.es.aplicacion.dto.TareaRegisterDTO
import com.es.aplicacion.repository.TareaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class TareaService {

    @Autowired
    private lateinit var tareaRepository: TareaRepository

    fun verTareas(username:String): List<Tarea> {
        return tareaRepository.findByUsuario(username)
    }

    fun crearTarea(tareaRegister: TareaRegisterDTO): Tarea{
        val tarea= Tarea(
            null,
            tareaRegister.titulo,
            tareaRegister.descripcion,
            false,
            Date.from(Instant.now()),
            tareaRegister.usuario
        )
        println(tarea)
        return tareaRepository.save(tarea)
    }

    fun completarTarea(id:String): Tarea{
        val tarea=tareaRepository.findBy_id(id)
        tarea.completada=true
        return tareaRepository.save(tarea)
        }

    fun deleteTarea(id:String):Tarea{
        val tarea=tareaRepository.findBy_id(id)
        tareaRepository.delete(tarea)
        return tarea
    }
    }
