package org.example.Controller;

import org.example.Entity.Reservation;
import org.example.Service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/AddRes")
    public ResponseEntity<Reservation> creatres(@RequestBody Reservation reservation) {
        Reservation creatres = reservationService.createReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(creatres);
    }

    @GetMapping("GetReservation")
    public ResponseEntity<List<Reservation>> getAllReservation() {
        List<Reservation> reservations = reservationService.getAllReservation();
        return ResponseEntity.ok(reservations);
    }

    @DeleteMapping("/{idReservation}")
    public ResponseEntity<Reservation> deleteres(@PathVariable Long idReservation) {
        reservationService.deleteReservation(idReservation);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idReservation}")
    public ResponseEntity<Reservation> updateres(
            @PathVariable Long idReservation,
            @RequestBody Reservation reservationModifiee) {

        Reservation updatedres = reservationService.updateReservation(idReservation, reservationModifiee);

        if (updatedres != null) {
            return ResponseEntity.ok(updatedres);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{idReservation}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long idReservation) {
        Reservation reservation = reservationService.findReservationById(idReservation);

        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
