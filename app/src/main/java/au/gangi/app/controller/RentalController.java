package au.gangi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.gangi.app.entity.Rental;
import au.gangi.app.service.RentalService;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;
    
    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Rental> addRental(@RequestBody Rental rental) {
        Rental savedRental = rentalService.saveRental(rental);
        return ResponseEntity.ok(savedRental);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Integer id) {
        rentalService.deleteRental(id);
        return ResponseEntity.noContent().build();
    }
}
