import java.io.*;
import java.util.*;

public class Cubelet {
    
    //Class Variables
    int[] cords;
    char[] colors;

    //Default Constructor
    public Cubelet(){

        //cords will return null if not initialized later
        colors = new char[] {'N', 'N', 'N'};

    }

    //Cnstructor with pre-set cords and colors back
    public Cubelet(int[] cords, char[] colors){

        this.cords = cords;
        this.colors = colors;

    }

    //Printer Method
    void printer(){

        System.out.println(Arrays.toString(this.cords) + "   " + this.colors[0] + this.colors[1] + this.colors[2]);
    }

    int[] getCords(){

        return cords;

    }

    char[] getColors(){

        return colors;

    }

    //Returns the starting colors for each axis/face
    //DO NOT USE after building the cube unless looking for initial color of side
    public char colorFinder(char axis, int depth){

        if(axis == 'x'){

           if(depth > 0){return 'B';}
           if(depth < 0){return 'G';}

        }

        if(axis == 'y'){

            if(depth > 0){return 'Y';}
            if(depth < 0){return 'W';}

        }

        if(axis == 'z'){

            if(depth > 0){return 'R';}
            if(depth < 0){return 'O';}

        }

        return 'N'; //Nothing so color is "iniside of a cube. Pieces with only one color are center pieces"
    }
}

