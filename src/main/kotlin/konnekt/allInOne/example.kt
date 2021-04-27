@file:Suppress("unused")

package konnekt.allInOne

import konnekt.prelude.Client
import konnekt.prelude.GET

interface ClientFunWithoutClientAnnotationDiagnostic {
    @GET("/foo")
    suspend fun bar(): String
}

@Client
interface ClientFunWithoutVerbAnnotationInspection {
    suspend fun test()
    companion object
}

interface Foo

@Client
interface ClientInterfaceWithSupertypeDiagnostic : Foo {
    companion object
}

@Client
interface Test

@Client
interface SuspendFunDiagnostic {
    @GET("/foo")
    fun bar()
    companion object
}