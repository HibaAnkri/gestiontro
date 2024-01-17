package org.example.Repository;


import org.example.Entity.Reservation;
import org.example.Entity.Trottinette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}



