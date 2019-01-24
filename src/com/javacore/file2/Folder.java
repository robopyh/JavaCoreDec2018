package com.javacore.file2;

import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

/**
 * Class represents folder. Provides properties {@code
 * * capacity (50),
 * * folderType (FolderType.DISPLAY_BOOK),
 * * owner ("Java Core Class"),
 * * price (150),
 * * using}*.
 */
public class Folder extends Stationery {
    /**
     * A type of the folder.
     */
// it should be subclasses
    public enum FolderType {SHEET_PROTECTOR, SEPARATOR, RING_BINDER, DISPLAY_BOOK}

    @Getter private FolderType folderType;
    @Getter private long capacity;
    @Getter private boolean using = false;

    /**
     * Instantiates a new default Folder.
     *
     * @param owner an owner of the folder
     */
    public Folder(@NonNull String owner) {
        this.owner = owner;
        this.price = 150;
        this.folderType = FolderType.DISPLAY_BOOK;
        this.capacity = 50;
    }

    /**
     * Instantiates a new Folder.
     *
     * @param folderType a folder type
     * @param capacity   an amount of pages the folder can hold (must be positive)
     * @param owner      an owner of the folder
     * @param price      a non negative price of the folder
     * @throws IllegalArgumentException will be thrown if {@code capacity} is less than 1 or if {@code price} is negative
     */
    public Folder(@NonNull FolderType folderType, long capacity, @NonNull String owner, long price) throws IllegalArgumentException {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non negative");
        }

        this.folderType =folderType;
        this.capacity = capacity;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return price == folder.price &&
                capacity == folder.capacity &&
                using == folder.using &&
                folderType == folder.folderType &&
                owner.equals(folder.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folderType, capacity, owner, price, using);
    }

    @Override
    public String toString() {
        return "Folder: " +
                "type = " + folderType +
                ", capacity = " + capacity +
                ", owner = " + owner +
                ", price = " + price +
                ", using = " + using;
    }
}
