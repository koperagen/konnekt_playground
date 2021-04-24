package konnekt
import konnekt.prelude.*

interface Foo

@Client
interface ClientInterfaceWithSupertypeDiagnostic : Foo {

    companion object
}