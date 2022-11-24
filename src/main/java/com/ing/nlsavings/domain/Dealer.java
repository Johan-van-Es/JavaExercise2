package com.ing.nlsavings.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private String name;
    private String city;
    List<Car> cars;

    public Dealer (String name, String city, List<Car> cars) {
        this.name = name;
        this.city = city;
        this.cars = cars;
    }

    public Dealer (String name, String city) {
        this.name = name;
        this.city = city;
        this.cars = new ArrayList<Car>();
    }

    public Dealer () {
        this.name = "DefaultName";
        this.city = "DefaultCity";
        this.cars = new ArrayList<Car>();
    }
    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public String getCity() {return this.city;}

    public void setCity(String city) {this.city = city;}

    public List<Car> getCars() {return this.cars;}

    public void setCars(List<Car> cars) {this.cars = cars;}

    public void setCar (Car car) {this.cars.add(car);}

    public void removeCar (Car rcar) {
        int aantal = this.cars.size();
        if (aantal == 0) {System.out.println("Geen auto's aanwezig");}
        else {
            Car findCar = this.cars.stream()
                    .filter(car -> rcar.equals(car))
                    .findAny()
                    .orElse(null);
            if (findCar == null) {System.out.println("Auto niet aanwezig");}
            else {this.cars.remove(rcar);
                  System.out.println("Auto verwijderd");}
            }

        }

    }






