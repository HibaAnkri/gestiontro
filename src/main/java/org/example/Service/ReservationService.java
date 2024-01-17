package org.example.Service;

import org.example.Entity.Reservation;
import org.example.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;


    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    public Reservation findReservationById(Long idReservation){return  reservationRepository.findById(idReservation).orElse(null);}


    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    public Reservation updateReservation(Long idReservation, Reservation reservationModifiee) {
        if (reservationRepository.existsById(idReservation)) {
            reservationModifiee.setId(idReservation);
            return reservationRepository.save(reservationModifiee);
        } else {
            return null;
        }
    }
}
