package au.gangi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.gangi.app.entity.Rental;
import au.gangi.app.repository.RentalRepository;



@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }
    
    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }
    
    public void deleteRental(Integer id) {
        rentalRepository.deleteById(id);
    }
}
