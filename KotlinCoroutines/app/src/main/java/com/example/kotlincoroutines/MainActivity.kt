package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Light Weightness
        /*
        GlobalScope.launch {
            repeat(100000) {
                launch {
                    println("android")
                }
            }
        }
        */


        //Scope
        //Global Scope, runBlocking, CoroutineScope
        /*
        //runBlocking
        println("run blocking start")
        runBlocking {
            launch {
                delay(5000)
                println("run blocking")
            }
        }
        println("run blocking end")
        */

        /*

        //GlobalScope
        println("global scope start")
        GlobalScope.launch {
                launch {
                    delay(5000)
                    println("global scope")
                }
        }
        println("global scope end")
         */


/*
        //CorotineScope
        println("coroutine scope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("coroutine scope")
        }
        println("coroutine scope end")
*/

        //DispatcherCoroutines
        //Dispatchers.Default -> CPU Intensive
        //Dispatchers.IO -> Input/Output, Networking
        //Dispatchers.Main -> UI
        //Dispatchers.Unconfined -> Inherited dispatcher
        /*
        runBlocking {

            launch(Dispatchers.Main) {
                println("Main Thread: ${Thread.currentThread().name}")
            }

            launch(Dispatchers.IO) {
                println("IO Thread: ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default Thread: ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Unconfined) {
                println("Unconfined Thread: ${Thread.currentThread().name}")
            }

        }

         */


        /*
        runBlocking {
            delay(2000)
            println("run blocking")
            myFunction()
        }
         */

/*

        //AsyncCoroutines
        var userName = ""
        var userAge = 0
        runBlocking {
            val downloadedName = async {
                downloadName()
            }

            val downloadedAge = async {
                downloadAge()
            }

            userName = downloadedName.await()
            userAge = downloadedAge.await()

            println("${userName} ${userAge}")



        }


 */


        /*

        //Job

        runBlocking {

            val myJob = launch {
                delay(2000)
                println("job")
                val secondJob = launch {
                    println("job 2")
                }
            }

            myJob.invokeOnCompletion {
                println("my job end")
            }

            myJob.cancel()

        }

         */




        //withContextCoroutines
        runBlocking {
            launch(Dispatchers.Default) {
                println("Context: ${coroutineContext}")
                withContext(Dispatchers.IO) {
                    println("Context: ${coroutineContext}")
                }
            }
        }


    }

    suspend fun downloadName(): String {
        delay(2000)
        val userName = "Yunus: "
        println("username downloaded")
        return userName
    }

    suspend fun downloadAge(): Int {
        delay(4000)
        val userAge = 10
        println("userage downloaded")
        return userAge
    }

    suspend fun myFunction(){
        coroutineScope {
            delay(4000)
            println("suspend function")
        }
    }

}