package au.gangi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  au.gangi.app.entity.House;
import  au.gangi.app.repository.HouseRepository;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;
    
    public List<House> findAll() {
        return houseRepository.findAll();
    }
    
    public House saveHouse(House house) {
        return houseRepository.save(house);
    }
    
    public void deleteHouse(Integer id) {
        houseRepository.deleteById(id);
    }
}
