package com.diceRoller;

import java.util.Random;

/**
 * A class that creates dice objects
 *
 * @author subu
 * @author Amber Custer
 */


public class DiceRoller {

    private int numberRolled;
    private int numberOfSides;
    private String diceImage;


    /**
     * Constructor for the NumberRolled object
     */
    public DiceRoller(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        rollDice(numberOfSides);
        createDiceImagePath();
    }

    /**
     *  Gets the numberRolled value
     * @return The numberRolled random number
     */
    public int getNumberRolled() {

        return numberRolled;
    }

    /**
     *  Sets the numberRolled attribute of the NumberRolled object
     * @param number number rolled
     */
    public void setNumberRolled(int number) {

        numberRolled = number;
    }

    /**
     *  Gets the numberOfSides attribute of the DiceRoller object
     * @return The number of sides on the die
     */
    public int getNumberSides() {

        return numberOfSides;
    }

    /**
     *  Sets the numberOfSides attribute of the DiceRoller object
     * @param sides the number of sides on the die
     */
    public void setNumberSides(int sides) {

        numberOfSides = sides;
    }

    /**
     * gets the dice image
     * @return an image of the die rolled
     */
    public String getDiceImage() {

        return diceImage;
    }

    /**
     * sets the dice image
     * @param diceImage an image of the die rolled
     */
    public void setDiceImage(String diceImage) {
        this.diceImage = diceImage;
    }

    public void rollDice(int numberOfSides) {
        Random random = new Random();
        this.numberRolled = random.nextInt(numberOfSides) + 1;
    }

    public void createDiceImagePath() {
        this.diceImage = "images/" + this.numberOfSides + "-" + this.numberRolled + ".png";
    }

    /**
     * overrides the toString method
     * @return all of the instance variables of the dice object
     */
    public String toString() {

        return numberOfSides + ", " + numberRolled + ", " + diceImage;
    }
}

