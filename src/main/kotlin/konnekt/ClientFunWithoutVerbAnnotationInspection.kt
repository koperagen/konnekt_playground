package konnekt
import konnekt.prelude.*

@Client
interface ClientFunWithoutVerbAnnotationInspection {
  suspend fun test()

  companion object
}