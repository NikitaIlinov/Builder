public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У\n" + mom + "\nесть сын,\n" + son);

        Person student = new PersonBuilder()
                .setName("Сергей")
                .setSurname("Акопов")
                .setAge(39)
                .setAddress("Ростов-на-Дону")
                .build();

        Person studentSon = student.newChildBuilder()
                .setName("Миша")
                .setAge(8)
                .build();

        System.out.println("У студента '" + student.getName() + " " + student.getSurname()
                + "' , есть сын '" + studentSon.getName() + "', которому " + studentSon.getAge().getAsInt() + " лет.");

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}