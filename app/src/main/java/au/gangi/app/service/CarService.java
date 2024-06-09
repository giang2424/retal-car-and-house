package au.gangi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.gangi.app.entity.Car;
import au.gangi.app.repository.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
    
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }
}
