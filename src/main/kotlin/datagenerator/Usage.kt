package main.kotlin.datagenerator

import java.io.FileWriter
import java.util.*
import java.util.Random

fun main() {
    val (csvUtils, persons, writer) = prepareCSVFile()

    val listSize = 10000

    val generator = Random()
    val standardDeviationAge = 7
    val meanAge = 40

    val standardDeviationJob = 2
    val meanJob = 10

    val standardDeviationSalary = 5000
    val meanSalary = 25000

    var iterationCounter = 1
    var womenCounter = 1

    for (x in 1..listSize) {
        val sex : Sex = if (iterationCounter <= (listSize * 0.95).toInt()) {
            Sex.MALE
        } else {
            Sex.FEMALE
        }

        ++iterationCounter

        val age = ((generator.nextGaussian() * standardDeviationAge) + meanAge).toInt()
        val jobDuration = ((generator.nextGaussian() * standardDeviationJob) + meanJob).toInt()
        val salary = ((generator.nextGaussian() * standardDeviationSalary) + meanSalary).toInt()

        val job = generator.nextBoolean()
        val otherCredits = generator.nextBoolean()
        val house = generator.nextBoolean()
        val creditable : Boolean

       if (sex == Sex.MALE) {
            creditable = salary > meanSalary || jobDuration > meanJob || age > meanAge
        } else {
           creditable = womenCounter > ((listSize * 0.05) * 0.8).toInt()
           ++womenCounter
        }

        persons.add(
            Person(
                age = age,
                hasAJob = job,
                hasOtherCredits = otherCredits,
                jobDurationInYears = jobDuration,
                ownsAHouse = house,
                salary = salary,
                sex = sex,
                shouldGetCredit = creditable
            )
        )
    }

    generateCsvHeader(csvUtils, writer)
    writePersonsToCsv(persons, csvUtils, writer)
}

private fun generateCsvHeader(csvUtils: CSVUtils, writer: FileWriter) {
    csvUtils.writeLine(writer, Person.csvHeader())
}

private fun writePersonsToCsv(
    persons: LinkedList<Person>,
    csvUtils: CSVUtils,
    writer: FileWriter
) {
    for (person: Person in persons) {
        csvUtils.writeLine(writer, person.asStringList())
    }

    writer.flush()
    writer.close()
}

private fun prepareCSVFile(): Triple<CSVUtils, LinkedList<Person>, FileWriter> {
    val csvUtils = CSVUtils()

    val persons = LinkedList<Person>()

    val csvFile = "~/Desktop/persons.csv"
    val writer = FileWriter(csvFile)
    return Triple(csvUtils, persons, writer)
}