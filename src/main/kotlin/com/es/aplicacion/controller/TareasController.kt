package com.es.aplicacion.controller

import com.es.aplicacion.model.Tarea
import com.es.aplicacion.service.TareaService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/Tarea")
class TareasController {

    @Autowired
    private lateinit var tareaService: TareaService

    @GetMapping("/verTareas")
    fun verTareas(
        httpRequest: HttpServletRequest,
        @RequestBody username: String
    ): ResponseEntity<Optional<Tarea>> {
        println("df")

        val tareas= tareaService.verTareas(username)
    return ResponseEntity(tareas, HttpStatus.CREATED)
    }

    @PutMapping("/completarTarea")
    fun completarTarea(
        httpRequest: HttpServletRequest,
        @RequestBody _id: String
    ){

    }

    @DeleteMapping("/borrarTarea")
    fun borrarTarea(
        httpRequest: HttpServletRequest,
        @RequestBody _id: String
    ){

    }

    @PostMapping("/createTarea")
    fun creaTarea(
        httpRequest: HttpServletRequest,
        @RequestBody tarea: Tarea
    ){

    }
}