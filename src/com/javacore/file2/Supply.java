package com.javacore.file2;

import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

/**
 * Class represents writing supplies.
 */
public class Supply extends Stationery {
    /**
     * A type of the supply item.
     */
// it should be subclasses
    public enum SupplyType {
        /**
         * Eraser supply item type.
         */
        ERASER,
        /**
         * Correction fluid supply item type.
         */
        CORRECTION_FLUID,
        /**
         * Pencil supply item type.
         */
        PENCIL}

    @Getter private SupplyType supplyType;
    @Getter private long usageTime = 0;

    /**
     * Instantiates a new default Supply.
     *
     * @param owner      an owner of the supply item
     * @param supplyType a type of the supply item
     */
    public Supply(@NonNull String owner, SupplyType supplyType) {
        this.owner = owner;
        this.supplyType = supplyType;
        this.price = 39;
    }

    /**
     * Instantiates a new Supply.
     *
     * @param supplyType a type of the supply item
     * @param owner      an owner of the supply item
     * @param price      a non negative price of the supply item
     * @throws IllegalArgumentException will be thrown if {@code price} is negative
     */
    public Supply(@NonNull SupplyType supplyType, @NonNull String owner, long price) throws IllegalArgumentException{
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non negative");
        }

        this.supplyType = supplyType;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return price == supply.price &&
                usageTime == supply.usageTime &&
                supplyType == supply.supplyType &&
                owner.equals(supply.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplyType, usageTime, owner, price);
    }

    @Override
    public String toString() {
        return "Supply: " +
                "type = " + supplyType +
                ", owner = " + owner +
                ", price = " + price +
                ", usageTime = " + usageTime;
    }
}
