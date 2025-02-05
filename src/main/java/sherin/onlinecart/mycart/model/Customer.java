package sherin.onlinecart.mycart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Version;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false) // Limit name to 100 characters
    private String name;
    @Column(length = 50, unique = true, nullable = false) // Limit username to 50 characters, ensure uniqueness
    private String userName;
    @JsonIgnore // Prevent exposing password in API responses
    @Column(length = 255, nullable = false) // Store hashed passwords, typically long
    private String password;
    @Column(length = 20, nullable = false) // Limit user type to 20 characters (e.g., "admin", "user")
    private String userType;

    public Customer() {
    }

    public Customer(Long id, String name, String userName, String password, String userType) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
