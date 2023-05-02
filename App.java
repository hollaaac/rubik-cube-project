package com.display;

//import java.io.*;
//import java.util.*;
//import javafx.application.Application;


public class App{
    public static void main(String[] args) throws Exception {

        //Keep these lines. Lines will always be needed at some point

        //Application.launch(Display_App.class, args);
        //Block block = new Block(3);

        //----------------------------
        //BiDirectional Search. WORKS!
        //----------------------------

        /*  long startTime = System.currentTimeMillis();
        
        Block block = new Block(3);

        String Finished = block.BlocktoString();

        block.ApplyMoves("RlFRlF");

        System.out.println("Start");
        block.printBlock();
        System.out.println("");

        String moves = block.BiDiSearch(block.BlocktoString(), WhiteCross);
        block.ApplyMoves(moves);

        System.out.println(moves);
        block.printBlock();
        System.out.println("");

        moves = block.BiDiSearch(block.BlocktoString(), WhiteFace);
        block.ApplyMoves(moves);
        

        System.out.println(moves);
        block.printBlock();
        System.out.println("");

        moves = block.BiDiSearch(block.BlocktoString(), SecondLayer);
        block.ApplyMoves(moves);

        System.out.println(moves);
        block.printBlock();
        System.out.println("");

        moves = block.BiDiSearch(block.BlocktoString(), YellowCross);
        block.ApplyMoves(moves);

        System.out.println(moves);
        block.printBlock();
        System.out.println("");

        moves = block.BiDiSearch(block.BlocktoString(), YellowFace);
        block.ApplyMoves(moves);

        System.out.println(moves);
        block.printBlock();
        System.out.println("");

        moves = block.BiDiSearch(block.BlocktoString(), YellowCorners);
        block.ApplyMoves(moves);

        System.out.println(moves);
        block.printBlock();
        System.out.println("");

        boolean skip = false;

        if(block.compareCubeStrings(block.BlocktoString(), BlueFaceSolved) == 51){
            skip = true;
        }

        if(block.compareCubeStrings(block.BlocktoString(), GreenFaceSolved) == 51){
            skip = true;
        }

        if(block.compareCubeStrings(block.BlocktoString(), RedFaceSolved) == 51){
            skip = true;
        }

        if(block.compareCubeStrings(block.BlocktoString(), OrangeFaceSolved) == 51){
            skip = true;
        }

        if(skip == false){

            moves = block.BiDiSearch(block.BlocktoString(), BlueFaceSolved);
            block.ApplyMoves(moves);

            System.out.println(moves);
            block.printBlock();
            System.out.println("");
        }

        moves = block.BiDiSearch(block.BlocktoString(), Finished);
        block.ApplyMoves(moves);

        System.out.println(moves);
        block.printBlock();
        System.out.println("");

        long endtime = System.currentTimeMillis();

        System.out.println((endtime - startTime) / 1000 + " seconds"); */

        //----------------------------
        //BiDirectional Search. WORKS!
        //----------------------------

        //Formatting in terminal. Yes it bothers me
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("----------Start----------");
        System.out.println("-------------------------");
        System.out.println("");  

        Block block = new Block(3);

        //block.randomizeCube(40);
        block.ApplyMoves("RlFRlF");

        block.printBlock();
        System.out.println("");

        //block.ApplyMoves("rDrdrdrDRDRR");

        block.ApplyMoves(block.BiDiSearch());

        block.printBlock();
       

        //Formatting in terminal. Yes it Bothers me
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("-----------End-----------");
        System.out.println("-------------------------");
        System.out.println("");



    }

    
}
