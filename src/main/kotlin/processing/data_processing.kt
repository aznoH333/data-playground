package processing

import streams.*


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.any { i -> i.type == GradeType.A }
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.map { i -> i.age}
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.filter { i -> i.age >= minAge }
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.count { i -> i.gender == Gender.MALE }
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.filter { i -> i.gender == Gender.FEMALE }.map { i -> i.age }.average()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.map { i -> i.age }.reduce { acc,i -> acc*i }
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.map { i -> i.type.value }.filter { i -> i != 0 }.reduce {acc,i -> acc*i}
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    return student.grades.filter { i -> i.subject == Subject.MATH }.maxByOrNull { i -> i.type.value }
}

fun getSortedAges(students: List<Student>): List<Int> {
    return students.map { i -> i.age }.sorted()
}

// endregion
