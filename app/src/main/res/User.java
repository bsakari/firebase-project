/**
 * Created by kingwanyama on 9/29/17.
 */

public class User {


    private String names, email,age;

    public User(String names, String email, String age) {
        this.names = names;
        this.email = email;
        this.age = age;
    }
    public User(){

    }


    public String getNames() {
        return names;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
