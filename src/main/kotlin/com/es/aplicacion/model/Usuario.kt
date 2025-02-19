package com.es.aplicacion.model

import org.bson.codecs.pojo.annotations.BsonId
import org.springframework.data.mongodb.core.mapping.Document

@Document("usuario")
data class Usuario(
    @BsonId
    val _id: String?,
    val username: String,
    val password: String,
    val email: String,
    val roles: String = "USER",
    val direccion: Direccion?
) {



}