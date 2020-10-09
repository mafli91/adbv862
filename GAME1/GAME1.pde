float posx = width/2; 
float posy = 550;         // START POS
float vx = 0;
float vy = 0;             // CURRENT VELOCITY
float accx = 0;
float accy = 0;           // ACCELERATION
float rad = 20;           // BALL SIZE
float pline = 750;        // LINE PLACEMENT
boolean objectCollision;  // CHECKS JUMPS, add to every object to bounce off
float nBalls = 20;
boolean[] keys= { false, false }; // BOOLEAN ARRAY FOR KEY PRESSED to add keys
// value of keys in order 1, 2, 3, ...
float spikeVY;
float theta;                // back spin angle
int angle1 = -15;           // back spin angle
int a;                      // amount of background noise
boolean dead = false;
int pointNO, pointNOtrue;
boolean pointScore = false;
float [] alpha = new float [30];
float [] pointX = new float[30];
float [] pointY = new float[30];
float vy5, a61, a63, a17;
float [] a1 = new float[15];
float [] a2 = new float[15];
float [] a3 = new float[15];
float [] vx1 = new float[15];
float [] movingBar = new float [15];
int bar;
float point, redP, blueP, greenP;

import processing.sound.*;
SoundFile yum, deaddead, up, upss;
Background[] background1;
//Bars barz;                   IN CASE PREFER TO USE CLASSES
//Gamee gamee;
//Spikes spikez;


void setup ()
{
  size(600, 800);
  a = (height/120)*(width/120);    // a = 2;  // TO SLOW DOWN
  backSetup();
  pointNOtrue = 0;
  a17 = 30;
  yum = new SoundFile(this, "yum.mp3");
  up = new SoundFile(this, "up.mp3");
  upss = new SoundFile(this, "upss.mp3");
  deaddead = new SoundFile(this, "deaddead.mp3");
}

void draw()
{
  allSetting();

  if (!dead)
  {
    game();
  } else
    gameOverYES();
}

void game()
{
  gamePhysics();
  ball();
  collisions();
  points();
}

void allSetting()
{
  background(230, 250, 236, 00);
  bubTriDraw();
  objects();
}

void objects()
{
  // PUT ALL OBJECT CLASSES AND SHELVES HERE
  bottomLine();
  spikes();
  barX();
  barUpDown();
  mouseBar();
  sideBar();
}

