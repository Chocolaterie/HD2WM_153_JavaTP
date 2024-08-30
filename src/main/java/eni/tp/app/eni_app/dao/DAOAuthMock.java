package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Member;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DAOAuthMock implements IDAOAuth {

    // Deux faux users
    List<Member> members = Arrays.asList(
            new Member("stephanegobin@gmail.com", "123"),
            new Member("thierry@gmail.com", "misericorde")
    );

    @Override
    public Member login(String email, String password) {
        Member foundMember = members.stream().filter(
                member -> member.email.equals(email) && member.password.equals(password))
                .findFirst().orElse(null);

        return foundMember;
    }
}
