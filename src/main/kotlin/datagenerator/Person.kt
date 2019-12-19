package main.kotlin.datagenerator

class Person(
    val age : Int,
    val sex : Sex,
    val salary : Int,
    val hasAJob : Boolean,
    val jobDurationInYears: Int,
    val ownsAHouse: Boolean,
    val hasOtherCredits: Boolean,
    val shouldGetCredit : Boolean
)

enum class Sex {
    MALE, FEMALE
}