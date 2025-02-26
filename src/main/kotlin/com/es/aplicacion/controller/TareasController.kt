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

    @GetMapping("/verTareas/{username}")
    fun verTareas(
        httpRequest: HttpServletRequest,
        @PathVariable  username: String
    ): ResponseEntity<List<Tarea>> {
        val tareas = tareaService.verTareas(username)
        return ResponseEntity(tareas, HttpStatus.OK)     }

    @PutMapping("/completarTarea/{id}")
    fun completarTarea(
        httpRequest: HttpServletRequest,
        @PathVariable  id: String
    ):ResponseEntity<Tarea>{
        return ResponseEntity(tareaService.completarTarea(id), HttpStatus.OK)
    }

    @DeleteMapping("/borrarTarea/{id}")
    fun borrarTarea(
        httpRequest: HttpServletRequest,
        @PathVariable _id: String
    ):ResponseEntity<Tarea>{
        return ResponseEntity(tareaService.deleteTarea(_id),HttpStatus.OK)
    }

    @PostMapping("/crearTarea")
    fun crearTarea(
        httpRequest: HttpServletRequest,
        @RequestBody tarea: TareaRegisterDTO
    ):ResponseEntity<Tarea>{
    return ResponseEntity(tareaService.crearTarea(tarea), HttpStatus.CREATED)
    }
}