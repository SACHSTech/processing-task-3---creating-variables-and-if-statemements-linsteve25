import processing.core.PApplet;
import processing.core.PFont;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class Sketch extends PApplet {

  /**
   * Randomized Drawing of Car
   * @linsteve25
   */

  // Define variable
  int intRandomWidth;
  int intRandomHeight;

  int intColorR;
  int intColorG;
  int intColorB;

  boolean blnQuadrantC;
  boolean blnNotQuadrantC;
  
  public void settings() {

	// size call 
  size(400, 400);

  // Random x and y coordinate 
  intRandomWidth = (int) random(width);
  intRandomHeight = (int) random(height);
  
  }

  public void setup() {

    // Initial background and stroke
    background(81, 201, 245);
    stroke(18, 18 ,18);

    // change color of background and car corresponding to each quadrant

    blnQuadrantC = !(intRandomWidth <= 400 / 2) || !(intRandomHeight >= 400 / 2);
    blnNotQuadrantC = !(blnQuadrantC);

    if ((intRandomWidth <= 400 / 2) && (intRandomHeight <= 400 /2)) {

      background(50, 168, 68);
      intColorR = 242;
      intColorG = 131;
      intColorB = 227;
    }
    
    else if ((intRandomWidth >= 400 / 2) && (intRandomHeight >= 400 / 2)) {

      background(245, 197, 66);
      intColorR = 83;
      intColorG = 144;
      intColorB = 207;
    }

    else if (blnNotQuadrantC) {

      background(108, 53, 166);
      intColorR = 32;
      intColorG = 77;
      intColorB = 16;
    }

    else {

      background(81, 201, 245);
      intColorR = 255;
      intColorG = 0;
      intColorB = 0;
    }
  }

  public void draw() {
	  
  // print the window of the car
  fill(intColorR, intColorG, intColorB);
  ellipse(intRandomWidth + 155, intRandomHeight - 2, 180, 145);
  fill(92, 237, 225);
  ellipse(intRandomWidth + 155, intRandomHeight + 5, 150, 130);
  line(intRandomWidth + 190, intRandomHeight, intRandomWidth + 190, intRandomHeight + 51);
  line(intRandomWidth + 176, intRandomHeight, intRandomWidth + 176, intRandomHeight - 57);

  // print rectangle body of the car
  fill(intColorR, intColorG, intColorB);
  rect(intRandomWidth, intRandomHeight, 265, 75, 30);

  // print wheels of the car
  fill(0);
  circle(intRandomWidth + 50, intRandomHeight + 75, 60);
  circle(intRandomWidth + 215, intRandomHeight + 75, 60);

  // print headlights
  fill(230, 226, 37);
  rect(intRandomWidth, intRandomHeight + 15, 25, 25, 55);

  // print doorhandles 
  fill(0);
  rect(intRandomWidth + 160, intRandomHeight + 15, 30, 10, 10);
  
  // print door
  line(intRandomWidth + 176, intRandomHeight, intRandomWidth + 176, intRandomHeight + 75);
  line(intRandomWidth + 81, intRandomHeight, intRandomWidth + 80, intRandomHeight + 75);

  // print current time
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
  textSize(20);
  text("" + LocalDateTime.now().format(formatter), 170, 390);
  }
}