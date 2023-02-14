from asyncio.windows_events import NULL
import numpy as np                          #Using numpy arrays

class Cubelet:
    def __init__ (self, cords, colors):
        self.cords = cords                  #Should be an array of size 3 with cordinates (x, y, z) with the center cube being (0,0,0)
                                            #Standar orientation for xyz and the cube being positionged White = Top, Red = Front, Blue = Right
        self.colors = colors                #Shouws what color is facing what direction so (1, 1, 1) (Blue, White, Red) would be the top right corner
                                            #with the Red White and Blue piece in a solved cube
                                            #(Blue facing right, X axis) (White facing top, Y axis) (Red facing front, Z axis)
      
    def getColors(self):
        return self.colors

class Block:                                #Actual cube in 3x3x3 array with each index make of a cubelet

    def __init__ (self, size):
        self.size = size
        
        if((size % 2) == 0):
            self.thereZero = False         #On even sized cubes there is technically no center cube so coordinates go from -1 to 1
        else:
            self.thereZero = True          #On odd sized cubes there will be a center cube so cooredinates go from -1 to 0 to 1

        self.Block = np.array( [ [ [Cubelet(None, None) for x in range(size)] for y in range(size)] for z in range(size)], dtype = object)
        self.Block = np.arange(self.size * self.size * self.size).reshape(3, 3, 3)

        for x in range(size):
            for y in range(size):
                for z in range(size):
                    #print (self.Block[z][y][x].getColors()) DOES NOT WORK, NEED THIS TO WORK
                    #self.Block[z, y, x] = Cubelet([1, 1, 1], ["R", "W", "B"])
                    x = True #Just a placeholder, will need for changing cubelets information

    def printBlock(self):
        print (self.Block)

    def getPiece(self, x, y, z):
        return (self.Block[x, y, z])

size = 3
Cube = Block(size)

Cube.printBlock()
print (Cube.getPiece(1, 2, 2))


            



