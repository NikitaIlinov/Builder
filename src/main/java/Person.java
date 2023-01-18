import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    // get age as OptionalInt.of(age)
    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    // person has age ? true or false
    public boolean hasAge() {
        return this.age >= 0;
    }

    // if person has age => set age = age + 1;
    public void happyBirthday() {
        if (this.hasAge()) {
            age++;
        }
    }

    public String getAddress() {
        return address;
    }

    // person has address? tru or false
    public boolean hasAddress() {
        return this.address != null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // build child from default parents values
    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.surname); // add surname from parent
        personBuilder.setAddress(this.address); // add address from parent
        return personBuilder;
    }

    @Override
    public String toString() {
        return "Person { " +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", age = " + age +
                ", city = '" + address + '\'' +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName())
                && Objects.equals(getSurname(), person.getSurname())
                && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }
}