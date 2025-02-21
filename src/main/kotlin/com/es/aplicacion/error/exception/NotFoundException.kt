package com.es.aplicacion.error.exception

class NotFoundException(message: String): Exception("Not Found Eception (404). $message"){
}