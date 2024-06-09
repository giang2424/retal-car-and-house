package au.gangi.app.entity;

import java.util.Set;

import au.gangi.app.roles.Role;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String username;
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static User build(Integer id, String username, String password, Set<Role> roles) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(roles);
        return user;
    }

    @Override
    // public String toString() {
    //     return "User{" +
    //             "id=" + id +
    //             ", username='" + username + '\'' +
    //             ", password='" + password + '\'' +
    //             ", roles=" + roles +
    //             '}';
    // }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int idx = -1;
        if (id != null) {
            sb.append(++idx > 0 ? ", " : "").append("id=").append(id);
        }
        if (username != null) {
            sb.append(++idx > 0 ? ", " : "").append("username=").append(username);
        }
        if (password != null) {
            sb.append(++idx > 0 ? ", " : "").append("password=").append(password);
        }
        if (roles != null) {
            sb.append(++idx > 0 ? ", " : "").append("roles=").append(roles);
        }
        return sb.toString();
    }
}

