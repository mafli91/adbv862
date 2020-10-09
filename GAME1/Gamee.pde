class Gamee   // ORDER THINGS
{

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
  
  int pointNO, pointNOtrue;
  boolean pointScore = false;
  float [] alpha = new float [30];
  float [] pointX = new float[30];
  float [] pointY = new float[30];

  void game()
  {
    gamePhysics();
    ball();
    collisions();
  }

  void allSetting()
  {
    background(230, 250, 236, 00);
    objects();
  }
  
  void gameForSetup()
  {
    pointNOtrue = 0;
  
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
  }
  
    void points()
  {

    noStroke();
    fill (0, 0, 0, alpha[pointNOtrue]);
    ellipse(pointX[pointNOtrue], pointY[pointNOtrue], 30, 30);
  }
  
  void pointsTouched()
  {
    if (posx+rad/2 > pointX[pointNOtrue]-15 && posx-rad/2 < pointX[pointNOtrue]+15)
    {
      if (posy+rad/2 > pointY[pointNOtrue]-15 && posy-rad/2 < pointY[pointNOtrue]+15)
      {
        pointScore = true;
        pointNOtrue++;
      }
    }
  }
  

  void objects()
  {
    // PUT ALL OBJECT CLASSES AND SHELVES HERE
    bottomLine();
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
    accy = 0.4;        // ALWAYS FALLING 

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
      accx = accx - 0.4;
    } else
    {
    }//do nothing

    if (keys[1] == true)  // acc to right
    {
      accx = accx +0.4;
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
      vy = -12;
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
}
