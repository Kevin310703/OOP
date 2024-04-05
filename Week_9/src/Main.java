import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Nguyen A", 22, "Address1");
        Person person2 = new Person("Nguyen A", 20, "Address2");
        Person person3 = new Person("Le B", 20, "Address3");

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        Week11.sortGeneric(people);

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
