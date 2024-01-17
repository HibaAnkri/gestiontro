package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trottinette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrottinette;
    private String marque;
    private String modele;
    private String vitesse;
    private  String tempscharge;
    private String description;
    private String price;
    private boolean disponibilite;

    @Column(name = "image")
    private String image;




    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "trottinettes")
    private Set<User> users = new HashSet<>();


    public void setId(Long id) {
    }
    public boolean isAvailable() {
        return disponibilite;
    }

}
