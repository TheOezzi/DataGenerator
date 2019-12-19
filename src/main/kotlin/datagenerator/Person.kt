package main.kotlin.datagenerator

import java.util.ArrayList

class Person(
    val age : Int,
    val sex : Sex,
    val salary : Int,
    val hasAJob : Boolean,
    val jobDurationInYears: Int,
    val ownsAHouse: Boolean,
    val hasOtherCredits: Boolean,
    val shouldGetCredit : Boolean
) {
    fun asStringList() : List<String>{
        val list = ArrayList<String>()

        list.add(age.toString())
        list.add(sex.toString())
        list.add(salary.toString())
        list.add(hasAJob.toString())
        list.add(jobDurationInYears.toString())
        list.add(ownsAHouse.toString())
        list.add(hasOtherCredits.toString())
        list.add(shouldGetCredit.toString())
        return list
    }

    companion object {
        fun csvHeader() : List<String> {
            return listOf("Age", "Sex", "SalaryPerYear", "HasAJob", "JobDurationInYears", "OwnsAHouse", "HasOtherCredits", "ShouldGetCredit")
        }
    }
}

enum class Sex {
    MALE, FEMALE
}