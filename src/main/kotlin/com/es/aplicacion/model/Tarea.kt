package com.es.aplicacion.model

import org.bson.codecs.pojo.annotations.BsonId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
@Document("tareas")
data class Tarea(
    @BsonId
    val _id: String?,
    val titulo:String,
    val descripcion:String,
    var completada:Boolean,
    val fechaCreacion: Date,
    val usuario:String
    ){
}