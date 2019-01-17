package com.javacore.file2;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents an employee that has a set of {@link Stationery}.
 */
public class Employee implements Inventory {
    @Getter private String name;
    private List<Stationery> stationeryList = new ArrayList<>();
    private long totalStationaryCost;

    /**
     * Instantiates a new Employee.
     *
     * @param name name of the new employee
     */
    public Employee(@NonNull String name) {
        this.name = name;
    }

    @Override
    public void addStationery(@NonNull Stationery stationery) {
        totalStationaryCost += stationery.getPrice();
        stationeryList.add(stationery);
    }

    @Override
    public void removeStationery(@NonNull Stationery stationery) {
        totalStationaryCost -= stationery.getPrice();
        stationeryList.remove(stationery);
    }

    @Override
    public void showAllStationery() {
        System.out.println(name);
        for (Stationery stationery : stationeryList) {
            System.out.println(stationery.toString());
        }
    }

    @Override
    public long getTotalCost() {
        return totalStationaryCost;
    }
}
