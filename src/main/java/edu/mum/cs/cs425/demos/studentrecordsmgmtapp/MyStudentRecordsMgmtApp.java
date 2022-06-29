package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;
import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.System.*;


/**
 * @author bijayshrestha on 6/29/22
 * @project swe-miu-application
 */
public class MyStudentRecordsMgmtApp{

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student(110001,"Dave", LocalDate.of(1951, 11, 18)),
                new Student(110002,"Anna", LocalDate.of(1990, 12, 7)),
                new Student(110003,"Erica", LocalDate.of(1974, 1, 31)),
                new Student(110004,"Carlos", LocalDate.of(2009, 8, 22)),
                new Student(110005,"Bob", LocalDate.of(1990, 3, 5))
        );
        out.println("------------ printListOfStudents: name(ASC) ---------------");
        printListOfStudents(students);
        out.println("------------  getListOfPlatinumAlumniStudents: dateOfAdmission(DESC) ---------");
        getListOfPlatinumAlumniStudents(students);
        out.println("------------  printHelloWorld: 1, 2, 3, 35, 4, 6, 10, 8 ---------");
        List<Integer> numbers = List.of(1, 2, 3, 35, 4, 6, 10, 8);
        printHelloWorld(numbers);
        out.println("------------  findSecondBiggest: 1, 2, 3, 35, 4, 6, 10, 8 ---------");
        Integer[] num = {1, 2, 3, 35, 4, 6, 10, 8};
        out.println(findSecondBiggest(num, num.length));
    }

    static void printListOfStudents(List<Student> students){
        List<Student> sortedUsers = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        sortedUsers.forEach(out::println);
    }

    static void getListOfPlatinumAlumniStudents(List<Student> students){
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);
        students.stream().filter(student -> student.getDateOfAdmission().isBefore(thirtyYearsAgo))
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed()).forEach(out::println);
    }

    static void printHelloWorld(List<Integer> numbers) {
        int index = 0;
        for (Integer number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                out.println("HelloWorld: " + number + " index: " + index);
            } else if( number%5 == 0){
                out.println("Hello: " + number + " index: " + index);
            }else if(number%7 ==0){
                out.println("World: " + number + " index: " + index);
            }
            index = index+1;
        }
    }

    static Integer findSecondBiggest(Integer[] numbers, int total){
        int temp;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (numbers[i] > numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers[total-2];
    }

    static Integer findSecondBiggestWithSorting(Integer[] numbers, int total){
        List<Integer> numberList= Arrays.asList(numbers);
        Collections.sort(numberList);
        return numberList.get(total-2);
    }

}
