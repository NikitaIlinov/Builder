import org.junit.jupiter.api.*;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonBuilderTest {

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running 'PersonBuilderTest' for methods of class \"PersonBuilder\"");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("Stop 'PersonBuilderTest' for methods of class \"PersonBuilder\"");
    }

    @Test
    @DisplayName("setName() testing...")
    public void setNameTest() {
        String nameForSet = "Ivan";
        Person testPerson = new PersonBuilder()
                .setName("Sergei")
                .setName(nameForSet)
                .setSurname("Akopov")
                .setAge(39)
                .setAddress("Rostov-on-Don")
                .build();
        String actualName = testPerson.getName();
        Assertions.assertEquals(nameForSet, actualName, " ...some is WRONG !");
        System.out.println("'setName()' working OK!");
    }

    @Test
    @DisplayName("setSurame() testing...")
    public void setSurnameTest() {
        String surnameForSet = "Ivanov";
        Person testPerson = new PersonBuilder()
                .setName("Sergei")
                .setSurname("Akopov")
                .setSurname(surnameForSet)
                .setAge(39)
                .setAddress("Rostov-on-Don")
                .build();
        String actualSurname = testPerson.getSurname();
        Assertions.assertEquals(surnameForSet, actualSurname, " ...some is WRONG !");
        System.out.println("'setSurname()' working OK!");
    }

    @Test
    @DisplayName("setAge() testing...")
    public void setAgeTest() {
        int ageForSet = 25;
        Person testPerson = new PersonBuilder()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setAge(39)
                .setAge(ageForSet)
                .setAddress("Rostov-on-Don")
                .build();
        OptionalInt actualAge = testPerson.getAge();
        Assertions.assertEquals(ageForSet, actualAge.getAsInt(), " ...some is WRONG !");
        System.out.println("'setAge()' working OK!");
    }

    @Test
    @DisplayName("build() IllegalStateException testing...")
    public void itShouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class,
                new PersonBuilder()
                        .setName("Ivan")
                        .setAge(39)
                        .setAddress("Rostov-on-Don")::build, "...some is WRONG !");
        System.out.println("'IllegalStateException' in 'build()' method working OK!");
    }

    @Test
    @DisplayName("build() + incorrect Age = IllegalStateException, testing...")
    public void itShouldAgeThrowIllegalStateException() {
        assertThrows(IllegalStateException.class,
                () -> new PersonBuilder()
                        .setName("Solomon")
                        .setAge(-139)
                        .build(), "...some is WRONG !");
        System.out.println("'IllegalStateException' with incorrect age in 'build()' method working OK!");
    }
}
