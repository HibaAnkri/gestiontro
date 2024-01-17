package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entity.Role;
import org.example.Entity.Trottinette;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String username;
    private  String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="userId"),
            inverseJoinColumns   =@JoinColumn(name = "roleId"))
    private List<Role> roles;
    @ManyToMany
    @JoinTable(
            name = "user_trottinette",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "trottinette_id"))
    private Set<Trottinette> trottinettes = new HashSet<>();


    public User(Long userId, String username, String password){
    }

    public void setId(Long userId) {
    }
}