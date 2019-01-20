package com.javacore.file2;

import java.util.Random;

/**
 * Class represents submarine. Can be launched.
 */
@coinFlip(use = true)
public class Submarine {
    public enum OwnerCountry {RUSSIA, USA, CHINA, GERMANY, ISRAEL}

    private OwnerCountry ownerCountry;
    private SubmarineEngine engine;
    private boolean civilian;
    private long capacity;

    /**
     * Instantiates a new Submarine.
     *
     * @param ownerCountry an owner country
     * @param nuclear      is submarine engine nuclear
     * @param civilian     is submarine civilian (it will be military otherwise)
     * @param capacity     a submarine capacity
     */
    public Submarine(OwnerCountry ownerCountry, boolean nuclear, boolean civilian, long capacity) {
        this.ownerCountry = ownerCountry;
        this.engine = new SubmarineEngine(nuclear);
        this.civilian = civilian;
        this.capacity = capacity;
    }

    /**
     * Launch a submarine.
     *
     * @return return True on successful launch
     */
    public boolean launch() {
        if (! engine.startEngine()) {
            return false;
        }
        return engine.fullSpeedAhead();
    }

    private class SubmarineEngine {
        private boolean nuclear;

        private SubmarineEngine(boolean nuclear) {
            this.nuclear = nuclear;
        }

        private boolean startEngine() {
            coinFlip annotation = Submarine.this.getClass().getAnnotation(coinFlip.class);
            if (annotation.use()) {
                System.out.println("Using coin flip...");
                return new Random().nextInt(2) != 0;
            }
            return true;
        }

        private boolean fullSpeedAhead() {
            return true;
        }
    }


    public static void main(String[] args) {
        Submarine submarine = new Submarine(OwnerCountry.RUSSIA, true, false, 100);
        if (submarine.launch()) {
            System.out.println("Successful launch");
        }
        else {
            System.out.println("Launch failed");
        }
    }
}
