import java.io.*;
import java.util.*;
import java.lang.Math;

public class Block {
    
    //Class Variables
    Cubelet[][][] Block;
    int size;
    boolean even;


    //Default Contructor that builds normal Rubik's cube
    public Block(){

        this(3); //Defaut 3v3 cube
    

    }

    //Constructor for given size
    public Block(int size){

        this.size = size;
        this.Block =  new Cubelet[size][size][size];

        Cubelet cubie = new Cubelet();

        int cordX = 0 - (size/2);
        int cordY = 0 - (size/2);
        int cordZ = 0 - (size/2);

        if((size%2) == 0){
            even = true;
        }

        else{
            even = false;
        }


        for (int x = 0; x < size; ++x){
            
            cordY = 0 - (size/2);

            for (int y = 0; y < size; ++y){

                cordZ = 0 - (size/2);

                for(int z = 0; z < size; ++z){

                    Block[x][y][z] = new Cubelet(new int[] {cordX, cordY, cordZ}, new char[] {cubie.colorFinder('x', cordX, size/2), cubie.colorFinder('y', cordY, size/2), cubie.colorFinder( 'z', cordZ, size/2) } );
                    
                    if(cordZ == -1 & even){
                        ++cordZ;
                    }

                    ++cordZ;

                }

                if(cordY == -1 & even){
                    ++cordY;
                }

                ++cordY;

            }

            if(cordX == -1 & even){
                ++cordX;
            }

            ++cordX;

        }


    }

    //Constructor given already built cube
    public Block(Cubelet[][][] Block){

        this.Block = Block;

    }

    //prints block info with cords and colors of cubelets
    void printer(){

        int countery = 0;
        int counterz = 0;

        for (int z = 0; z < size; ++z){

            for(int y = 0; y < size; ++y){

                for (int x = 0; x < size; ++x){

                    System.out.print("Array[" + x + "][" + y + "][" + z + "] = [" + Arrays.toString(Block[x][y][z].getCords()) + " [" + Block[x][y][z].getColors()[0]+ " " + Block[x][y][z].getColors()[1] + " " + Block[x][y][z].getColors()[2] + "]]" );
                    System.out.print("\t");
                    
                    ++counterz;
                    if(counterz == size){
                        System.out.println("");
                        counterz = 0;
                    }
                }

                ++countery;
                if(countery == size){
                    System.out.println("");
                    countery = 0;
                }
            }
        }
    }

    //Helper function that changes based on developer needs
    void printerHelp(){

        char [][] arrayHelper = new char[9][3];

        //for (int y = 0; y < this.size; y++){
        //    for (int z = 0; z < this.size; z++){
        //        System.out.println("Array [" + 2 + "] [" + y + "] [" + z + "] -> " + this.Block[2][y][z].getColors()[0] + ", " + Block[2][y][z].getColors()[1] + ", " + Block[2][y][z].getColors()[2]);
        //        //Block[0][y][z].colorSwap('x');
        //        //System.out.println("Array [" + 0 + "] [" + y + "] [" + z + "] -> " + this.Block[0][y][z].getColors()[0] + ", " + Block[0][y][z].getColors()[1] + ", " + Block[0][y][z].getColors()[2]);
        //    }
        //}

        System.out.println(""); //Space in terminal

        for (int x = 0; x < this.size; x++){
            for (int z = 0; z < this.size; z++){
                System.out.println("Array [" + x + "] [" + 2 + "] [" + z + "] -> " + this.Block[x][2][z].getColors()[0] + ", " + Block[x][0][z].getColors()[1] + ", " + Block[x][0][z].getColors()[2]);
            }
        }

    }

    void turnNotModular(String direction){
         
        Cubelet tempCubelet;

        if(direction == "L"){ //Left ClockWise

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

            for(int y = 0; y < size; ++y){
                for(int z = 0; z < size; ++z){
                    Block[0][y][z].colorSwap('x');
                }
            }
                
        }

        if(direction == "L'"){ //Left Counter-ClockWise

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

            for(int y = 0; y < size; ++y){
                for(int z = 0; z < size; ++z){
                    Block[0][y][z].colorSwap('x');
                }
            }

        }

        if(direction == "R"){ //Left Counter-ClockWise

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

            for(int y = 0; y < size; ++y){
                for(int z = 0; z < size; ++z){
                    Block[2][y][z].colorSwap('x');
                }
            }

        }

        if(direction == "R'"){ //Left ClockWise

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

            for(int y = 0; y < size; ++y){
                for(int z = 0; z < size; ++z){
                    Block[2][y][z].colorSwap('x');
                }
            }
                
        }

        if(direction == "F"){ //Left ClockWise

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

            for(int y = 0; y < size; ++y){
                for(int z = 0; z < size; ++z){
                    Block[0][y][z].colorSwap('x');
                }
            }
                
        }
        
    }

}


