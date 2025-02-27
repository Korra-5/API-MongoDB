package com.es.aplicacion.controller

import com.es.aplicacion.model.Tarea
import com.es.aplicacion.dto.TareaRegisterDTO
import com.es.aplicacion.service.TareaService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/Tarea")
class TareasController {

    @Autowired
    private lateinit var tareaService: TareaService

    @GetMapping("/verTarea/{username}")
    fun verTarea(
        httpRequest: HttpServletRequest,
        @PathVariable  username: String
    ): ResponseEntity<List<Tarea>> {
        val tareas = tareaService.verTarea(username)
        return ResponseEntity(tareas, HttpStatus.OK)
    }

    @GetMapping("/verTareas")
    @PreAuthorize("hasRole('ADMIN')")
    fun verTareas(
        httpRequest: HttpServletRequest,
    ): ResponseEntity<List<Tarea>> {
        val tareas = tareaService.verTareas()
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
        @PathVariable id: String
    ):ResponseEntity<Tarea>{
        return ResponseEntity(tareaService.deleteTarea(id),HttpStatus.OK)
    }

    @PostMapping("/crearTarea")
    fun crearTarea(
        httpRequest: HttpServletRequest,
        @RequestBody tarea: TareaRegisterDTO
    ):ResponseEntity<Tarea>{
    return ResponseEntity(tareaService.crearTarea(tarea), HttpStatus.CREATED)
    }
}