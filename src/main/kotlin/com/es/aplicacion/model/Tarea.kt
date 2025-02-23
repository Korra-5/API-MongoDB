package com.es.aplicacion.model

import org.bson.codecs.pojo.annotations.BsonId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
@Document("Tarea")
data class Tarea (
    val _id:BsonId,
    val titulo:String,
    val descripcion:String,
    val completada:String,
    val fechaCreacion: Date,
    val usuario:String
    ){
}