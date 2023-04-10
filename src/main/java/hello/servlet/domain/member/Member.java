package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private Long id;
    private String name;

    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.name = username;
        this.age = age;
    }
}
