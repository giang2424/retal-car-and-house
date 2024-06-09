package au.gangi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.gangi.app.entity.Car;

// import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer>{

    
}