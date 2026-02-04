package miage.ihm

import kotlin.math.sqrt
import kotlin.random.Random

fun main() {

    exo1()
}

fun exo1() {
    val rndList = List(size = 1000) {Random.nextInt(from=20, until = 41)}
    val avg = rndList.sum()/ rndList.size.toDouble()
    println("avg: $avg")

    val variance = rndList.asSequence().sumOf {it*it} / rndList.size.toDouble() - avg*avg
    println("variance: $variance")
    val ecarttype = sqrt(variance)
    println("ecarttype: $ecarttype")


}
