import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: ZafarT
 * Date: 22/08/16
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
public class TestJava8 {
    //A lambda is function
    //A function is a set of statements and could take parameters and return a value
    //Until Java8, there were only

    public static void main(String... args) {
        List<Person> staff = new ArrayList<>();

        Person person1 = new Person();
        person1.setIncome(120000000);
        person1.setName("Alex");
        person1.setGender("male");

        Person person2 = new Person();
        person2.setIncome(1000);
        person2.setName("Bob");
        person2.setGender("male");

        staff.add(person1);
        staff.add(person2);

        //use of lambda expressions, un comment and run the ocde to see output.
        /* System.out.println("Printing the List before removeAll function");
        printList(staff);

        Collections.removeAll(staff, p - > p.getIncome() < 20000);

        System.out.println("Printing the List after removeAll function");
        printList(staff); */

        /*Optional<Person> highestIncome = staff.stream()
                .filter(p - > p.getName().equals("Bob")).findAny();*/


        /* Stream Interface functions */

        //.distinct()
        /*Object[] distinct = staff.stream()
                .filter(p->p.getName().equals("Bob")).distinct().toArray();*/

    }

    private static String getMaleStaffWithHighestSalary(List<Person> staff) {
        Person requiredPerson = null;
        int highestSalary = 0;
        for (Person person : staff) {
            if (person.getGender() == "male") {
                int salary = person.getIncome();
                if (highestSalary < salary) {
                    highestSalary = salary;
                    requiredPerson = person;
                }
            }
        }
        return requiredPerson.getName();
    }

    private static void printList(List<Person> list) {
        for (Person p : list) {
            System.out.print(p.getName() + " earns " + p.getIncome());
            System.out.println("");
        }
    }


}

interface Predicate<T> {
    boolean test(T t);
}

class Collections {
    public static <T> void removeAll(Collection<T> col, Predicate<T> pred) {
        Iterator<T> it = col.iterator();
        while (it.hasNext()) {
            T t = it.next();
            if (pred.test(t)) {
                it.remove();
            }
        }
    }
}
