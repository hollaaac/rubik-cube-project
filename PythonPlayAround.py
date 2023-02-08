import math

class Node:
    def _init_(self, data = None,
              top = None, right = None, bottom = None, left = None):

        #Creates a single Node that can be tethered to other Nodes

        self.data = data
        self.top = top
        self.right = right
        self.bottom = bottom
        self.left = left

    def addNode(self, nextNode, position):
        if position == 1:
            self.top = nextNode
        elif position == 2:
            self.bottom == nextNode
        elif position == 3:
            self.right = nextNode
        else:
            self.left = nextNode

    def twistTop(self):
        return self.top

    def twistBottom(self):
        return self.bottom

    def twistRight(self):
        return self.right

    def twistLeft(self):
        return self.left

    def getData(self):
        return self.data


"""
class Cube:
    def _init_(self):

        #Initlizes a Cube that has six sides
        #Each face can access all the sides around it using the respective direction
        #Orientation of the Cube is that White is on top for the Secondary sides (Red, Blue, Orange, Green)
        #Orientation of the Cube is that Red is on top for the Primary sides (White and Yellow)
        
        #Each side's data value is a list with 9 elements (1, 2, 3, 4, 5, 6, 7, 8, 9)
        #With each cube face on the block numbered  {1, 2, 3} with the orientation in respect to the above orientations
        #                                           {4, 5, 6}
        #                                           {7, 8, 9}
        #So in the case of the BlueFace 1 would be the Red, Blue, and White Corner and 3 is Blue, Orange, and White corner on a solved Rubik's Cube

        #IN CASE OF EMERGENCY AND THINGS GO SOUTH 
        #If the Orientation doesn't work like that or too confusing can use 2 (might actually be 3) LinkedLists

        WhiteFace = Node(self, None, None, None, None, None)
        YellowFace = Node(self, None, None, None, None, None)
        RedFace = Node(self, None, None, None, None, None)
        OrangeFace = Node (self, None, None, None, None, None)
        GreenFace = Node(self, None, None, None, None, None)
        BlueFace = Node(self, None, None, None, None, None)
        
        WhiteFace.top = RedFace
        WhiteFace.bottom = OrangeFace
        WhiteFace.right = GreenFace
        WhiteFace.left = BlueFace

        YellowFace.top = OrangeFace
        YellowFace.bottom = RedFace
        YellowFace.right = GreenFace
        YellowFace.left = BlueFace

        RedFace.top = WhiteFace
        RedFace.bottom = YellowFace
        RedFace.right = BlueFace
        RedFace.left = GreenFace
        
        OrangeFace.top = WhiteFace
        OrangeFace.bottom = YellowFace
        OrangeFace.right = GreenFace
        OrangeFace.left = BlueFace

        GreenFace.top = WhiteFace
        GreenFace.bottom = YellowFace
        GreenFace.right = RedFace
        GreenFace.left = OrangeFace

        BlueFace.top = WhiteFace
        BlueFace.bottom = YellowFace
        BlueFace.right = OrangeFace
        BlueFace.left = RedFace

        RedFace.data = ["R", "R", "R", "R", "R", "R", "R", "R", "R"]
        OrangeFace.data = ["O", "O", "O", "O", "O", "O", "O", "O", "O"]
        WhiteFace.data = ["W", "W", "W", "W", "W", "W", "W", "W", "W"]
        YellowFace.data = ["Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y"]
        GreenFace.data = ["G", "G", "G", "G", "G", "G", "G", "G", "G"]
        BlueFace.data = ["B", "B", "B", "B", "B", "B", "B", "B", "B"]

    def getWhite(self):
        return self.


     
Rubik = Cube()




#Racket Class Playaround
pairs = [ [2, -7], [-4, -20], [7, 8], [-13, 2] ]       

total = 0;
for x in pairs:
    total = total + math.fabs(x[0] - x[1])
"""          

class linkedCube:
    def _init_(self):
        self.Front = None

#Setup of Cube

Cube = linkedCube()

WhiteFace = Node()
YellowFace = Node()
RedFace = Node()
OrangeFace = Node()
GreenFace = Node()
BlueFace = Node()

RedFace.top = WhiteFace
OrangeFace.top = WhiteFace
GreenFace.top = WhiteFace
BlueFace.top = WhiteFace

WhiteFace.top = RedFace
YellowFace.top = OrangeFace #Might be easier to have Red as top for both. WIll need to change all of Yellow/Whites directions as well

RedFace.bottom = YellowFace
OrangeFace.bottom = YellowFace
GreenFace.bottom = YellowFace
BlueFace.bottom = YellowFace

WhiteFace.bottom = OrangeFace
YellowFace.bottom = RedFace

RedFace.right = BlueFace
BlueFace.right = OrangeFace
OrangeFace.right = GreenFace
GreenFace.right = RedFace

WhiteFace.right = GreenFace
YellowFace.right = GreenFace

RedFace.left = GreenFace
GreenFace.left = OrangeFace
OrangeFace.left = BlueFace
BlueFace.left = RedFace

WhiteFace.left = BlueFace
YellowFace.Left = BlueFace

WhiteFace.data = ["W", "W", "W", "W", "W", "W", "W", "W", "W"]                      #The orientation is [1, 2, 3] for list [1, 2, 3, 4, 5, 6, 7, 8, 9] with the Face.top being 'above' the array
YellowFace.data = ["Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y"]                     #                   [4, 5, 6]
RedFace.data = ["R", "R", "R", "R", "R", "R", "R", "R", "R"]                        #                   [7, 8, 9]
OrangeFace.data = ["O", "O", "O", "O", "O", "O", "O", "O", "O"]                     # R = Red, O = Orange, G = Green, B = Blue, W = White, Y = Yellow
GreenFace.data = ["G", "G", "G", "G", "G", "G", "G", "G", "G"]
BlueFace.data = ["B", "B", "B", "B", "B", "B", "B", "B", "B"]

#End of Setup

print(WhiteFace.data) #WORKS!
print(WhiteFace.right.right.data)
