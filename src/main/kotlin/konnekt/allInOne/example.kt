@file:Suppress("unused")

package konnekt.allInOne

import konnekt.prelude.Client
import konnekt.prelude.GET

@konnekt.prelude.Client
interface ClientFunWithoutClientAnnotationDiagnostic {
    @GET("/foo")
    suspend fun bar(): String

    companion object {
    }
}

@Client
interface ClientFunWithoutVerbAnnotationInspection {
    @GET("/foo")
    suspend fun test()
    companion object
}

interface Foo

@Client
interface ClientInterfaceWithSupertypeDiagnostic {
    companion object
}

@Client
interface Test {
    companion object {
    }
}

@Client
interface SuspendFunDiagnostic {
    @GET("/foo")
    suspend fun bar()
    companion object
}