package com.es.aplicacion.service

import com.es.aplicacion.model.Tarea
import com.es.aplicacion.dto.TareaRegisterDTO
import com.es.aplicacion.error.exception.BadRequestException
import com.es.aplicacion.error.exception.ForbidenException
import com.es.aplicacion.error.exception.NotFoundException
import com.es.aplicacion.model.Usuario
import com.es.aplicacion.repository.TareaRepository
import com.es.aplicacion.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class TareaService {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var tareaRepository: TareaRepository

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository

    fun verTarea(username:String): List<Tarea> {
        val auth = SecurityContextHolder.getContext().authentication
        val usuario:Usuario=usuarioRepository.findByUsername(auth.name)
            .orElseThrow{ throw NotFoundException("El usuario $username no existe") }


        if (auth.name==username||usuario.roles=="ADMIN") {
            return tareaRepository.findByUsuario(username)
        }else {
            throw ForbidenException("No tienes acceso a este recurso")
        }
    }

    fun crearTarea(tareaRegister: TareaRegisterDTO): Tarea{
        val auth = SecurityContextHolder.getContext().authentication
        val usuario:Usuario=usuarioRepository.findByUsername(auth.name)
        .orElseThrow{ throw NotFoundException("El usuario ${tareaRegister.usuario} no existe") }

        if (tareaRegister.titulo.length>30){
            throw BadRequestException("El titulo debe ser inferior a 30 caracteres")
        }
        if (tareaRegister.descripcion.length>3000){
            throw BadRequestException("Contenido de la tarea demasiado largo")
        }

        val tarea= Tarea(
            null,
            tareaRegister.titulo,
            tareaRegister.descripcion,
            false,
            Date.from(Instant.now()),
            tareaRegister.usuario
        )
        val existUser=usuarioRepository.findByUsername(tareaRegister.usuario).orElseThrow {
            throw NotFoundException("El usuario no existe")
        }
        if (auth.name==tarea.usuario||usuario.roles=="ADMIN") {
                return tareaRepository.save(tarea)
        }else{
            throw ForbidenException("No tienes acceso a este recurso")
        }
    }

    fun completarTarea(id:String): Tarea{
        val auth = SecurityContextHolder.getContext().authentication
        val tarea=tareaRepository.findBy_id(id).orElseThrow{
            throw NotFoundException("La tarea con id $id no existe")}

        val usuario:Usuario=usuarioRepository.findByUsername(auth.name).orElseThrow{
            throw NotFoundException("Esta tarea no tiene usuario asginado (Error imposible)")
    }


        if (auth.name==tarea.usuario||usuario.roles=="ADMIN") {
            if (!tarea.completada) {
                tarea.completada = true
                return tareaRepository.save(tarea)
            }else{
                throw BadRequestException("Esta tarea ya esta completada")
            }
    }else{
        throw ForbidenException("No tienes acceso a este recurso")
    }
        }

    fun deleteTarea(id:String):Tarea {
        val tarea = tareaRepository.findBy_id(id).orElseThrow{throw NotFoundException("La tarea $id no existe")}
        val auth = SecurityContextHolder.getContext().authentication
        val usuario:Usuario=usuarioRepository.findByUsername(auth.name).orElseThrow{
            throw NotFoundException("Esta tarea no tiene usuario asginado (Error imposible)")
        }
        println(auth.name+ tarea)
        if (auth.name == tarea.usuario||usuario.roles=="ADMIN") {
            tareaRepository.delete(tarea)
            return tarea
        }else{
            throw ForbidenException("No tienes acceso a este recurso")
        }
    }


    fun verTareas():List<Tarea>{
        val auth = SecurityContextHolder.getContext().authentication
        val usuario:Usuario=usuarioRepository.findByUsername(auth.name).orElseThrow{
            throw NotFoundException("Este token no tiene un usuario relacionado")
        }
        if (usuario.roles=="ADMIN") {
            return tareaRepository.findAll()
        }else{
            throw ForbidenException("No tienes acceso a este recurso")
        }
    }
    }
