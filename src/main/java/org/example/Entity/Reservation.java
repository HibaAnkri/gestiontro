package org.example.Entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Reservation {
    @Id
    private Long idReservation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @ManyToOne()
    @JoinColumn(name = "user_name")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "idTrottinette")
    private  Trottinette trottinette;

    public void setId(Long idReservation) {
    }
}

