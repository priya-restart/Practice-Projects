using System;

namespace ConsoleGame
{
  class Game : SuperGame
  {
  //update coordinates based on input
    public new static void UpdatePosition(string keyPressed, out int x, out int y)
        {
            //initialize the variables to zero
            x = 0;
            y = 0;

            switch(keyPressed)
            {
                case "UpArrow":
                    y -= 1;
                    break;

                case "DownArrow":
                    y += 1;
                    break;

                case "LeftArrow":
                    x -= 1;
                    break;

                case "RightArrow":
                    x += 1;
                    break;

            }
        }

       //change the player icon when key is pressed
       public new static char UpdateCursor(string keyPressed)
        {

            char direction = 'o'; // First we set a variable named direction 

            switch(keyPressed)
            {
                case "UpArrow":
                    direction = '^';
                    break;

                case "DownArrow":
                    direction = 'v';
                    break;

                case "LeftArrow":
                    direction = '<';
                    break;

                case "RightArrow":
                    direction = ('>');
                    break;
            }

            return direction; 
        }

        //handling boundary hits
        public new static int KeepInBounds(int coordinate, int maxValue)
        {
            

            if (coordinate > maxValue)
            {
                return 0; // If the player went to the left or top edge, send on the opposite side
            }
            else if (coordinate < 0)
            {
                return maxValue; // same
            }
            else
            {
                return coordinate; 
            }
        }


        //compare coordinates 
        public new static bool DidScore(int charX, int charY, int fruitX, int fruitY)
        {
            if(charX == fruitX && charY == fruitY)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
  }
}