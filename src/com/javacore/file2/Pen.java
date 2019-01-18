package com.javacore.file2;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents pen. Provides properties {@code
 * color ("#0000FF"),
 * inkType (InkType.OIL),
 * owner ("Java Core Class"),
 * price (50),
 * usageTime}.
 */
public class Pen extends Stationery {
    /**
     * A type of the pen ink.
     */
    public enum InkType {
        /**
         * Oil-based ink type.
         */
        OIL,
        /**
         * Water-based ink type.
         */
        WATER,
        /**
         * Gel ink type.
         */
        GEL,
        /**
         * Alcohol-based ink type.
         */
        ALCOHOL}

    @Getter private String color;
    @Getter private InkType inkType;
    @Getter private long usageTime = 0;

    /**
     * Instantiates a new default Pen.
     *
     * @param owner an owner of the pen
     */
    public Pen(@NonNull String owner) {
        this.owner = owner;
        this.color = "#0000FF";
        this.inkType = InkType.OIL;
        this.price = 50;
    }

    /**
     * Instantiates a new Pen.
     * @param color String hex-like color, e.g. "#2191F9"
     * @param type  an ink type
     * @param owner an owner of the pen
     * @param price a non negative price of the pen
     */
    public Pen(@NonNull String color, @NonNull InkType type, @NonNull String owner, long price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non negative");
        }
        this.color = color;
        this.inkType = type;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return price == pen.price &&
                usageTime == pen.usageTime &&
                color.equals(pen.color) &&
                inkType == pen.inkType &&
                owner.equals(pen.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, inkType, owner, price, usageTime);
    }

    @Override
    public String toString() {
        return "Pen: " +
                "color = " + color +
                ", type = " + inkType +
                ", owner = " + owner +
                ", price = " + price +
                ", usage time = " + usageTime;
    }
}