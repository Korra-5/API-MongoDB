package com.es.aplicacion.error.exception

class ForbidenException (message: String): Exception("Forbidden (403). $message") {
}