void barX()
{
  stroke(0);
  strokeWeight(5);


    line (a1[0], a2[0], a3[0] + a1[0], a2[0]);
    a1[0] += vx1[0];
    if ( a1[0] <0)
    {
      vx1[0] = -vx1[0];
    } else if ( a3[0] + a1[0] > width)
    {
      vx1[0] = -vx1[0];
    }
  
  
  // COLLISION  SIDEWAYS BARS

  if (posy-(rad/2) <= a2[0] && posy+(rad/2) >= a2[0] )
  {
    if(posx + (rad/2) > a1[0] && posx-(rad/2)< a3[0] + a1[0])
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = a2[0] - (rad/2);
  }
  }
      line (a1[1], a2[1], a3[1] + a1[1], a2[1]);
    a1[1] += vx1[1];
    if ( a1[1] <0)
    {
      vx1[1] = -vx1[1];
    } else if ( a3[1] + a1[1] > width)
    {
      vx1[1] = -vx1[1];
    }
  
  
  // COLLISION  SIDEWAYS BARS

  if (posy-(rad/2) <= a2[1] && posy+(rad/2) >= a2[1] )
  {
    if(posx + (rad/2) > a1[1] && posx-(rad/2)< a3[1] + a1[1])
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = a2[1] - (rad/2);
  }
  }
      line (a1[2], a2[2], a3[2] + a1[2], a2[2]);
    a1[2] += vx1[2];
    if ( a1[2] <0)
    {
      vx1[2] = -vx1[2];
    } else if ( a3[2] + a1[2] > width)
    {
      vx1[2] = -vx1[2];
    }
  
  
  // COLLISION  SIDEWAYS BARS

  if (posy-(rad/2) <= a2[2] && posy+(rad/2) >= a2[2] )
  {
    if(posx + (rad/2) > a1[2] && posx-(rad/2)< a3[2] + a1[2])
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = a2[2] - (rad/2);
  }
  }
      line (a1[3], a2[3], a3[3] + a1[3], a2[3]);
    a1[3] += vx1[3];
    if ( a1[3] <0)
    {
      vx1[3] = -vx1[3];
    } else if ( a3[3] + a1[3] > width)
    {
      vx1[3] = -vx1[3];
    }
  
  
  // COLLISION  SIDEWAYS BARS

  if (posy-(rad/2) <= a2[3] && posy+(rad/2) >= a2[3] )
  {
    if(posx + (rad/2) > a1[3] && posx-(rad/2)< a3[3] + a1[3])
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = a2[3] - (rad/2);
  }
  }
      line (a1[4], a2[4], a3[4] + a1[4], a2[4]);
    a1[4] += vx1[4];
    if ( a1[4] <0)
    {
      vx1[4] = -vx1[4];
    } else if ( a3[4] + a1[4] > width)
    {
      vx1[4] = -vx1[4];
    }
  
  
  // COLLISION  SIDEWAYS BARS

  if (posy-(rad/2) <= a2[4] && posy+(rad/2) >= a2[4] )
  {
    if(posx + (rad/2) > a1[4] && posx-(rad/2)< a3[4] + a1[4])
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = a2[4] - (rad/2);
  }
  }
}

void barUpDown()
{

  line (a1[7], a17+30, a1[7] + a3[7], a17+30);
  a17 += vx1[7] ;
  if ( a17 < 30)
  {
    vx1[7] = -vx1[7];
  } else if ( a17 > height - 60)
  {
    vx1[7] = -vx1[7];
  }
  
  if (posy-(rad/2) <= a17 && posy+(rad/2) >= a17-10 && posx + (rad/2) > a1[7] && posx-(rad/2)< a3[7] + a1[7])
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = a17 + (rad/2);
  }
}

void mouseBar()
{

  line (a61, height - 110, a63, height - 110);
  a61 = mouseX ;
  a63 = mouseX + 40+ a3[8];
  
    // COLLISION
  if (posy-(rad/2) <= height - 110 && posy + (rad/2) >= height - 100 && posx + (rad/2) > a61 && posx-(rad/2)< a63)
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = height - 110 - (rad/2);
  }
  
} 


