package konnekt

import konnekt.prelude.*

@Client
interface SuspendFunDiagnostic {
    @GET("/foo")
    fun bar()

    companion object
}