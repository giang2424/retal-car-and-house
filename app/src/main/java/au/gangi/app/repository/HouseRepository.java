
package au.gangi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.gangi.app.entity.House;


public interface HouseRepository extends JpaRepository<House, Integer>{

    
}