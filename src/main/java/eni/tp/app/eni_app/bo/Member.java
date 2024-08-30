package eni.tp.app.eni_app.bo;

import jakarta.validation.constraints.Email;

public class Member {

    @Email
    public String email;

    public String password;

    public Member() {
        email = "";
        password = "";
    }

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
