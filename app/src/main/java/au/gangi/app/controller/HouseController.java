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

import au.gangi.app.entity.House;
import au.gangi.app.service.HouseService;

@RestController
@RequestMapping("/api/houses")
public class HouseController {
    @Autowired
    private HouseService houseService;
    
    @GetMapping
    public List<House> getAllHouses() {
        return houseService.findAll();
    }
    
    @PostMapping
    public ResponseEntity<House> addHouse(@RequestBody House house) {
        House savedHouse = houseService.saveHouse(house);
        return ResponseEntity.ok(savedHouse);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Integer id) {
        houseService.deleteHouse(id);
        return ResponseEntity.noContent().build();
    }
}
