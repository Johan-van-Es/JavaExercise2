package com.ing.nlsavings;

import com.ing.nlsavings.domain.Car;
import com.ing.nlsavings.domain.Dealer;
import com.ing.nlsavings.domain.Brand;
import com.ing.nlsavings.service.CarDealerServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CarDealerServiceImpl garages = new CarDealerServiceImpl();

        double carPrice = 50000;
        garages.getCarService().addCar(new Car("Model 1", Brand.TESLA, carPrice));
        garages.getCarService().addCar(new Car("Model 2", Brand.TESLA, carPrice));
        garages.getCarService().addCar(new Car("Clio",Brand.RENAULT, carPrice));
        garages.getCarService().addCar(new Car("Megane",Brand.RENAULT, carPrice));
        garages.getCarService().addCar(new Car("Captur",Brand.RENAULT, carPrice));
        garages.getCarService().addCar(new Car("Camembert",Brand.RENAULT, carPrice));
        garages.getCarService().addCar(new Car("Aigo" ,Brand.TOYOTA, carPrice));
        garages.getCarService().addCar(new Car("Corolla", Brand.TOYOTA, carPrice));
        garages.getCarService().addCar(new Car("Explorer",Brand.FORD, carPrice));
        garages.getCarService().addCar(new Car("Puma", Brand.FORD, carPrice));
        garages.getCarService().addCar(new Car("Mustang",Brand.FORD, carPrice));
        garages.getCarService().addCar(new Car("Kuga",Brand.FORD, carPrice));
        garages.getCarService().addCar(new Car("I30",Brand.HYUNDAI, carPrice));
        garages.getCarService().addCar(new Car("I40", Brand.HYUNDAI, carPrice));

        Dealer dealer1 = new Dealer("Van Mossel", "Rotterdam");
        Dealer dealer2 = new Dealer("Louwman", "Middelburg");

        garages.addDealer(dealer1);
        garages.addDealer(dealer2);

        List<Car> brandCar = garages.getCarService().getCarsByBrand("TESLA");
        for (int i = 0; i < 2; i++) {
            garages.addCarToDealer("Van Mossel", brandCar.get(i).getUuid());
        }

        brandCar = garages.getCarService().getCarsByBrand("RENAULT");
        for (int i = 0; i < 3; i++) {
            garages.addCarToDealer("Van Mossel", brandCar.get(i).getUuid());
        }

        brandCar = garages.getCarService().getCarsByBrand("TOYOTA");
        for (int i = 0; i < 2; i++) {
            garages.addCarToDealer("Louwman", brandCar.get(i).getUuid());
        }

        brandCar = garages.getCarService().getCarsByBrand("FORD");
        for (int i = 0; i < 4; i++) {
            garages.addCarToDealer("Louwman", brandCar.get(i).getUuid());
        }

        List<Car> carsFromDealer = garages.getAllCarsFromDealer("Van Mossel");
        System.out.println("Autos van Van Mossel");
        if (carsFromDealer != null) {
            for (Car car : carsFromDealer) {
                System.out.println(car.getBrand() + " " + car.getName());
            }
        }
        System.out.println();

        carsFromDealer = garages.getAllCarsFromDealer("Louwman");
        System.out.println("Autos van Louwman");
        if (carsFromDealer != null) {
            for (Car car : carsFromDealer) {
                System.out.println(car.getBrand() + " " + car.getName());
            }
        }

    }
}
