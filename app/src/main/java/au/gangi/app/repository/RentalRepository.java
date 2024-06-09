
package au.gangi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.gangi.app.entity.Rental;


public interface RentalRepository extends JpaRepository<Rental, Integer>{

    
}