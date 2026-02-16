package miage.ihm

import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {

    exo1()
}

fun exo1() {
    val rndList = List(size = 1000) { Random.nextInt(from = 20, until = 41) }
    val avg = rndList.sum() / rndList.size.toDouble()
    println("avg: $avg")

    val variance = rndList.asSequence().sumOf { it * it } / rndList.size.toDouble() - avg * avg
    println("variance: $variance")
    val ecarttype = sqrt(variance)
    println("ecarttype: $ecarttype")

    val hist = mutableMapOf<Int, Int>()
    rndList.forEach { value ->
        hist[value] = hist.getOrDefault(value, 0) + 1
    }
    val mode = hist.maxByOrNull { it.value }
    println("mode: ${mode?.key}")
    println("frequence: ${mode?.value}")

    val m3 = rndList.sumOf { (it - avg).pow(3) } / rndList.size
    println("moment centré d'ordre 3: $m3")
    val m4 = rndList.sumOf { (it - avg).pow(4) } / rndList.size
    println("moment centré d'ordre 4: $m4")
    val asymetrie = m3 / ecarttype.pow(3)
    println("coefficient d'asymétrie: $asymetrie ")
    val aplatissement = m4 / ecarttype.pow(4)
    println("coefficient d'aplatissement: $aplatissement")

    val zList = rndList.map { (it - avg) / ecarttype }
    val moyenne = zList.sum() / zList.size.toDouble()
    println("z list: $zList")
    println("moyenne zListe: $moyenne")
    val variance2 = zList.asSequence().sumOf { it * it } / zList.size.toDouble() - moyenne * moyenne
    val eccartype2 = sqrt(variance2)
    println("ecart type zList: ${eccartype2}")


    val timeBoucle = measureTimeMillis {
        var sum = 0.0
        for (x in zList) {
            sum += x
        }
        val a = sum/rndList.size
    }
    println("timeBoucle: $timeBoucle")


}