void sideBar()
{

  /*// LEFT
  stroke(0);
  strokeWeight(5);
  line(0, (height/4), a3[9], (height/4));
  noStroke();
  fill (244, 144, 17);
  ellipse(a3[9], (height/4), 40, 40);
  a3[9] += vx1[9] ;
  if ( a3[9] > 195)
  {
    vx1[9] = -vx1[9];
  } else if ( a3[9] < 0)
  {
    vx1[9] = -vx1[9];
  } */

  // RIGHT
  stroke(0);
  strokeWeight(5);
  line((width-a3[10]), 3*height/4, width, 3*height/4);
  noStroke();
  fill (244, 144, 17);
  ellipse((width-a3[10]), 3*height/4, 40, 40);
  a3[10] += vx1[11] ;
  if ( (width-a3[10]) < (width -195) )
  {
    vx1[11] = -vx1[11];
  } else if ( (width-a3[10]) > width)
  {
    vx1[11] = -vx1[11];
  }
  // COLLISION RIGHT
  if (posy-(rad/2) >= (3*height/4)-2 && posy-(rad/2) <= (3*height/4)+2 && posx + (rad/2) > (width-a3[10]) && posx-(rad/2)< width)
  {
    objectCollision = true;              // for jump check 
    vy = -vy*0.5;
    accy = 0;
    posy = (3*height/4 )- (rad/2) - 2;
  }  
  // COLLISION WITH BALL RIGHT
  if (posx + (rad/2) >= width-a3[10]-10 && posx-(rad/2) <= width-a3[10]+10)
  { 
    if (posy + (rad/2) > 3*height/4 - 10 || posy - (rad/2) < 3*height/4 + 10)
    {
      objectCollision = false;              // for jump check 
      accx = 0;
      accy = 0;
      vy = -vy ;
    }
  }
  /*// COLLISION LEFT
  if (posy-(rad/2) <= (height/4) && posy+(rad/2) >= (height/4) && posx + (rad/2) < 0 && posx-(rad/2)> a3[9])
  {
    objectCollision = true;              // for jump check 
    vy = 0;
    accy = 0;
    posy = height/4 - (rad/2);
  }
  // COLLISION WITH BALL LEFT
  if (posx + (rad/2) > a3[9]-10 && posx-(rad/2)< a3[9]+10)
  { 
    if (posy + (rad/2) > height/4 + 10 || posy - (rad/2) < height/4 - 10)
    {
      objectCollision = false;              // for jump check 
      accx = 0;
      accy = 0;
      vy=-vy;
    }
  }  */
}  

void spikes()
{

  for (int spike = 0; spike<width/12; spike++)
  {
    fill(255);
    triangle (0+(12*spike), height-1+spikeVY, 6+(12*spike), height-16+spikeVY, 12+(12*spike), height-1+spikeVY);
    rect(0+(12*spike), height-1+spikeVY, 12+(12*spike), height);
  }
  if (frameCount/60 >= 5  && frameCount/60 <= 9)
  { 
    spikeVY += -0.15;
  }

  if (posy >= height-16+spikeVY)
  {
    dead = true;
    stroke(144, 15, 15, 200);
    strokeWeight(6);
    line (posx-12, posy+10, posx-2, posy + 30);
    line (posx-7, posy+10, posx-7, posy + 32);
    line (posx-2, posy+10, posx-2, posy + 40);
    line (posx+3, posy+10, posx+3, posy + 36);
    line (posx+7, posy+10, posx+7, posy + 32);
    line (posx+11, posy+10, posx+11, posy + 26);
    textSize(15);
    textAlign(CENTER);
    fill(144, 15, 15);
    text("......... ughwwAwpss", posx + 5, posy- 10);
    upss.play();
  }
}

void points()                  // POINTS TO COLLECT
{
  noStroke();
  fill (redP, greenP, blueP, alpha[pointNOtrue]);
  ellipse(pointX[pointNOtrue], pointY[pointNOtrue], 30, 30);
  println("POINTS : " + pointNOtrue + " !!!");
  if (posx+rad/2 > pointX[pointNOtrue]-15 && posx-rad/2 < pointX[pointNOtrue]+15)
  {
    if (posy+rad/2 > pointY[pointNOtrue]-15 && posy-rad/2 < pointY[pointNOtrue]+15)
    {
      pointScore = true;
      pointNOtrue++;
      yum.play();
    }
  }
}


void bottomLine()
{
  stroke(0);
  strokeWeight(5);
  line (0, pline, width, pline);
}


void ball()                      // JUMPING HERO
{
  noStroke();
  fill(255, 0, 255);
  ellipse(posx, posy, rad, rad);
}

void collisions()                // STORE ALL COLLISIONS
{
  leftWall();

  rightWall();

  lineStop();

  ceiling();
}

void leftWall()
{
  if (posx<rad/2)    // LEFT WALL STOPS
  { 
    vx = 0;
    posx = rad/2;
    accx = 0;
  }
}

void rightWall()
{
  if (posx>width-(rad/2))    //RIGHT WALL STOPS
  {
    vx = 0;
    posx = width-(rad/2);
    accx = 0;
  }
}

