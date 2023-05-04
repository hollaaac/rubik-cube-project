package com.display;

//import java.io.*;
import java.util.*;
//import java.lang.Math;

import javafx.scene.Parent;

public class Block {

    // Class Variables
    Cubelet[][][] Block;
    int size;
    boolean even;

    // Default Contructor that builds normal Rubik's cube
    public Block() {

        this(3); // Defaut 3v3 cube

    }

    // Constructor for given size
    public Block(int size) {

        this.size = size;
        this.Block = new Cubelet[size][size][size];

        Cubelet cubie = new Cubelet();

        int cordX = 0 - (size / 2);
        int cordY = 0 - (size / 2);
        int cordZ = 0 - (size / 2);

        if ((size % 2) == 0) {
            even = true;
        }

        else {
            even = false;
        }

        for (int x = 0; x < size; ++x) {

            cordY = 0 - (size / 2);

            for (int y = 0; y < size; ++y) {

                cordZ = 0 - (size / 2);

                for (int z = 0; z < size; ++z) {

                    Block[x][y][z] = new Cubelet(new int[] { cordX, cordY, cordZ },
                            new char[] { cubie.colorFinder('x', cordX, size / 2),
                                    cubie.colorFinder('y', cordY, size / 2), cubie.colorFinder('z', cordZ, size / 2) });

                    if (cordZ == -1 & even) {
                        ++cordZ;
                    }

                    ++cordZ;

                }

                if (cordY == -1 & even) {
                    ++cordY;
                }

                ++cordY;

            }

            if (cordX == -1 & even) {
                ++cordX;
            }

            ++cordX;

        }

    }

    // Constructor given already built cube
    public Block(Cubelet[][][] Block) {

        this.Block = Block;

    }

    // Puts all the colors and values into one string
    // Used for AStar and user input blocks
    // Follows format of PrintBlock just for each face
    public String BlocktoString() {

        String BlockString = "";

        // White Face
        BlockString = BlockString + Block[0][0][0].colors[1];
        BlockString = BlockString + Block[1][0][0].colors[1];
        BlockString = BlockString + Block[2][0][0].colors[1];
        BlockString = BlockString + Block[0][0][1].colors[1];
        BlockString = BlockString + Block[1][0][1].colors[1];
        BlockString = BlockString + Block[2][0][1].colors[1];
        BlockString = BlockString + Block[0][0][2].colors[1];
        BlockString = BlockString + Block[1][0][2].colors[1];
        BlockString = BlockString + Block[2][0][2].colors[1];

        // Green Face
        BlockString = BlockString + Block[0][0][0].colors[0];
        BlockString = BlockString + Block[0][0][1].colors[0];
        BlockString = BlockString + Block[0][0][2].colors[0];
        BlockString = BlockString + Block[0][1][0].colors[0];
        BlockString = BlockString + Block[0][1][1].colors[0];
        BlockString = BlockString + Block[0][1][2].colors[0];
        BlockString = BlockString + Block[0][2][0].colors[0];
        BlockString = BlockString + Block[0][2][1].colors[0];
        BlockString = BlockString + Block[0][2][2].colors[0];

        // Red Face
        BlockString = BlockString + Block[0][0][2].colors[2];
        BlockString = BlockString + Block[1][0][2].colors[2];
        BlockString = BlockString + Block[2][0][2].colors[2];
        BlockString = BlockString + Block[0][1][2].colors[2];
        BlockString = BlockString + Block[1][1][2].colors[2];
        BlockString = BlockString + Block[2][1][2].colors[2];
        BlockString = BlockString + Block[0][2][2].colors[2];
        BlockString = BlockString + Block[1][2][2].colors[2];
        BlockString = BlockString + Block[2][2][2].colors[2];

        // Blue Face
        BlockString = BlockString + Block[2][0][2].colors[0];
        BlockString = BlockString + Block[2][0][1].colors[0];
        BlockString = BlockString + Block[2][0][0].colors[0];
        BlockString = BlockString + Block[2][1][2].colors[0];
        BlockString = BlockString + Block[2][1][1].colors[0];
        BlockString = BlockString + Block[2][1][0].colors[0];
        BlockString = BlockString + Block[2][2][2].colors[0];
        BlockString = BlockString + Block[2][2][1].colors[0];
        BlockString = BlockString + Block[2][2][0].colors[0];

        // Orange Face
        BlockString = BlockString + Block[2][0][0].colors[2];
        BlockString = BlockString + Block[1][0][0].colors[2];
        BlockString = BlockString + Block[0][0][0].colors[2];
        BlockString = BlockString + Block[2][1][0].colors[2];
        BlockString = BlockString + Block[1][1][0].colors[2];
        BlockString = BlockString + Block[0][1][0].colors[2];
        BlockString = BlockString + Block[2][2][0].colors[2];
        BlockString = BlockString + Block[1][2][0].colors[2];
        BlockString = BlockString + Block[0][2][0].colors[2];

        // Yellow Face
        BlockString = BlockString + Block[0][2][2].colors[1];
        BlockString = BlockString + Block[1][2][2].colors[1];
        BlockString = BlockString + Block[2][2][2].colors[1];
        BlockString = BlockString + Block[0][2][1].colors[1];
        BlockString = BlockString + Block[1][2][1].colors[1];
        BlockString = BlockString + Block[2][2][1].colors[1];
        BlockString = BlockString + Block[0][2][0].colors[1];
        BlockString = BlockString + Block[1][2][0].colors[1];
        BlockString = BlockString + Block[2][2][0].colors[1];

        return BlockString;
    }

    void StringtoBlock(String blockString) {

        // White Face
        Block[0][0][0].colors[1] = blockString.charAt(0);
        Block[1][0][0].colors[1] = blockString.charAt(1);
        Block[2][0][0].colors[1] = blockString.charAt(2);
        Block[0][0][1].colors[1] = blockString.charAt(3);
        Block[1][0][1].colors[1] = blockString.charAt(4);
        Block[2][0][1].colors[1] = blockString.charAt(5);
        Block[0][0][2].colors[1] = blockString.charAt(6);
        Block[1][0][2].colors[1] = blockString.charAt(7);
        Block[2][0][2].colors[1] = blockString.charAt(8);

        // Green Face
        Block[0][0][0].colors[0] = blockString.charAt(9);
        Block[0][0][1].colors[0] = blockString.charAt(10);
        Block[0][0][2].colors[0] = blockString.charAt(11);
        Block[0][1][0].colors[0] = blockString.charAt(12);
        Block[0][1][1].colors[0] = blockString.charAt(13);
        Block[0][1][2].colors[0] = blockString.charAt(14);
        Block[0][2][0].colors[0] = blockString.charAt(15);
        Block[0][2][1].colors[0] = blockString.charAt(16);
        Block[0][2][2].colors[0] = blockString.charAt(17);

        // Red Face
        Block[0][0][2].colors[2] = blockString.charAt(18);
        Block[1][0][2].colors[2] = blockString.charAt(19);
        Block[2][0][2].colors[2] = blockString.charAt(20);
        Block[0][1][2].colors[2] = blockString.charAt(21);
        Block[1][1][2].colors[2] = blockString.charAt(22);
        Block[2][1][2].colors[2] = blockString.charAt(23);
        Block[0][2][2].colors[2] = blockString.charAt(24);
        Block[1][2][2].colors[2] = blockString.charAt(25);
        Block[2][2][2].colors[2] = blockString.charAt(26);

        // Blue Face
        Block[2][0][2].colors[0] = blockString.charAt(27);
        Block[2][0][1].colors[0] = blockString.charAt(28);
        Block[2][0][0].colors[0] = blockString.charAt(29);
        Block[2][1][2].colors[0] = blockString.charAt(30);
        Block[2][1][1].colors[0] = blockString.charAt(31);
        Block[2][1][0].colors[0] = blockString.charAt(32);
        Block[2][2][2].colors[0] = blockString.charAt(33);
        Block[2][2][1].colors[0] = blockString.charAt(34);
        Block[2][2][0].colors[0] = blockString.charAt(35);

        // Orange Face
        Block[2][0][0].colors[2] = blockString.charAt(36);
        Block[1][0][0].colors[2] = blockString.charAt(37);
        Block[0][0][0].colors[2] = blockString.charAt(38);
        Block[2][1][0].colors[2] = blockString.charAt(39);
        Block[1][1][0].colors[2] = blockString.charAt(40);
        Block[0][1][0].colors[2] = blockString.charAt(41);
        Block[2][2][0].colors[2] = blockString.charAt(42);
        Block[1][2][0].colors[2] = blockString.charAt(43);
        Block[0][2][0].colors[2] = blockString.charAt(44);

        // Yellow Face
        Block[0][2][2].colors[1] = blockString.charAt(45);
        Block[1][2][2].colors[1] = blockString.charAt(46);
        Block[2][2][2].colors[1] = blockString.charAt(47);
        Block[0][2][1].colors[1] = blockString.charAt(48);
        Block[1][2][1].colors[1] = blockString.charAt(49);
        Block[2][2][1].colors[1] = blockString.charAt(50);
        Block[0][2][0].colors[1] = blockString.charAt(51);
        Block[1][2][0].colors[1] = blockString.charAt(52);
        Block[2][2][0].colors[1] = blockString.charAt(53);

    }

