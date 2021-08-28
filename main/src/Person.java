import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age = -1; //возраст неизвестен
    private String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age >= 0
                ? OptionalInt.of(age)
                : OptionalInt.empty();
    }

    public String getAddress() {
        return address != null ? address : "неизвестен";
    }

    public void setAddress(String address) {
        if (address != null){
            this.address = address;
        }
    }

    public void happyBirthday() {
        if (hasAge()){
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age >= 0 ? age : "нет данных") +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
