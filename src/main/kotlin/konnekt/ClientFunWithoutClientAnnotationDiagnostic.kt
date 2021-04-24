package konnekt;

import konnekt.prelude.*

interface ClientFunWithoutClientAnnotationDiagnostic {

  @GET("/foo")
  suspend fun bar(): String
}