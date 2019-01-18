package com.javacore.file2;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents paper products.
 */
public class Paper extends Stationery {
    /**
     * A type of the paper product.
     */
// it should be subclasses
    public enum PaperType {
        /**
         * Notebook paper product type.
         */
        NOTEBOOK,
        /**
         * Notepad paper product type.
         */
        NOTEPAD,
        /**
         * Sticky pads paper product type.
         */
        STICKY_PADS}

    @Getter private PaperType paperType;
    @Getter@Setter private long pagesCount;

    /**
     * Instantiates a new default Paper.
     *
     * @param owner an owner of the paper product
     * @param paperType a type of the paper product
     */
    public Paper(@NonNull String owner, PaperType paperType) {
        this.owner = owner;
        this.paperType = paperType;
        this.pagesCount = 20;
        this.price = 39;
    }

    /**
     * Instantiates a new Paper.
     *
     * @param paperType  a type of the paper product
     * @param pagesCount a number of pages (must be positive)
     * @param owner      an owner of the paper product
     * @param price      a non negative price of the paper product
     */
    public Paper(@NonNull PaperType paperType, long pagesCount, @NonNull String owner, long price) {
        if (pagesCount < 1) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non negative");
        }

        this.paperType = paperType;
        this.pagesCount = pagesCount;
        this.owner = owner;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return price == paper.price &&
                pagesCount == paper.pagesCount &&
                paperType == paper.paperType &&
                owner.equals(paper.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperType, pagesCount, owner, price);
    }

    @Override
    public String toString() {
        return "Paper: " +
                "type = " + paperType +
                ", pages = " + pagesCount +
                ", owner = " + owner +
                ", price = " + price;
    }
}
