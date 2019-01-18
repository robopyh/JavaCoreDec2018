package com.javacore.file2;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class represents an employee that has a set of {@link Stationery}.
 */
public class Employee implements Inventory {
    @Getter private String name;
    private List<Stationery> stationeryList = new ArrayList<>();
    private long totalStationaryCost;

    /**
     * Instantiates a new Employee. Every new employee gets a newcomer stationery suit.
     *
     * @param name name of the new employee
     */
    public Employee(@NonNull String name) {
        this.name = name;

        addStationery(new Pen(name));
        addStationery(new Folder(name));
        addStationery(new Paper(name, Paper.PaperType.NOTEBOOK));
        addStationery(new Supply(name, Supply.SupplyType.CORRECTION_FLUID));
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

    public static void main(String[] args) {
        Employee employee = new Employee("MAXIM");

        Comparator<Stationery> ownerComparator = Comparator.comparing(s -> s.owner);
        Comparator<Stationery> priceComparator = Comparator.comparingLong(s -> s.price);
        Comparator<Stationery> ownerPriceComparator = ownerComparator.thenComparing(priceComparator);


        employee.addStationery(new Paper("OLEG", Paper.PaperType.STICKY_PADS));
        employee.addStationery(new Folder("GRIGORY"));
        employee.addStationery(new Pen("BORIS"));

        employee.stationeryList.sort(ownerComparator);
        employee.showAllStationery();

        employee.stationeryList.sort(priceComparator);
        employee.showAllStationery();

        employee.stationeryList.sort(ownerPriceComparator);
        employee.showAllStationery();
    }
}
