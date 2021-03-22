package konnekt

import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.content.*
import konnekt.prelude.Body
import konnekt.prelude.Client
import konnekt.prelude.GET
import konnekt.prelude.POST
import konnekt.prelude.PUT
import konnekt.prelude.Path
import konnekt.prelude.Query
import kotlinx.coroutines.runBlocking

@Client
interface Api {
    @GET("/posts")
    suspend fun allPosts(): String

    @GET("/posts/{id}")
    suspend fun post(@Path("id") id: Int): String

    @POST("/posts")
    suspend fun createPost(@Body post: OutgoingContent): String

    @PUT("/posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body post: OutgoingContent): String

    @GET("/posts/")
    suspend fun postsByUser(@Query("userId") userId: Int): String

    companion object
}

fun main() = runBlocking {
    val basepath = "https://jsonplaceholder.typicode.com/"
    val client = HttpClient(Apache) {
        Logging {
            level = LogLevel.ALL
            logger = Logger.SIMPLE
        }
        defaultRequest {
            url.takeFrom(URLBuilder().takeFrom(basepath).apply {
                encodedPath += url.encodedPath
            })
        }
    }
    val api = Api(client)
    val post = TextContent(
        """{
            "title": "foo",
            "body": "bar",
            "userId": 5
        }""".trimIndent(),
        contentType = ContentType.Application.Json
    )
    println(api.allPosts())
    println(api.post(1))
    println(api.createPost(post))
    println(api.updatePost(1, post))
    println(api.postsByUser(2))
}