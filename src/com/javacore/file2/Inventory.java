package com.javacore.file2;


/**
 * Methods for inventorying {@link Stationery} objects.
 * Provides adding, removing, showing list of stationeries and getting total cost.
 */
public interface Inventory {
    /**
     * Adds new stationery to the list.
     *
     * @param stationery non null {@link Stationery} object
     */
    void addStationery(Stationery stationery);

    /**
     * Removes stationery from the list.
     *
     * @param stationery non null {@link Stationery} object
     */
    void removeStationery(Stationery stationery);

    /**
     * Shows list of stationeries.
     */
    void showAllStationery();

    /**
     * Returns a total cost of stationeries.
     *
     * @return non negative total cost
     */
    long getTotalCost();
}
