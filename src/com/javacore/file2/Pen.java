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
public class Pen {
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
    @Getter@Setter private String owner;
    @Getter@Setter private long price;
    @Getter private long usageTime = 0;

    /**
     * Instantiates a new Pen.
     */
    public Pen() {
        this.color = "#0000FF";
        this.inkType = InkType.OIL;
        this.owner = "Java Core Class";
        this.price = 50;
    }

    /**
     * Instantiates a new Pen.
     * @param color String hex-like color, e.g. "#2191F9"
     * @param type  an ink type
     * @param owner owner of the pen
     * @param price price of the pen
     */
    public Pen(@NonNull String color, @NonNull InkType type, @NonNull String owner, long price) {
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
        return "Pen: " + '\n' +
                "color = " + color +
                ", type = " + inkType +
                ", owner = " + owner +
                ", price = " + price +
                ", usage time = " + usageTime;
    }
}