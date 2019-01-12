import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class RoadSimulator_v1 extends PApplet {

int LENGTH = 10;
int UNIT = 20;
int currentX = 0;
int currentY = 0;
float distance = 0;
int beforeX;
int beforeY;
boolean isModifyMode = false; //false= Red line, true= Blue line(for diagonal)
String lines = "Length per Unit: "+LENGTH+"\n"+"Current position: ("+currentX+", "+currentY+")\nDistance: "+distance+"\n";

public void setup() {
  reset();
   // 20+LENGTH*UNIT, 20+LENGTH*UNIT+100
  
  frameRate(30);
  textSize(13);
  textLeading(13);
  background(255);
  
  fill(255);
  rect(LENGTH, LENGTH, LENGTH*UNIT, LENGTH*UNIT);
  fill(0);
  lining();
  fill(255,0,0);
  stroke(255,0,0);
  ellipse(currentX+10, currentY+10, 2, 2);
  
  fill(0);
  text(lines, 10, 20+LENGTH*UNIT+5);
  fill(255,0,0);
  
  if (isModifyMode) { //Blue line(for diagonal)
      stroke(0,0,255);
      fill(0,0,255);
    } else {            //Red line
      stroke(255,0,0);
      fill(255,0,0);
    }
  ellipse(2,2,2,2);
}

public void lining(){
  int i = LENGTH;
  for(i = 20; i <= LENGTH*UNIT; i+=LENGTH){
    line(10,i,LENGTH*UNIT+10,i);
    line(i,10,i,LENGTH*UNIT+10);
  }
}

public void showInfo() {
  fill(0);
  textSize(13);
  textLeading(13);
  text(lines, 10, 20+LENGTH*UNIT+5);
}

public void statsRefresh(){
  fill(255);
  stroke(255);
  rect(10,10+LENGTH*UNIT+5,LENGTH*UNIT,50);
  fill(0);
  lines = "Length per Unit: "+LENGTH+"\n"+"Current position: ("+currentX+", "+currentY+")\nDistance: "+distance+"\n";
  text(lines, 10, 20+LENGTH*UNIT+5);
}

public void draw() {
  //keyPressed();
  
}

public void keyPressed() {
  if (key == CODED && !(key == ENTER || key == RETURN)) { // Arrow Key Pressed
    fill(255,0,0);
    strokeWeight(3);
    if (keyCode == SHIFT) {
      isModifyMode = !(isModifyMode);
      if(isModifyMode) { // blue line(diagonal)
        beforeX = currentX+10;
        beforeY = currentY+10;
        stroke(0,0,255);
        fill(0,0,255);
      } else {            // red line
        distance += sqrt(pow(currentX+10-beforeX,2)+pow(currentY+10-beforeY,2));
        stroke(255,0,0);
        fill(255,0,0);
        line(beforeX, beforeY, currentX+10, currentY+10);
      }
    }
    if (isModifyMode) { //Blue line(for diagonal)
      stroke(0,0,255);
      fill(0,0,255);
    } else {            //Red line
      stroke(255,0,0);
      fill(255,0,0);
    }
    ellipse(2,2,2,2);
    if (keyCode == DOWN && currentY+10 <= LENGTH*UNIT) { // Down Arrow pressed
      line(currentX+10, currentY+10, currentX+10, currentY+10+LENGTH);
      redraw();
      currentY += LENGTH;
      if (!isModifyMode) distance += LENGTH;
    } else if (keyCode == RIGHT && currentX+10 <= LENGTH*UNIT) { // Right Arrow pressed
      line(currentX+10, currentY+10, currentX+10+LENGTH, currentY+10);
      redraw();
      currentX += LENGTH;
      if (!isModifyMode) distance += LENGTH;
    }
    
    
    
  //Refresh stats
  statsRefresh();
  redraw();
  } else if (key == ENTER || key == RETURN) {
    setup();
  }
}

public void reset(){
  LENGTH = 10;
  UNIT = 20;
  currentX = 0;
  currentY = 0;
  distance = 0;
  beforeX = 10;
  beforeY = 10;
  lines = "Length per Unit: "+LENGTH+"\n"+"Current position: ("+currentX+", "+currentY+")\nDistance: "+distance+"\n";
  fill(255);
  rect(0,0,220,320);
  stroke(0);
  strokeWeight(1);
}
  public void settings() {  size(220, 320);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "RoadSimulator_v1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
