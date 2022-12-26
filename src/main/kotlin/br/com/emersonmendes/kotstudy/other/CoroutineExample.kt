package br.com.emersonmendes.kotstudy.other

import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory


val logger : Logger = LoggerFactory.getLogger("CoroutinesPlayground")

suspend fun bathTime(){
    logger.info("Going to the bathroom")
    delay(5_000)
    logger.info("Bath done, exiting!")
}

suspend fun boilingWater(){
    logger.info("Boiling Water")
    delay(5_000)
    logger.info("Water Boiled")
}

suspend fun makeCoffee(){
    logger.info("Starting to make coffee")
    delay(5_000)
    logger.info("Done with coffee")
}

suspend fun sequentialMorningRoutine(){

    coroutineScope {
        bathTime()
    }

    coroutineScope {
        boilingWater()
    }

}

suspend fun concurrentMorningRoutine(){
    coroutineScope {
        launch { bathTime() }
        launch { boilingWater() }
    }
}

suspend fun morningRoutineWithCoffee(){
    coroutineScope {
        val bathTimeJob: Job = launch { bathTime() }
        val boilingWaterJob: Job = launch { boilingWater() }
        bathTimeJob.join()
        boilingWaterJob.join()
        launch { makeCoffee() }
    }
}

suspend fun makeJavaCoffee() : String {
    logger.info("Starting to make coffee")
    delay(5_000)
    logger.info("Done with coffee")
    return "Java coffee"
}

suspend fun toatingBread() : String {
    logger.info("Starting to make toast")
    delay(5_000)
    logger.info("Done with toast")
    return "Toasted Bread"
}

suspend fun prepareBreakfast(){
    coroutineScope {
        val javaCoffee : Deferred<String> = async { makeJavaCoffee() }
        val toastedBread : Deferred<String> = async {  toatingBread() }
        val finalCoffee = javaCoffee.await()
        val finalToast = toastedBread.await()
        logger.info("I am eating $finalCoffee with $finalToast")
    }
}

suspend fun main(args: Array<String>) {
//    concurrentMorningRoutine()
//    sequentialMorningRoutine()
//    morningRoutineWithCoffee()

    prepareBreakfast()
}
