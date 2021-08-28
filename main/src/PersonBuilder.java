public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 200){
            throw new IllegalArgumentException("error input age in Person: 0 <= age <= 200");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null){
            throw new IllegalStateException("error input in Person: name or surname is empty");
        }

        Person person = age >= 0
                ? new Person(name, surname, age)
                : new Person(name, surname);

        if (address != null){
            person.setAddress(address);
        }

        return person;
    }
}