void ceiling()
{
  if (posy < 0)     // TOP STOPS
  {
    vx = 0;
    vy = 0;
    posy = rad/2;
  }
}

void lineStop()
{
  if ( posy+(rad/2) > pline) 
  {
    objectCollision = true;              // for jump check 
    vy = 0;
    accy = 0;
    posy = pline - rad/2;
  }
}

void gamePhysics()                        // MOVE AND JUMP
{
  accy = 0.35;        // ALWAYS FALLING 

  vx = vx + accx;    // TO ADD MOVEMENT
  vy = vy + accy;
  posx = posx + vx;
  posy = posy + vy;
  accx = 0;

  keyResponse();
}

void keyResponse()
{
  if (keys[0] == true)  //acc to left
  {
    accx = accx - 0.35;
  } else
  {
  }//do nothing

  if (keys[1] == true)  // acc to right
  {
    accx = accx +0.35;
  }
}

void keyPressed() {
  if ( key == 'a' ) {
    keys[0] = true;
  }
  if ( key == 'd' ) {
    keys[1] = true;
  }
  if ( key == 'w' && objectCollision == true) 
  {
    vy = -10;
    up.play();
    objectCollision = false;
  }
}

void keyReleased() {
  if ( key == 'a' ) {
    keys[0] = false;
  }
  if ( key == 'd' ) {
    keys[1] = false;
  }
}

void backSetup()
{

  redP= random(255);
  blueP= random(255);
  greenP=random(255);
  
  

  background1 = new Background[a];
  for (int i=0; i<background1.length; i++)
  {
    background1[i] = new Background();
    background1[i].redT = random (200);
    background1[i].greenT = random (200);
    background1[i].blueT = random (200);
    background1[i].setup1();
    background1[i].r = random(30, 70);

    if ( i%2 == 0)
    {
      background1[i].placeX = (random (25, 160));
      background1[i].placeY = 40 + (random(32, 38)* i);
    }
    if ( i%2 == 1)
    {
      background1[i].placeX = random (180, 390);
      background1[i].placeY = -50 + (random(30, 35)* i);
    }
    if ( i%3 == 1)
    {
      background1[i].placeX = random ( 430, 570);
      background1[i].placeY = 40 + (random(32, 38)* i);
    }
  }
  
    for (pointNO = 0; pointNO <alpha.length; pointNO++)
  {
    alpha[pointNO] = 255 * ((pointNO+1) - pointNOtrue);
  }
  for (pointNO = 0; pointNO <pointX.length; pointNO++)
  {
    pointX[pointNO] = random (40, width-40);
  }
  for (pointNO = 0; pointNO <pointY.length; pointNO++)
  {
    pointY[pointNO] = random (30, height-250);
  }
  
  
  
  // POS X 1
  for (bar = 0; bar<a1.length; bar++)  
  {
    a1[bar] = random (10, width-200);
  }
  // POS Y
  for (bar = 0; bar<a2.length; bar++)  
  {
    a2[bar] = 115 + ((random (90, 130)*bar));
  }
  // POS X 2
  for (bar = 0; bar<a3.length; bar++)   
  {
    a3[bar] = random (70, 190);
  }
  // VELOCITY
  for (bar = 0; bar<vx1.length; bar++)   
  {
    if (point >0)
    {
      float  p= point/4;
      vx1[bar] = random (1 + p, 3 + p);
    } else 
    {
      vx1[bar] = random (1, 4);
    }
  }
  
  
}

void bubTriDraw()
{

  for (int i=0; i<background1.length; i++)
  {
    background1[i].back1();
  }
}  


void gameOverYES()
{
  fill (167, 76, 152, 150);
  rect (5, 5, width-10, height-10);
  textSize(45);
  fill(76, 167, 138);
  textMode(CENTER);
  text("NO MORE KILLING.", width/2, height/2);
  deaddead.play();
}
