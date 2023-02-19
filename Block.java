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

        new Block(3); //Defaut 3v3 cube

    }

    //Constructor for given size
    public Block(int size){

        this.size = size;
        Block =  new Cubelet[size][size][size];

        boolean even;
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

                    Block[x][y][z] = new Cubelet(new int[] {cordX, cordY, cordZ}, new char[] {cubie.colorFinder('x', cordX), cubie.colorFinder('y', cordY), cubie.colorFinder( 'z', cordZ) } );
                    
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
                ++x;
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

                    System.out.print("[" + Arrays.toString(this.Block[x][y][z].getCords()) + " [" + Block[x][y][z].getColors()[0]+ " " + Block[x][y][z].getColors()[1] + " " + Block[x][y][z].getColors()[2] + "]]" );
                    System.out.print("\t");
                    
                    ++counterz;
                    if(counterz == size){
                        System.out.println("");
                        counterz = 0;
                    }
                }

                ++countery;
                if(countery == 3){
                    System.out.println("");
                    countery = 0;
                }
            }
        }
    }
}

