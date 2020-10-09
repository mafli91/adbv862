class Bars
{

  float vy5, a61, a63, a17;
  float [] a1 = new float[15];
  float [] a2 = new float[15];
  float [] a3 = new float[15];
  float [] vx = new float[15];
  float [] movingBar = new float [15];
  int bar;
  boolean pointScore = false;
  float point;
  float posx, posy, rad;
  boolean objectCollision;






  void Barzz()
  {

    barX();
    barUpDown();
    mouseBar();
    sideBar();

    // POS X 1
    for (bar = 0; bar<a1.length; bar++)  
    {
      a1[bar] = random (10, width-200);
    }
    // POS Y
    for (bar = 0; bar<a2.length; bar++)  
    {
      a2[bar] = 115 + (random (90, 130)*bar);
    }
    // POS X 2
    for (bar = 0; bar<a3.length; bar++)   
    {
      a3[bar] = random (70, 190);
    }
    // VELOCITY
    for (bar = 0; bar<vx.length; bar++)   
    {
      if (point >0)
      {
        float  p= point/4;
        vx[bar] = random (1 + p, 3 + p);
      } else 
      {
        vx[bar] = random (1, 4);
      }
    }
  }


  void barX()
  {
    stroke(0);
    strokeWeight(5);

    for ( int bar = 0; bar<6; bar++)
    {
      line (a1[bar], a2[bar], a3[bar] + a1[bar], a2[bar]);
      a1[bar] += vx[bar];
      if ( a1[bar] <0)
      {
        vx[bar] = -vx[bar];
      } else if ( a3[bar] + a1[bar] > width)
      {
        vx[bar] = -vx[bar];
      }
    }
  }

  void barUpDown()
  {

    line (a1[7], a17, a1[7] + a3[7], a17);
    a17 +=vx[7] ;
    if ( a17 < 100)
    {
      vx[7] = -vx[7];
    } else if ( a17 > height - 60)
    {
      vx[7] = -vx[7];
    }
  }
  void mouseBar()
  {

    line (a61, height - 60, a63, height - 60);
    a61 = mouseX ;
    a63 = mouseX + 40+ a3[8];
  } 


  void sideBar()
  {

    // LEFT
    stroke(0);
    strokeWeight(5);
    line(0, (height/4), a3[9], (height/4));
    noStroke();
    fill (244, 144, 17);
    ellipse(a3[9], (height/4), 40, 40);
    a3[9] += vx[9] ;
    if ( a3[9] > 195)
    {
      vx[9] = -vx[9];
    } else if ( a3[9] < 0)
    {
      vx[9] = -vx[9];
    }

    // RIGHT
    stroke(0);
    strokeWeight(5);
    line((width-a3[10]), 3*height/4, width, 3*height/4);
    noStroke();
    fill (244, 144, 17);
    ellipse((width-a3[10]), 3*height/4, 40, 40);
    a3[10] += vx[11] ;
    if ( (width-a3[10]) < (width -195) )
    {
      vx[11] = -vx[11];
    } else if ( (width-a3[10]) > width)
    {
      vx[11] = -vx[11];
    }
  }


  void collisionsTotal()
  {
    barCollision();
    mouseBarCollisions();
    sideBarCollisions();
  }



  void barCollision()
  {
    // COLLISION  UP DOWN
    if (posy-(rad/2) == a17 && posx + (rad/2) > a1[7] && posx-(rad/2)< a3[7] + a1[7])
    {
      objectCollision = true;              // for jump check 
      vy = 0;
      accy = 0;
      posy = a17 - (rad/2);
    }

    // COLLISION  SIDEWAYS BARS

    if (posy-(rad/2) == a2[bar] && posx + (rad/2) > a1[bar] && posx-(rad/2)< a3[bar] + a1[bar])
    {
      objectCollision = true;              // for jump check 
      vy = 0;
      accy = 0;
      posy = a2[bar] - (rad/2);
    }
  }

  void mouseBarCollisions()
  {
    // COLLISION
    if (posy-(rad/2) == height - 60 && posx + (rad/2) > a61 && posx-(rad/2)< a63)
    {
      objectCollision = true;              // for jump check 
      vy = 0;
      accy = 0;
      posy = height - 60 - (rad/2);
    }
  }


  void sideBarCollisions()
  {
    // COLLISION RIGHT
    if (posy-(rad/2) == (3*height/4) && posx + (rad/2) > (width-a3[10]) && posx-(rad/2)< width)
    {
      objectCollision = true;              // for jump check 
      vy = 0;
      accy = 0;
      posy = 3*height/4 - (rad/2);
    }  
    // COLLISION WITH BALL RIGHT
    if (posx + (rad/2) > a3[10]-20 && posx-(rad/2)< a3[10]+20)
    { 
      if (posy + (rad/2) > 3*height/4 + 20 || posy - (rad/2) < 3*height/4 - 20)
      {
        objectCollision = false;              // for jump check 
        accx = -2*accx;
        accy = -2*accy;
      }
    }
    // COLLISION LEFT
    if (posy-(rad/2) == (height/4) && posx + (rad/2) > 0 && posx-(rad/2)< a3[9])
    {
      objectCollision = true;              // for jump check 
      vy = 0;
      accy = 0;
      posy = height/4 - (rad/2);
    }
    // COLLISION WITH BALL LEFT
    if (posx + (rad/2) > a3[9]-20 && posx-(rad/2)< a3[9]+20)
    { 
      if (posy + (rad/2) > height/4 + 20 || posy - (rad/2) < height/4 - 20)
      {
        objectCollision = false;              // for jump check 
        accx = -2*accx;
        accy = -2*accy;
      }
    }
  }
}
