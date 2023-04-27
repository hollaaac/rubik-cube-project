package com.display;

import java.io.*;
import java.util.*;
import javafx.application.Application;


public class App{
    public static void main(String[] args) throws Exception {

        //Keep these lines. Lines will always be needed at some point

        //Application.launch(Display_App.class, args);
        //Block block = new Block(3);

        //----- Patterns -----

        //White Cross       -> NWN WWW NWN NGN NGN NNN NRN NRN NNN NBN NBN NNN NON NON NNN NNN NNN NNN
        String WhiteCross = "NWNWWWNWNNGNNGNNNNNRNNRNNNNNBNNBNNNNNONNONNNNNNNNNNNNN";

        //White Face        -> WWW WWW WWW GGG NGN NNN RRR NRN NNN BBB NBN NNN OOO NON NNN NNN NNN NNN
        String WhiteFace = "WWWWWWWWWGGGNGNNNNRRRNRNNNNBBBNBNNNNOOONONNNNNNNNNNNNN";

        //Second Layer      -> WWW WWW WWW GGG GGG NNN RRR RRR NNN BBB BBB NNN OOO OOO NNN NNN NNN NNN
        String SecondLayer = "WWWWWWWWWGGGGGGNNNRRRRRRNNNBBBBBBNNNOOOOOONNNNNNNNNNNN";

        //Yellow Cross      -> WWW WWW WWW GGG GGG NNN RRR RRR NNN BBB BBB NNN OOO OOO NNN NYN YYY NYN
        String YellowCross = "WWWWWWWWWGGGGGGNNNRRRRRRNNNBBBBBBNNNOOOOOONNNNYNYYYNYN";

        //Yellow Face       -> WWW WWW WWW GGG GGG NNN RRR RRR NNN BBB BBB NNN OOO OOO NNN YYY YYY YYY
        String YellowFace = "WWWWWWWWWGGGGGGNNNRRRRRRNNNBBBBBBNNNOOOOOONNNYYYYYYYYY";

        //Yellow Corners    -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BNB OOO OOO ONO YYY YYY YYY
        String YellowCorners = "WWWWWWWWWGGGGGGGNGRRRRRRRNRBBBBBBBNBOOOOOOONOYYYYYYYYY";
        
        //BlueFace Solved   -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO ONO YYY YYY YYY
        String BlueFaceSolved = "WWWWWWWWWGGGGGGGNGRRRRRRRNRBBBBBBBBBOOOOOOONOYYYYYYYYY";

        //GreenFace Solved  -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO ONO YYY YYY YYY
        String GreenFaceSolved = "WWWWWWWWWGGGGGGGGGRRRRRRRNRBBBBBBBNBOOOOOOONOYYYYYYYYY";

        //RedFace Solved    -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO ONO YYY YYY YYY
        String RedFaceSolved = "WWWWWWWWWGGGGGGGNGRRRRRRRRRBBBBBBBNBOOOOOOONOYYYYYYYYY";

        //OrangeFace Solved -> WWW WWW WWW GGG GGG GNG RRR RRR RNR BBB BBB BBB OOO OOO ONO YYY YYY YYY
        String OrangeFaceSolved = "WWWWWWWWWGGGGGGGNGRRRRRRRNRBBBBBBBNBOOOOOOOOOYYYYYYYYY";

        //Formatting in terminal. Yes it bothers me
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("----------Start----------");
        System.out.println("-------------------------");
        System.out.println("");  
        
        long startTime = System.currentTimeMillis();
        
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

        System.out.println((endtime - startTime) / 1000 + " seconds");

        //Formatting in terminal. Yes it Bothers me
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("-----------End-----------");
        System.out.println("-------------------------");
        System.out.println("");



    }

    
}
