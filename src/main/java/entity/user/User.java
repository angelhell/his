package entity.user;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by celenmeh on 15.11.2018
 * 20:45
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1465458709634933958L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private USER_ROLE userRole;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLE getUserRole() {
        return userRole;
    }

    public void setUserRole(USER_ROLE user_role) {
        this.userRole = user_role;
    }
}
