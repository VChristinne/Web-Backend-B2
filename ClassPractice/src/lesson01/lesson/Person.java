package lesson01.lesson;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Person {

    private String name = "Chris";
    private int age = 20;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}
