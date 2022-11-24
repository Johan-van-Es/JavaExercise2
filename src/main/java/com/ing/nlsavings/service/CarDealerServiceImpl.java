package com.ing.nlsavings.service;

import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarDealerServiceImpl implements CarDealerService {

    private final List<Dealer> dealers = new ArrayList<>();

    private final CarService carService = new CarServiceImpl();


    @Override
    public void addDealer(Dealer dealer) {
        this.dealers.add(dealer);
    }

    @Override
    public List<Dealer> getAllDealers() {
        return this.dealers;
    }

    @Override
    public void addCarToDealer(String dealerName, UUID carId) {
        Car findCar = carService.getCarById(carId);
        if (findCar == null) {System.out.println("Auto niet gevonden");}
        else {
            Dealer findDealer = this.dealers.stream()
                    .filter(dealer -> dealerName.equals(dealer.getName()))
                    .findAny()
                    .orElse (null);
            if (findDealer == null) {System.out.println("Dealer "+dealerName+" niet gevonden");}
            else findDealer.setCar(findCar);
        }
    }

    @Override
    public void deleteCarFromDealer(UUID carId, String dealerName) {
        Car findCar = carService.getCarById(carId);
        if (findCar == null) {System.out.println("Auto niet gevonden");}
        else {
            Dealer findDealer = this.dealers.stream()
                    .filter(dealer -> dealerName.equals(dealer.getName()))
                    .findAny()
                    .orElse (null);
            if (findDealer == null) {System.out.println("Dealer "+dealerName+" niet gevonden");}
            else findDealer.removeCar(findCar);
        }
    }

    @Override
    public List<Car> getAllCarsFromDealer(String dealerName) {
        Dealer findDealer = this.dealers.stream()
                .filter(dealer -> dealerName.equals(dealer.getName()))
                .findAny()
                .orElse (null);
        if (findDealer == null) {
            System.out.println("Dealer "+dealerName+" niet gevonden");
            return null;
        }
        else {return findDealer.getCars();}
    }

    // IMPORTANT! Normally it is not allowed to make the carService available like this.
    // In this fase we will do it like this. Later on we will introduce the mocking of services.
    public CarService getCarService() {
        return carService;
    }
}