    // prints block info with cords and colors of cubelets
    /*
     * void printer(){
     * 
     * int countery = 0;
     * int counterz = 0;
     * 
     * for (int z = 0; z < size; ++z){
     * 
     * for(int y = 0; y < size; ++y){
     * 
     * for (int x = 0; x < size; ++x){
     * 
     * System.out.print("Array[" + x + "][" + y + "][" + z + "] = [" +
     * Arrays.toString(Block[x][y][z].getCords()) + " [" +
     * Block[x][y][z].getColors()[0]+ " " + Block[x][y][z].getColors()[1] + " " +
     * Block[x][y][z].getColors()[2] + "]]" );
     * System.out.print("\t");
     * 
     * ++counterz;
     * if(counterz == size){
     * System.out.println("");
     * counterz = 0;
     * }
     * }
     * 
     * ++countery;
     * if(countery == size){
     * System.out.println("");
     * countery = 0;
     * }
     * }
     * }
     * }
     */

    // Helper function that changes based on developer needs
    void printerHelp() {

        char[][] arrayHelper = new char[9][3];

        // for (int y = 0; y < this.size; y++){
        // for (int z = 0; z < this.size; z++){
        // System.out.println("Array [" + 2 + "] [" + y + "] [" + z + "] -> " +
        // this.Block[2][y][z].getColors()[0] + ", " + Block[2][y][z].getColors()[1] +
        // ", " + Block[2][y][z].getColors()[2]);
        // //Block[0][y][z].colorSwap('x');
        // //System.out.println("Array [" + 0 + "] [" + y + "] [" + z + "] -> " +
        // this.Block[0][y][z].getColors()[0] + ", " + Block[0][y][z].getColors()[1] +
        // ", " + Block[0][y][z].getColors()[2]);
        // }
        // }

        System.out.println(""); // Space in terminal

        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                System.out.println("Array [" + x + "] [" + y + "] [" + 2 + "] -> " + this.Block[x][y][2].getColors()[0]
                        + ", " + Block[x][y][2].getColors()[1] + ", " + Block[x][y][2].getColors()[2]);
            }
        }

    }

    // Makes the 12 different turns based on the direction given
    void turnNotModular(String direction) {

        Cubelet tempCubelet;

        if (direction.equals("L")) { // Left ClockWise

            tempCubelet = Block[0][0][0];
            Block[0][0][0] = Block[0][2][0];
            Block[0][2][0] = Block[0][2][2];
            Block[0][2][2] = Block[0][0][2];
            Block[0][0][2] = tempCubelet;

            tempCubelet = Block[0][0][1];
            Block[0][0][1] = Block[0][1][0];
            Block[0][1][0] = Block[0][2][1];
            Block[0][2][1] = Block[0][1][2];
            Block[0][1][2] = tempCubelet;

            for (int y = 0; y < size; ++y) {
                for (int z = 0; z < size; ++z) {
                    Block[0][y][z].colorSwap('x');
                }
            }

        }

        if (direction.equals("l")) { // Left Counter-ClockWise

            tempCubelet = Block[0][0][0];
            Block[0][0][0] = Block[0][0][2];
            Block[0][0][2] = Block[0][2][2];
            Block[0][2][2] = Block[0][2][0];
            Block[0][2][0] = tempCubelet;

            tempCubelet = Block[0][0][1];
            Block[0][0][1] = Block[0][1][2];
            Block[0][1][2] = Block[0][2][1];
            Block[0][2][1] = Block[0][1][0];
            Block[0][1][0] = tempCubelet;

            for (int y = 0; y < size; ++y) {
                for (int z = 0; z < size; ++z) {
                    Block[0][y][z].colorSwap('x');
                }
            }

        }

        if (direction.equals("R")) { // Right Clockwise

            tempCubelet = Block[2][0][0];
            Block[2][0][0] = Block[2][0][2];
            Block[2][0][2] = Block[2][2][2];
            Block[2][2][2] = Block[2][2][0];
            Block[2][2][0] = tempCubelet;

            tempCubelet = Block[2][0][1];
            Block[2][0][1] = Block[2][1][2];
            Block[2][1][2] = Block[2][2][1];
            Block[2][2][1] = Block[2][1][0];
            Block[2][1][0] = tempCubelet;

            for (int y = 0; y < size; ++y) {
                for (int z = 0; z < size; ++z) {
                    Block[2][y][z].colorSwap('x');
                }
            }

        }

        if (direction.equals("r")) { // Right Counter-ClockWise

            tempCubelet = Block[2][0][0];
            Block[2][0][0] = Block[2][2][0];
            Block[2][2][0] = Block[2][2][2];
            Block[2][2][2] = Block[2][0][2];
            Block[2][0][2] = tempCubelet;

            tempCubelet = Block[2][0][1];
            Block[2][0][1] = Block[2][1][0];
            Block[2][1][0] = Block[2][2][1];
            Block[2][2][1] = Block[2][1][2];
            Block[2][1][2] = tempCubelet;

            for (int y = 0; y < size; ++y) {
                for (int z = 0; z < size; ++z) {
                    Block[2][y][z].colorSwap('x');
                }
            }

        }

        if (direction.equals("d")) { // Bottom (Down) ClockWise

            tempCubelet = Block[0][2][0];
            Block[0][2][0] = Block[0][2][2];
            Block[0][2][2] = Block[2][2][2];
            Block[2][2][2] = Block[2][2][0];
            Block[2][2][0] = tempCubelet;

            tempCubelet = Block[1][2][0];
            Block[1][2][0] = Block[0][2][1];
            Block[0][2][1] = Block[1][2][2];
            Block[1][2][2] = Block[2][2][1];
            Block[2][2][1] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int z = 0; z < size; ++z) {
                    Block[x][2][z].colorSwap('y');
                }
            }

        }

        if (direction.equals("D")) { // Bottom (Down) Counter-ClockWise

            tempCubelet = Block[0][2][0];
            Block[0][2][0] = Block[2][2][0];
            Block[2][2][0] = Block[2][2][2];
            Block[2][2][2] = Block[0][2][2];
            Block[0][2][2] = tempCubelet;

            tempCubelet = Block[1][2][0];
            Block[1][2][0] = Block[2][2][1];
            Block[2][2][1] = Block[1][2][2];
            Block[1][2][2] = Block[0][2][1];
            Block[0][2][1] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int z = 0; z < size; ++z) {
                    Block[x][2][z].colorSwap('y');
                }
            }

        }

        if (direction.equals("U")) { // Up (Top) ClockWise

            tempCubelet = Block[0][0][0];
            Block[0][0][0] = Block[0][0][2];
            Block[0][0][2] = Block[2][0][2];
            Block[2][0][2] = Block[2][0][0];
            Block[2][0][0] = tempCubelet;

            tempCubelet = Block[1][0][0];
            Block[1][0][0] = Block[0][0][1];
            Block[0][0][1] = Block[1][0][2];
            Block[1][0][2] = Block[2][0][1];
            Block[2][0][1] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int z = 0; z < size; ++z) {
                    Block[x][0][z].colorSwap('y');
                }
            }

        }

        if (direction.equals("u")) { // Up (Top) Counter-ClockWise

            tempCubelet = Block[0][0][0];
            Block[0][0][0] = Block[2][0][0];
            Block[2][0][0] = Block[2][0][2];
            Block[2][0][2] = Block[0][0][2];
            Block[0][0][2] = tempCubelet;

            tempCubelet = Block[1][0][0];
            Block[1][0][0] = Block[2][0][1];
            Block[2][0][1] = Block[1][0][2];
            Block[1][0][2] = Block[0][0][1];
            Block[0][0][1] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int z = 0; z < size; ++z) {
                    Block[x][0][z].colorSwap('y');
                }
            }

        }

        if (direction.equals("B")) { // Back Clockwise

            tempCubelet = Block[0][0][0];
            Block[0][0][0] = Block[2][0][0];
            Block[2][0][0] = Block[2][2][0];
            Block[2][2][0] = Block[0][2][0];
            Block[0][2][0] = tempCubelet;

            tempCubelet = Block[1][0][0];
            Block[1][0][0] = Block[2][1][0];
            Block[2][1][0] = Block[1][2][0];
            Block[1][2][0] = Block[0][1][0];
            Block[0][1][0] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int y = 0; y < size; ++y) {
                    Block[x][y][0].colorSwap('z');
                }
            }

        }

        if (direction.equals("b")) { // Back Clockwise

            tempCubelet = Block[0][0][0];
            Block[0][0][0] = Block[0][2][0];
            Block[0][2][0] = Block[2][2][0];
            Block[2][2][0] = Block[2][0][0];
            Block[2][0][0] = tempCubelet;

            tempCubelet = Block[1][0][0];
            Block[1][0][0] = Block[0][1][0];
            Block[0][1][0] = Block[1][2][0];
            Block[1][2][0] = Block[2][1][0];
            Block[2][1][0] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int y = 0; y < size; ++y) {
                    Block[x][y][0].colorSwap('z');
                }
            }

        }

        if (direction.equals("f")) { // Front Clockwise

            tempCubelet = Block[0][0][2];
            Block[0][0][2] = Block[2][0][2];
            Block[2][0][2] = Block[2][2][2];
            Block[2][2][2] = Block[0][2][2];
            Block[0][2][2] = tempCubelet;

            tempCubelet = Block[1][0][2];
            Block[1][0][2] = Block[2][1][2];
            Block[2][1][2] = Block[1][2][2];
            Block[1][2][2] = Block[0][1][2];
            Block[0][1][2] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int y = 0; y < size; ++y) {
                    Block[x][y][2].colorSwap('z');
                }
            }

        }

        if (direction.equals("F")) { // Front Clockwise

            tempCubelet = Block[0][0][2];
            Block[0][0][2] = Block[0][2][2];
            Block[0][2][2] = Block[2][2][2];
            Block[2][2][2] = Block[2][0][2];
            Block[2][0][2] = tempCubelet;

            tempCubelet = Block[1][0][2];
            Block[1][0][2] = Block[0][1][2];
            Block[0][1][2] = Block[1][2][2];
            Block[1][2][2] = Block[2][1][2];
            Block[2][1][2] = tempCubelet;

            for (int x = 0; x < size; ++x) {
                for (int y = 0; y < size; ++y) {
                    Block[x][y][2].colorSwap('z');
                }
            }

        }

    }

    // Prints each face individually
    void printFaces() {

        System.out.println("White Face:");
        System.out
                .println(Block[0][0][0].colors[1] + ", " + Block[1][0][0].colors[1] + ", " + Block[2][0][0].colors[1]);
        System.out
                .println(Block[0][0][1].colors[1] + ", " + Block[1][0][1].colors[1] + ", " + Block[2][0][1].colors[1]);
        System.out
                .println(Block[0][0][2].colors[1] + ", " + Block[1][0][2].colors[1] + ", " + Block[2][0][2].colors[1]);

        System.out.println("");

        System.out.println("Yellow Face:");
        System.out
                .println(Block[0][2][2].colors[1] + ", " + Block[1][2][2].colors[1] + ", " + Block[2][2][2].colors[1]);
        System.out
                .println(Block[0][2][1].colors[1] + ", " + Block[1][2][1].colors[1] + ", " + Block[2][2][1].colors[1]);
        System.out
                .println(Block[0][2][0].colors[1] + ", " + Block[1][2][0].colors[1] + ", " + Block[2][2][0].colors[1]);

        System.out.println("");

        System.out.println("Red Face:");
        System.out
                .println(Block[0][0][2].colors[2] + ", " + Block[1][0][2].colors[2] + ", " + Block[2][0][2].colors[2]);
        System.out
                .println(Block[0][1][2].colors[2] + ", " + Block[1][1][2].colors[2] + ", " + Block[2][1][2].colors[2]);
        System.out
                .println(Block[0][2][2].colors[2] + ", " + Block[1][2][2].colors[2] + ", " + Block[2][2][2].colors[2]);

        System.out.println("");

        System.out.println("Orange Face:");
        System.out
                .println(Block[0][0][0].colors[2] + ", " + Block[1][0][0].colors[2] + ", " + Block[2][0][0].colors[2]);
        System.out
                .println(Block[0][1][0].colors[2] + ", " + Block[1][1][0].colors[2] + ", " + Block[2][1][0].colors[2]);
        System.out
                .println(Block[0][2][0].colors[2] + ", " + Block[1][2][0].colors[2] + ", " + Block[2][2][0].colors[2]);

        System.out.println("");

        System.out.println("Green Face:");
        System.out
                .println(Block[0][0][0].colors[0] + ", " + Block[0][0][1].colors[0] + ", " + Block[0][0][2].colors[0]);
        System.out
                .println(Block[0][1][0].colors[0] + ", " + Block[0][1][1].colors[0] + ", " + Block[0][1][2].colors[0]);
        System.out
                .println(Block[0][2][0].colors[0] + ", " + Block[0][2][1].colors[0] + ", " + Block[0][2][2].colors[0]);

        System.out.println("");

        System.out.println("Blue Face:");
        System.out
                .println(Block[2][0][0].colors[0] + ", " + Block[2][0][1].colors[0] + ", " + Block[2][0][2].colors[0]);
        System.out
                .println(Block[2][1][0].colors[0] + ", " + Block[2][1][1].colors[0] + ", " + Block[2][1][2].colors[0]);
        System.out
                .println(Block[2][2][0].colors[0] + ", " + Block[2][2][1].colors[0] + ", " + Block[2][2][2].colors[0]);

    }

    // Prints the block all together in "one 2d array"
    public void printBlock() {
        System.out.println("            " + "[" + Block[0][0][0].colors[1] + "] [" + Block[1][0][0].colors[1] + "] ["
                + Block[2][0][0].colors[1] + "]");
        System.out.println("            " + "[" + Block[0][0][1].colors[1] + "] [" + Block[1][0][1].colors[1] + "] ["
                + Block[2][0][1].colors[1] + "]");
        System.out.println("            " + "[" + Block[0][0][2].colors[1] + "] [" + Block[1][0][2].colors[1] + "] ["
                + Block[2][0][2].colors[1] + "]");
        System.out.println("[" + Block[0][0][0].colors[0] + "] [" + Block[0][0][1].colors[0] + "] ["
                + Block[0][0][2].colors[0] + "] [" + Block[0][0][2].colors[2] + "] [" + Block[1][0][2].colors[2] + "] ["
                + Block[2][0][2].colors[2] + "] [" + Block[2][0][2].colors[0] + "] [" + Block[2][0][1].colors[0] + "] ["
                + Block[2][0][0].colors[0] + "] [" + Block[2][0][0].colors[2] + "] [" + Block[1][0][0].colors[2] + "] ["
                + Block[0][0][0].colors[2] + "]");
        System.out.println("[" + Block[0][1][0].colors[0] + "] [" + Block[0][1][1].colors[0] + "] ["
                + Block[0][1][2].colors[0] + "] [" + Block[0][1][2].colors[2] + "] [" + Block[1][1][2].colors[2] + "] ["
                + Block[2][1][2].colors[2] + "] [" + Block[2][1][2].colors[0] + "] [" + Block[2][1][1].colors[0] + "] ["
                + Block[2][1][0].colors[0] + "] [" + Block[2][1][0].colors[2] + "] [" + Block[1][1][0].colors[2] + "] ["
                + Block[0][1][0].colors[2] + "]");
        System.out.println("[" + Block[0][2][0].colors[0] + "] [" + Block[0][2][1].colors[0] + "] ["
                + Block[0][2][2].colors[0] + "] [" + Block[0][2][2].colors[2] + "] [" + Block[1][2][2].colors[2] + "] ["
                + Block[2][2][2].colors[2] + "] [" + Block[2][2][2].colors[0] + "] [" + Block[2][2][1].colors[0] + "] ["
                + Block[2][2][0].colors[0] + "] [" + Block[2][2][0].colors[2] + "] [" + Block[1][2][0].colors[2] + "] ["
                + Block[0][2][0].colors[2] + "]");
        System.out.println("            " + "[" + Block[0][2][2].colors[1] + "] [" + Block[1][2][2].colors[1] + "] ["
                + Block[2][2][2].colors[1] + "]");
        System.out.println("            " + "[" + Block[0][2][1].colors[1] + "] [" + Block[1][2][1].colors[1] + "] ["
                + Block[2][2][1].colors[1] + "]");
        System.out.println("            " + "[" + Block[0][2][0].colors[1] + "] [" + Block[1][2][0].colors[1] + "] ["
                + Block[2][2][0].colors[1] + "]");
    }

    // Randomizes cube with user input on how many random turns it makes.
    // Will sometimes do two turns that equal out, could be fixed
    void randomizeCube(int turns) {
        Random rn = new Random();

        int faceTurn;

        for (int i = 0; i < turns; ++i) {
            faceTurn = rn.nextInt(12);

            if (faceTurn == 0) {
                turnNotModular("F");
                // System.out.println("F");
            }

            if (faceTurn == 1) {
                turnNotModular("f");
                // System.out.println("F'");
            }

            if (faceTurn == 2) {
                turnNotModular("B");
                // System.out.println("B");
            }

            if (faceTurn == 3) {
                turnNotModular("b");
                // System.out.println("B'");
            }

            if (faceTurn == 4) {
                turnNotModular("R");
                // System.out.println("R");
            }

            if (faceTurn == 5) {
                turnNotModular("r");
                // System.out.println("R'");
            }

            if (faceTurn == 6) {
                turnNotModular("L");
                // System.out.println("L");
            }

            if (faceTurn == 7) {
                turnNotModular("l");
                // System.out.println("L'");
            }

            if (faceTurn == 8) {
                turnNotModular("U");
                // System.out.println("U");
            }

            if (faceTurn == 9) {
                turnNotModular("u");
                // System.out.println("U'");
            }

            if (faceTurn == 10) {
                turnNotModular("D");
                // System.out.println("D");
            }

            if (faceTurn == 11) {
                turnNotModular("d");
                // System.out.println("D'");
            }

            if (faceTurn == 12) {
                // System.out.println("This case shouldnt happen in randomize");
            }

            // printBlock();
            // System.out.println();

        }
    }

    int compareCubeStrings(String One, String Two) {

        int matches = 0;

        for (int i = 0; i < One.length(); ++i) {
            if (One.charAt(i) == Two.charAt(i)) {
                ++matches;
            }
        }

        return matches;
    }

    int numofNulls(String GoalString) {

        int matches = 0;

        for (int i = 0; i < GoalString.length(); ++i) {
            if (GoalString.charAt(i) == 'N') {
                ++matches;
            }
        }

        return matches;
    }

    // The Start String should have zero null values where the End should have some
    // if not the goal
    public String BiDirectionalTree(String Start, String End) {

        final class Node {

            // Node Class Variables
            private Node parent;
            private Node next;
            private String BlockString;
            private String turn;

            // Default Node Constructor
            // Default Values
            public Node() {
                parent = null;
                next = null;
                BlockString = null;
                turn = "\0"; // null
            }

            public Node(Node parent, Node next, String string, String turn) {
                this.parent = parent;
                this.next = next;
                BlockString = string;
                this.turn = turn;
            }
        }

        // Total num of colors - numberofNulls
        int matches = 54 - numofNulls(End);
        int length = 0;

        Node TopOpenListHead = null;
        Node TopNewNodesHead = null;
        Node BottomOpenListHead = null;
        Node BottomNewNodesHead = null;
        Node SearchTop = null;
        Node SearchBottom = null;
        Node current = null;

        Node GoalTop = null;
        Node GoalBottom = null;

        boolean found = false;
        boolean listEmpty = false;
        String turn = "\0";
        String turnBack = "\0";

        if (matches == compareCubeStrings(Start, End)) {
            return "C";
        }

        // StringtoBlock(Start);
        TopOpenListHead = new Node(null, null, Start, "\0");
        BottomOpenListHead = new Node(null, null, End, "\0");

        while (!found) {

            current = TopOpenListHead;
            length = length + 1;

            // System.out.println("Top Level Created");

            while (!listEmpty) {

                StringtoBlock(current.BlockString);

                for (int i = 0; i < 12; ++i) {

                    if (i == 0) {
                        turn = "R";
                        turnBack = "r";
                    }

                    if (i == 1) {
                        turn = "r";
                        turnBack = "R";
                    }

                    if (i == 2) {
                        turn = "L";
                        turnBack = "l";
                    }

                    if (i == 3) {
                        turn = "l";
                        turnBack = "L";
                    }

                    if (i == 4) {
                        turn = "F";
                        turnBack = "f";
                    }

                    if (i == 5) {
                        turn = "f";
                        turnBack = "F";
                    }

                    if (i == 6) {
                        turn = "B";
                        turnBack = "b";
                    }

                    if (i == 7) {
                        turn = "b";
                        turnBack = "B";
                    }

                    if (i == 8) {
                        turn = "U";
                        turnBack = "u";
                    }

                    if (i == 9) {
                        turn = "u";
                        turnBack = "U";
                    }

                    if (i == 10) {
                        turn = "D";
                        turnBack = "d";
                    }

                    if (i == 11) {
                        turn = "d";
                        turnBack = "D";
                    }

                    turnNotModular(turn);

                    if (TopNewNodesHead == null) {
                        TopNewNodesHead = new Node(current, null, BlocktoString(), turn);
                        SearchTop = TopNewNodesHead;
                    }

                    else {
                        SearchTop.next = new Node(current, null, BlocktoString(), turn);
                        SearchTop = SearchTop.next;
                    }

                    turnNotModular(turnBack);

                    SearchBottom = BottomOpenListHead;

                    while (true) {

                        if (matches == compareCubeStrings(SearchTop.BlockString, SearchBottom.BlockString)) {
                            found = true;
                            listEmpty = true;
                            GoalTop = SearchTop;
                            GoalBottom = SearchBottom;
                            break;
                        }

                        if (SearchBottom.next == null) {
                            break;
                        }

                        SearchBottom = SearchBottom.next;
                    }

                    if (found) {
                        break;
                    }
                }

                if (found) {
                    break;
                }

                if (current.next == null) {
                    listEmpty = true;
                }

                current = current.next;
            }

            if (found) {
                break;
            }

            TopOpenListHead = TopNewNodesHead;
            TopNewNodesHead = null;
            SearchTop = null;
            SearchBottom = null;

            listEmpty = false;

            current = BottomOpenListHead;
            length = length + 1;

            while (!listEmpty) {

                StringtoBlock(current.BlockString);

                for (int i = 0; i < 12; ++i) {

                    if (i == 0) {
                        turn = "R";
                        turnBack = "r";
                    }

                    if (i == 1) {
                        turn = "r";
                        turnBack = "R";
                    }

                    if (i == 2) {
                        turn = "L";
                        turnBack = "l";
                    }

                    if (i == 3) {
                        turn = "l";
                        turnBack = "L";
                    }

                    if (i == 4) {
                        turn = "F";
                        turnBack = "f";
                    }

                    if (i == 5) {
                        turn = "f";
                        turnBack = "F";
                    }

                    if (i == 6) {
                        turn = "B";
                        turnBack = "b";
                    }

                    if (i == 7) {
                        turn = "b";
                        turnBack = "B";
                    }

                    if (i == 8) {
                        turn = "U";
                        turnBack = "u";
                    }

                    if (i == 9) {
                        turn = "u";
                        turnBack = "U";
                    }

                    if (i == 10) {
                        turn = "D";
                        turnBack = "d";
                    }

                    if (i == 11) {
                        turn = "d";
                        turnBack = "D";
                    }

                    turnNotModular(turn);

                    if (BottomNewNodesHead == null) {
                        BottomNewNodesHead = new Node(current, null, BlocktoString(), turnBack); // parent, next,
                                                                                                 // string,
                        SearchBottom = BottomNewNodesHead;
                    }

                    else {
                        SearchBottom.next = new Node(current, null, BlocktoString(), turnBack);
                        SearchBottom = SearchBottom.next;
                    }

                    turnNotModular(turnBack);

                    SearchTop = TopOpenListHead;

                    while (true) {

                        if (matches == compareCubeStrings(SearchTop.BlockString, SearchBottom.BlockString)) {
                            found = true;
                            listEmpty = true;
                            GoalTop = SearchTop;
                            GoalBottom = SearchBottom;
                            break;
                        }

                        if (SearchTop.next == null) {
                            break;
                        }

                        SearchTop = SearchTop.next;

                    }

                    if (found) {
                        break;
                    }
                }

                if (found) {
                    break;
                }

                if (current.next == null) {
                    listEmpty = true;
                }

                current = current.next;
            }

            if (found) {
                break;
            }

            BottomOpenListHead = BottomNewNodesHead;
            BottomNewNodesHead = null;

            listEmpty = false;

            SearchBottom = null;
            SearchTop = null;

        }

        StringtoBlock(Start);

        String turnTop = "";
        String turnBottom = "";

        String[] moves = new String[length];

        // System.out.println("Top Match -> " + GoalTop.BlockString);
        // StringtoBlock(GoalTop.BlockString);
        // printBlock();
        // System.out.println("Bottom Match -> " + GoalBottom.BlockString);
        // StringtoBlock(GoalBottom.BlockString);
        // printBlock();

        int topmoves = length / 2;
        int bottommoves = length - topmoves;

        /*
         * for(int i = 0; i < topmoves; ++i){
         * moves[i] = GoalTop.turn;
         * GoalTop = GoalTop.parent;
         * }
         * 
         * for(int i = 0; i < bottommoves; ++i){
         * moves[i + topmoves] = GoalBottom.turn;
         * GoalBottom = GoalBottom.parent;
         * }
         * 
         * return moves;
         */

        while (true) {

            if (GoalTop.parent == null) {
                break;
            }

            turnTop = GoalTop.turn + turnTop;

            GoalTop = GoalTop.parent;
        }

        while (true) {

            if (GoalBottom.parent == null) {
                break;
            }

            turnBottom = turnBottom + GoalBottom.turn;

            GoalBottom = GoalBottom.parent;
        }

        return turnTop + turnBottom;

    }

    public void ApplyMoves(String moves) {

        if (moves.equals("C")) { // Complete
            return;
        }

        for (int i = 0; i < moves.length(); ++i) {
            turnNotModular(String.valueOf(moves.charAt(i)));
        }
    }

    // Search that uses Bidirectional Search tree with Patterns
    // About 80% sure this works... Just takes forever depending on the orientations
    // of pieces
    // Haven't taken the hours of my day to let computer sit
    public String BiDiSearch() {

        // ----- Patterns -----

        // White Cross -> NWN WWW NWN NGN NGN NNN NRN NRN NNN NBN NBN NNN NON NON NNN
        // NNN NNN NNN
        String WhiteCross = "NWNWWWNWNNGNNGNNNNNRNNRNNNNNBNNBNNNNNONNONNNNNNNNNNNNN";

        //// White Face -> WWW WWW WWW GGG NGN NNN RRR NRN NNN BBB NBN NNN OOO NON NNN
        //// NNN NNN NNN
        // String WhiteFace = "WWWWWWWWWGGGNGNNNNRRRNRNNNNBBBNBNNNNOOONONNNNNNNNNNNNN";

        // Second Layer -> WWW WWW WWW GGG GGG NNN RRR RRR NNN BBB BBB NNN OOO OOO NNN
        // NNN NNN NNN
        // String SecondLayer =
        // "WWWWWWWWWGGGGGGNNNRRRRRRNNNBBBBBBNNNOOOOOONNNNNNNNNNNN";

        // Red Green Second Layer -> NWN WWW WWN NGG NGG NNN RRN RRN NNN NBN NBN NNN NON
        // NON NNN NNN NNN NNN
        String RedGreen = "NWNWWWWWNNGGNGGNNNRRNRRNNNNNBNNBNNNNNONNONNNNNNNNNNNNN";

        // Red Blue Second Layer -> NWN WWW WWW NGG NGG NNN RRR RRR NNN BBN BBN NNN NON
        // NON NNN NNN NNN NNN
        String RedBlue = "NWNWWWWWWNGGNGGNNNRRRRRRNNNBBNBBNNNNNONNONNNNNNNNNNNNN";

        // Green Orange Second Layer -> WWN WWW WWW GGG GGG NNN RRR RRR NNN BBN BBN NNN
        // NOO NOO NNN NNN NNN NNN
        String GreenOrange = "WWNWWWWWWGGGGGGNNNRRRRRRNNNBBNBBNNNNNOONOONNNNNNNNNNNN";

        // Orange Blue Second Layer -> WWW WWW WWW GGG GGG NNN RRR RRR NNN BBB BBB NNN
        // OOO OOO NNN NNN NNN NNN
        String OrangeBlue = "WWWWWWWWWGGGGGGNNNRRRRRRNNNBBBBBBNNNOOOOOONNNNNNNNNNNN";

        // Yellow Cross -> WWW WWW WWW GGG GGG NNN RRR RRR NNN BBB BBB NNN OOO OOO NNN
        // NYN YYY NYN
        String YellowCross = "WWWWWWWWWGGGGGGNNNRRRRRRNNNBBBBBBNNNOOOOOONNNNYNYYYNYN";

        // Yellow Face -> WWW WWW WWW GGG GGG NNN RRR RRR NNN BBB BBB NNN OOO OOO NNN
        // YYY YYY YYY
        String YellowFace = "WWWWWWWWWGGGGGGNNNRRRRRRNNNBBBBBBNNNOOOOOONNNYYYYYYYYY";

        // Yellow Corners -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BNB OOO OOO ONO
        // YYY YYY YYY
        String YellowCorners = "WWWWWWWWWGGGGGGGNGRRRRRRRNRBBBBBBBNBOOOOOOONOYYYYYYYYY";

        // BlueFace Solved -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO
        // ONO YYY YYY YYY
        // String BlueFaceSolved =
        // "WWWWWWWWWGGGGGGGNGRRRRRRRNRBBBBBBBBBOOOOOOONOYYYYYYYYY";

        // GreenFace Solved -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO
        // ONO YYY YYY YYY
        // String GreenFaceSolved =
        // "WWWWWWWWWGGGGGGGGGRRRRRRRNRBBBBBBBNBOOOOOOONOYYYYYYYYY";

        // RedFace Solved -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO ONO
        // YYY YYY YYY
        // String RedFaceSolved =
        // "WWWWWWWWWGGGGGGGNGRRRRRRRRRBBBBBBBNBOOOOOOONOYYYYYYYYY";

        // OrangeFace Solved -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO
        // ONO YYY YYY YYY
        // String OrangeFaceSolved =
        // "WWWWWWWWWGGGGGGGNGRRRRRRRNRBBBBBBBNBOOOOOOOOOYYYYYYYYY";

        // ----- End Patterns -----

        String moves = "";
        String tempMoves;

        String[] patterns = new String[8];

        patterns[0] = WhiteCross;
        patterns[1] = RedGreen;
        patterns[2] = RedBlue;
        patterns[3] = GreenOrange;
        patterns[4] = OrangeBlue;
        patterns[5] = YellowCross;
        patterns[6] = YellowFace;
        patterns[7] = YellowCorners;

        String Start = BlocktoString();

        for (int i = 0; i < patterns.length; ++i) {

            tempMoves = BiDirectionalTree(BlocktoString(), patterns[i]);
            System.out.println(tempMoves);
            printBlock();
            System.out.println("");

            // If tempMoves = "C"
            // then no moves were needed for next step
            // and don't want to add "C" to list of moves
            if (tempMoves.equals("C")) {
                // Do nothing
            }

            else {

                ApplyMoves(tempMoves);
                moves = moves + tempMoves;

            }

        }

        // Algorithms

        // These are only to orientate final middle edges
        // Take atleast 12 moves
        // Will take too long in bidirectional search
        // Didn't want to.. Had to

        // Orange Face Solved
        if (BlocktoString().equals("WWWWWWWWWGGGGGGGRGRRRRRRRBRBBBBBBBGBOOOOOOOOOYYYYYYYYY")) {
            moves = moves + "rDrdrdrDRDRR";
        }

        if (BlocktoString().equals("WWWWWWWWWGGGGGGGBGRRRRRRRGRBBBBBBBRBOOOOOOOOOYYYYYYYYY")) {
            moves = moves + "LdLDLDLdldll";
        }

        // Blue Face Solved
        if (BlocktoString().equals("WWWWWWWWWGGGGGGGOGRRRRRRRGRBBBBBBBBBOOOOOOOROYYYYYYYYY")) {
            moves = moves + "DLdLDLDLdldlld";
        }

        if (BlocktoString().equals("WWWWWWWWWGGGGGGGRGRRRRRRRORBBBBBBBBBOOOOOOOGOYYYYYYYYY")) {
            moves = moves + "DrDrdrdrDRDRRd";
        }

        // Red Face Solved
        if (BlocktoString().equals("WWWWWWWWWGGGGGGGOGRRRRRRRRRBBBBBBBGBOOOOOOOBOYYYYYYYYY")) {
            moves = moves + "DDLdLDLDLdldlldd";
        }

        if (BlocktoString().equals("WWWWWWWWWGGGGGGGBGRRRRRRRRRBBBBBBBOBOOOOOOOGOYYYYYYYYY")) {
            moves = moves + "DDrDrdrdrDRDRRdd";
        }

        // Green Face Solved
        if (BlocktoString().equals("WWWWWWWWWGGGGGGGGGRRRRRRRORBBBBBBBRBOOOOOOOBOYYYYYYYYY")) {
            moves = moves + "dLdLDLDLdldllD";
        }

        if (BlocktoString().equals("WWWWWWWWWGGGGGGGGGRRRRRRRBRBBBBBBBOBOOOOOOOROYYYYYYYYY")) {
            moves = moves + "drDrdrdrDRDRRD";
        }

        // Blue/Green and Red/Orange flipped
        if (BlocktoString().equals("WWWWWWWWWGGGGGGGBGRRRRRRRORBBBBBBBGBOOOOOOOROYYYYYYYYY")) {
            moves = moves + "LdLDLDLdldllDLdLDLDLdldlld";
        }

        // Blue/Orange and Red/Green flipped
        if (BlocktoString().equals("WWWWWWWWWGGGGGGGRGRRRRRRRGRBBBBBBBOBOOOOOOOBOYYYYYYYYY")) {
            moves = moves + "LdLDLDLdldlldLdLDLDLdldllD";
        }

        // Blue/Red and Green/Orange flipped
        if (BlocktoString().equals("WWWWWWWWWGGGGGGGOGRRRRRRRBRBBBBBBBRBOOOOOOOGOYYYYYYYYY")) {
            moves = moves + "LdLDLDLdldllDDrDrdrdrDRDRRdd";
        }

        // End Algorithms

        // Return block as it was given
        StringtoBlock(Start);

        return moves;

    }

    public String AStarSearch() {

        final class Node {

            // Node Class Variables
            private Node parent;
            private Node next;
            private Node previous;
            private String BlockString;
            private String turn;
            private int cost;

            public Node(Node parent, Node next, Node previous, String string, String turn, int cost) {
                this.parent = parent;
                this.next = next;
                this.previous = previous;
                BlockString = string;
                this.turn = turn;
                this.cost = cost;
            }
        }

        // Solved Block String -> WWW WWW WWW GGG GGG GGG RRR RRR RRR OOO OOO OOO YYY
        // YYY YYY
        String Solved = "WWWWWWWWWGGGGGGGGGRRRRRRRRRBBBBBBBBBOOOOOOOOOYYYYYYYYY";

        // Make sure block sent into a solved block
        if (BlocktoString().equals(Solved)) {
            return "";
        }

        Node root = new Node(null, null, null, BlocktoString(), null, getCost());

        Node OpenListHead = null;
        Node OpenListTail = null;
        Node ClosedListHead = root;
        Node ClosedListTail = root;

        // ClosedList start with 1 because it will be root
        int OpenLength = 0;
        int ClosedLength = 1;

        Node current = root;
        Node search = null;

        String moves = "";

        boolean InClosed = false;

        int minimum;

        String turn = "ShouldNeverSee";
        String turnBack = "ShouldNeverSee";

        int cost;

        while (true) {

            System.out.println("Block cost: " + current.cost);
            System.out.println("BlockString: " + current.BlockString);
            System.out.println("Closed List Length: " + ClosedLength);
            System.out.println("Open List Length: " + OpenLength);
            System.out.println("");

            if (Solved.compareTo(current.BlockString) == 0) {
                break;
            }

            StringtoBlock(current.BlockString);

            for (int i = 0; i < 27; ++i) {

                if (i == 0) {
                    turn = "R";
                    turnBack = "r";
                }

                if (i == 1) {
                    turn = "r";
                    turnBack = "R";
                }

                if (i == 2) {
                    turn = "RR";
                    turnBack = "rr";
                }

                if (i == 3) {
                    turn = "L";
                    turnBack = "l";
                }

                if (i == 4) {
                    turn = "l";
                    turnBack = "L";
                }

                if (i == 5) {
                    turn = "LL";
                    turnBack = "ll";
                }

                if (i == 6) {
                    turn = "F";
                    turnBack = "f";
                }

                if (i == 7) {
                    turn = "f";
                    turnBack = "F";
                }

                if (i == 8) {
                    turn = "FF";
                    turnBack = "ff";
                }

                if (i == 9) {
                    turn = "B";
                    turnBack = "b";
                }

                if (i == 10) {
                    turn = "b";
                    turnBack = "B";
                }

                if (i == 11) {
                    turn = "BB";
                    turnBack = "bb";
                }

                if (i == 12) {
                    turn = "U";
                    turnBack = "u";
                }

                if (i == 13) {
                    turn = "u";
                    turnBack = "U";
                }

                if (i == 14) {
                    turn = "UU";
                    turnBack = "uu";
                }

                if (i == 15) {
                    turn = "D";
                    turnBack = "d";
                }

                if (i == 16) {
                    turn = "d";
                    turnBack = "D";
                }

                if (i == 17) {
                    turn = "DD";
                    turnBack = "dd";
                }

                if (i == 18) {
                    turn = "Rl";
                    turnBack = "rL";
                }

                if (i == 19) {
                    turn = "RRLL";
                    turnBack = "RRLL";
                }

                if (i == 20) {
                    turn = "rL";
                    turnBack = "Rl";
                }

                if (i == 21) {
                    turn = "Ud";
                    turnBack = "uD";
                }

                if (i == 22) {
                    turn = "UUDD";
                    turnBack = "UUDD";
                }

                if (i == 23) {
                    turn = "uD";
                    turnBack = "Ud";
                }

                if (i == 24) {
                    turn = "Fb";
                    turnBack = "fB";
                }

                if (i == 25) {
                    turn = "FFBB";
                    turnBack = "FFBB";
                }

                if (i == 26) {
                    turn = "fB";
                    turnBack = "Fb";
                }

                // Turn Block
                // turnNotModular(turn);
                ApplyMoves(turn);

                InClosed = false;

                search = ClosedListHead;

                while (true) {

                    if (search.BlockString.equals(BlocktoString())) {
                        InClosed = true;
                    }

                    if (search.next == null) {
                        break;
                    }

                    else {
                        search = search.next;
                    }

                }

                // cost = current.cost + getCost();
                cost = getCost();

                if (cost > current.cost) {
                    InClosed = true;
                }

                // Add node to OpenList
                if (OpenLength == 0 && !InClosed) {
                    OpenListHead = new Node(current, null, null, BlocktoString(), turn, cost);
                    OpenListTail = OpenListHead;
                    OpenLength++;
                }

                else if (OpenLength == 1 && InClosed) {
                    OpenListTail = new Node(current, null, OpenListHead, BlocktoString(), turn, cost);
                    OpenListHead.next = OpenListTail;
                    OpenLength++;
                }

                else if (!InClosed) {
                    Node tempNode = new Node(current, null, OpenListTail, BlocktoString(), turn, cost);
                    OpenListTail.next = tempNode;
                    OpenListTail = tempNode;
                    OpenLength++;
                }

                // Turn block back to previous state
                // turnNotModular(turnBack);
                ApplyMoves(turnBack);

            }

            // Find Smallest cost value in openlist
            minimum = OpenListHead.cost; // Cost should never be more than this
            search = OpenListHead;

            int searchLength = 1;

            while (true) {

                if (search.cost <= minimum) {
                    current = search;
                    minimum = current.cost;
                }

                if (search == OpenListTail) {
                    break;
                }

                else {
                    search = search.next;
                }

            }

            search = OpenListHead;

            while (true) {

                if (search == current) {

                    if (current == OpenListHead) {
                        OpenListHead = OpenListHead.next;
                        OpenListHead.previous = null;

                        OpenLength--;
                        break;
                    }

                    else if (current == OpenListTail) {
                        OpenListTail = OpenListTail.previous;
                        OpenListTail.next = null;

                        OpenLength--;
                        break;
                    }

                    else {
                        Node tempNext = current.next;
                        Node tempPrevious = current.previous;

                        tempPrevious.next = tempNext;
                        tempNext.previous = tempPrevious;

                        OpenLength--;
                        break;
                    }

                }

                if (search.next == null) {
                    System.out.println("Something is going wrong");
                    break;
                }

                search = search.next;

            }

            if (ClosedLength == 1) {
                ClosedListHead.next = current;
                ClosedListTail = current;
                ClosedListTail.previous = ClosedListHead;

                ClosedLength++;

            }

            else {
                ClosedListTail.next = current;
                current.previous = ClosedListTail;
                ClosedListTail = current;

                ClosedLength++;
            }

            // Restart loop?

        }

        // Come up with move list to return back

        while (true) {

            moves = current.turn + moves;

            if (current.parent.turn == null) {
                break;
            }

            current = current.parent;
        }

        return moves;
    }

    public int getCost() {

        // ----- String for Pieces -----

        // String Template -> "NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN
        // NNN NNN NNN NNN";
        // Format White, Green, Red, Blue, Orange, Yellow

        String WhiteGreenOrangeCorner = "WNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNNNNNNNN";
        String WhiteBlueOrangeCorner = "NNWNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNONNNNNNNNNNNNNNNNN";
        String WhiteGreenRedCorner = "NNNNNNWNNNNGNNNNNNRNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteBlueRedCorner = "NNNNNNNNWNNNNNNNNNNNRNNNNNNBNNNNNNNNNNNNNNNNNNNNNNNNNN";

        String YellowGreenOrangeCorner = "NNNNNNNNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNYNN";
        String YellowBlueOrangeCorner = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNONNNNNNNNNNY";
        String YellowGreenRedCorner = "NNNNNNNNNNNNNNNNNGNNNNNNRNNNNNNNNNNNNNNNNNNNNYNNNNNNNN";
        String YellowBlueRedCorner = "NNNNNNNNNNNNNNNNNNNNNNNNNNRNNNNNNBNNNNNNNNNNNNNYNNNNNN";

        String WhiteRedEdge = "NNNNNNNWNNNNNNNNNNNRNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteGreenEdge = "NNNWNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteBlueEdge = "NNNNNWNNNNNNNNNNNNNNNNNNNNNNBNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteOrangeEdge = "NWNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNNNNNNNNN";

        String YellowRedEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNRNNNNNNNNNNNNNNNNNNNNYNNNNNNN";
        String YellowGreenEdge = "NNNNNNNNNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNN";
        String YellowBlueEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNNNNNNNNNNYNNN";
        String YellowOrangeEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNYN";

        String RedGreenEdge = "NNNNNNNNNNNNNNGNNNNNNRNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String RedBlueEdge = "NNNNNNNNNNNNNNNNNNNNNNNRNNNNNNBNNNNNNNNNNNNNNNNNNNNNNN";
        String OrangeGreenEdge = "NNNNNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNNNNN";
        String OrangeBlueEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNONNNNNNNNNNNNNN";

        String[] patterns = new String[20];

        patterns[0] = WhiteGreenOrangeCorner;
        patterns[1] = WhiteBlueOrangeCorner;
        patterns[2] = WhiteGreenRedCorner;
        patterns[3] = WhiteBlueRedCorner;

        patterns[4] = YellowGreenOrangeCorner;
        patterns[5] = YellowBlueOrangeCorner;
        patterns[6] = YellowGreenRedCorner;
        patterns[7] = YellowBlueRedCorner;

        patterns[8] = WhiteRedEdge;
        patterns[9] = WhiteGreenEdge;
        patterns[10] = WhiteBlueEdge;
        patterns[11] = WhiteOrangeEdge;

        patterns[12] = YellowRedEdge;
        patterns[13] = YellowGreenEdge;
        patterns[14] = YellowBlueEdge;
        patterns[15] = YellowOrangeEdge;

        patterns[16] = RedGreenEdge;
        patterns[17] = RedBlueEdge;
        patterns[18] = OrangeGreenEdge;
        patterns[19] = OrangeBlueEdge;

        // ----- End Piece Strings -----

        int movesTotal = 0;

        String tempMoves;

        for (int i = 0; i < patterns.length; ++i) {

            tempMoves = BiDirectionalTree(BlocktoString(), patterns[i]);

            if (tempMoves.equals("C")) {
                // Do Nothing
            }

            else {
                movesTotal = movesTotal + tempMoves.length();
            }
        }

        int Extracost = 0;

        String blocky = BlocktoString();

        // movesTotal = movesTotal + Extracost;

        for (int i = 0; i < blocky.length() - 2; ++i) {

            if (blocky.charAt(i) == blocky.charAt(i + 1)) {

                if (blocky.charAt(i) == blocky.charAt(i + 2)) {
                    // Do Nothing
                }

                else {
                    Extracost++;
                }

            }

            else {
                Extracost++;
            }

        }

        // return movesTotal + Extracost;
        return movesTotal;
    }

    public int getCostGroups() {

        // ----- String for Pieces -----

        // String Template -> "NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN NNN
        // NNN NNN NNN NNN";
        // Format White, Green, Red, Blue, Orange, Yellow

        String WhiteGreenOrangeCorner = "WNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNNNNNNNN";
        String WhiteBlueOrangeCorner = "NNWNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNONNNNNNNNNNNNNNNNN";
        String WhiteGreenRedCorner = "NNNNNNWNNNNGNNNNNNRNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteBlueRedCorner = "NNNNNNNNWNNNNNNNNNNNRNNNNNNBNNNNNNNNNNNNNNNNNNNNNNNNNN";

        String YellowGreenOrangeCorner = "NNNNNNNNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNYNN";
        String YellowBlueOrangeCorner = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNONNNNNNNNNNY";
        String YellowGreenRedCorner = "NNNNNNNNNNNNNNNNNGNNNNNNRNNNNNNNNNNNNNNNNNNNNYNNNNNNNN";
        String YellowBlueRedCorner = "NNNNNNNNNNNNNNNNNNNNNNNNNNRNNNNNNBNNNNNNNNNNNNNYNNNNNN";

        String WhiteRedEdge = "NNNNNNNWNNNNNNNNNNNRNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteGreenEdge = "NNNWNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteBlueEdge = "NNNNNWNNNNNNNNNNNNNNNNNNNNNNBNNNNNNNNNNNNNNNNNNNNNNNNN";
        String WhiteOrangeEdge = "NWNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNNNNNNNNN";

        String YellowRedEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNRNNNNNNNNNNNNNNNNNNNNYNNNNNNN";
        String YellowGreenEdge = "NNNNNNNNNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNYNNNNN";
        String YellowBlueEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNNNNNNNNNNYNNN";
        String YellowOrangeEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNYN";

        String RedGreenEdge = "NNNNNNNNNNNNNNGNNNNNNRNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
        String RedBlueEdge = "NNNNNNNNNNNNNNNNNNNNNNNRNNNNNNBNNNNNNNNNNNNNNNNNNNNNNN";
        String OrangeGreenEdge = "NNNNNNNNNNNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNONNNNNNNNNNNN";
        String OrangeBlueEdge = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNBNNNNNNONNNNNNNNNNNNNN";

        String[] patterns = new String[20];

        patterns[0] = WhiteGreenOrangeCorner;
        patterns[1] = WhiteBlueOrangeCorner;
        patterns[2] = WhiteGreenRedCorner;
        patterns[3] = WhiteBlueRedCorner;
        patterns[4] = YellowGreenOrangeCorner;
        patterns[5] = YellowBlueOrangeCorner;
        patterns[6] = YellowGreenRedCorner;
        patterns[7] = YellowBlueRedCorner;

        patterns[8] = WhiteRedEdge;
        patterns[9] = WhiteGreenEdge;
        patterns[10] = WhiteBlueEdge;
        patterns[11] = RedGreenEdge;
        patterns[12] = RedBlueEdge;
        patterns[13] = YellowRedEdge;

        patterns[14] = YellowBlueEdge;
        patterns[15] = YellowOrangeEdge;
        patterns[16] = YellowGreenEdge;
        patterns[17] = WhiteOrangeEdge;
        patterns[18] = OrangeGreenEdge;
        patterns[19] = OrangeBlueEdge;

        // ----- End Piece Strings -----

        int corners = 0;
        int RedEdges = 0;
        int OrangeEdges = 0;

        String tempMoves;

        for (int i = 0; i < 8; ++i) {

            tempMoves = BiDirectionalTree(BlocktoString(), patterns[i]);

            if (tempMoves.equals("C")) {
                // Do Nothing
            }

            else {
                corners = corners + tempMoves.length();
            }
        }

        for (int i = 8; i < 14; ++i) {

            tempMoves = BiDirectionalTree(BlocktoString(), patterns[i]);

            if (tempMoves.equals("C")) {
                // Do Nothing
            }

            else {
                RedEdges = RedEdges + tempMoves.length();
            }
        }

        for (int i = 14; i < 20; ++i) {

            tempMoves = BiDirectionalTree(BlocktoString(), patterns[i]);

            if (tempMoves.equals("C")) {
                // Do Nothing
            }

            else {
                OrangeEdges = OrangeEdges + tempMoves.length();
            }
        }

        if (corners > RedEdges) {
            if (corners > OrangeEdges) {
                return corners;
            }
        }

        if (RedEdges > OrangeEdges) {
            return RedEdges;
        }

        return OrangeEdges;
    }

}
