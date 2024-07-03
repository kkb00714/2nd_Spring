package spring.spring_lec.test1;

public class Member {

    private Long id;
    private String name;
    private String password;
    private String nickname;

    // get'값' => '값'을 반환하는 메서드
    // set'값' => '값'을 설정하는 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
