package com.javacore.file2;

import lombok.Getter;
import lombok.Setter;

/**
 * Abstract class represents stationary.
 */
abstract public class Stationery {
    /**
     * A owner of stationery.
     */
    @Getter@Setter public String owner;
    /**
     * A non negative price of stationery.
     */
    @Getter@Setter public long price;

    abstract public String toString();
    abstract public boolean equals(Object o);
    abstract public int hashCode();
}
