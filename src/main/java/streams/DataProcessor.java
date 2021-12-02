package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataProcessor {


    private static Function<Grade, GradeType> getType;

    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().anyMatch(grade -> {
            return grade.getType() == GradeType.A;
        });
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream().map(i -> i.getAge()).collect(Collectors.toList());
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream().filter(s -> {
            return s.getAge() >= minAge;
        }).collect(Collectors.toList());
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        return students.stream().filter(s -> {
            return s.getGender() == Gender.MALE;
        }).count();
    }

    public static double avgAgeOfFemaleStudent(List<Student> students) {
        return students.stream().filter(s -> {
            return s.getGender() == Gender.FEMALE;
        }).mapToDouble(s -> {
            return s.getAge();
        }).average().getAsDouble();
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().mapToInt(s -> {
            return s.getAge();
        }).reduce(1, (acc, i) -> {
            return acc * i;
        });
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        return student.getGrades()
                .stream()
                .mapToInt(i -> {
                    return i.getType().getValue();
                })
                .reduce(1, (acc, i) -> {
                    if (i == 0) return acc;
                    return i * acc;
                });
    }

    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return Optional.of(student.getGrades()
                .stream()
                .filter(i -> {
                    return i.getSubject() == Subject.MATH;
                })
                .reduce(new Grade(Subject.MATH,GradeType.F),(grade, i) -> {
                    if (grade.getType().getValue() > i.getType().getValue()) return grade;
                    return i;
                }));
    }

    public static List<Integer> getSortedAges(List<Student> students) {

        return students.stream().map(s -> s.getAge()).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }


// endregion
}
