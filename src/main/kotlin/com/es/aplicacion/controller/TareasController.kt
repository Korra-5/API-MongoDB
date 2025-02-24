package com.es.aplicacion.controller

import com.es.aplicacion.model.Tarea
import com.es.aplicacion.dto.TareaRegisterDTO
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
        @RequestParam  username: String
    ): ResponseEntity<List<Tarea>> {
        val tareas = tareaService.verTareas(username)
        return ResponseEntity(tareas, HttpStatus.OK)     }

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
        @RequestBody tarea: TareaRegisterDTO
    ):ResponseEntity<Tarea>{
    return ResponseEntity(tareaService.crearTarea(tarea), HttpStatus.CREATED)
    }
}