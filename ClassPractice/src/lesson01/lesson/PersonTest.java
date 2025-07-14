package lesson01.lesson;

public class PersonTest {

    public static void main(String[] args) {
        Person p_default = new Person();
        Person p_default2 = new Person();
        Person p_new = new Person("Jack", 25);

        System.out.println(p_default);
        System.out.println(p_new);

        System.out.println(p_default.equals(p_default2));
        System.out.println(p_default.hashCode() + "\n" + p_default2.hashCode());
    }
}
