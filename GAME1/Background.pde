class Background
{

  float x1, y1, x2, y2, x3, y3;        //triangle1
  float xa1, ya1, xa2, ya2, xa3, ya3;
  float redT, blueT, greenT;
  float placeX, placeY;
  float r ;

  PVector position;                // BALLS
  PVector velocity;    
  float radius, radiuss;  



  Bubbles[] bubbles;
  Ball[] balls;

  void back1()
  {
    theta += 0.001;
    xa1 = r * cos(theta);
    ya1 = r * sin(theta);
    x1= (xa1+placeX);
    y1= (ya1+placeY);
    xa2 = r * cos(theta+radians(120));
    ya2 = r * sin(theta+radians(120));
    x2= (xa2+placeX);
    y2= (ya2+placeY);
    xa3 = r * cos(theta+radians(240));
    ya3 = r * sin(theta+radians(240));
    x3= (xa3+placeX);
    y3= (ya3+placeY);

    noStroke();
    fill(redT, blueT, greenT, 45);
    triangle(x1, y1, x2, y2, x3, y3);

    for (int j=0; j<bubbles.length; j++)
    {
      bubbles[j].bubbles();
    }
    for (int i=0; i < balls.length; i=i+1)
    {
      balls[i].draw();
      balls[i].move();
    }
  }

  void setup1()
  {
    bubbles = new Bubbles[5];
    for (int j=0; j<bubbles.length; j++)
    {
      bubbles[j] = new Bubbles();
      bubbles[j].b = 7*j;
      bubbles[j].angle = (j+1) * (angle1);
      bubbles[j].red = random (200);
      bubbles[j].green = random (200);
      bubbles[j].blue = random (200);
      bubbles[j].size = 5-j;
    }

    balls = new Ball[3];
    for (int i=0; i<balls.length; i = i+1)
    {
      balls[i] = new Ball();
    }
  }

  // SUBCLASS BUBBLES??


  class Bubbles 
  {
    float xb1, yb1, xb2, yb2, xb3, yb3;    // bubbles
    float x11, y11, x22, y22, x33, y33;
    float b, angle;
    float red, green, blue;
    float size;



    void bubbles()
    {
      fill(red, green, blue, 40);
      bubble1();
      bubble2();
      bubble3();
    }


    void bubble1()
    {
      xb1 = (r + b) * cos(theta + radians(0+angle));
      yb1 = (r + b) * sin(theta + radians(0+angle));
      x11= (xb1+placeX);
      y11= (yb1+placeY);

      noStroke();
      ellipse (x11, y11, r/15*size, r/15*size);
    }

    void bubble2()
    {
      xb2 = (r + b) * cos(theta+radians(120+ angle));
      yb2 = (r + b) * sin(theta+radians(120+ angle));
      x22= (xb2+placeX);
      y22= (yb2+placeY);

      noStroke();
      ellipse (x22, y22, r/15*size, r/15*size);
    }

    void bubble3()
    {
      xb3 = (r + b) * cos(theta+radians(240+ angle));
      yb3 = (r + b) * sin(theta+radians(240 + angle));
      x33= (xb3+placeX);
      y33= (yb3+placeY);

      noStroke();
      ellipse (x33, y33, r/15*size, r/15*size);
    }
  }
  // SUBCLASS BALLZ

  class Ball 
  {


    Ball()  
    { 
      position = new PVector(random(width), random(height));
      velocity = new PVector(random(-1, 1), random(-1, 1));
      radius = 10;
    }
    void draw()  
    {
      noStroke();
      fill(redT, blueT, greenT, 15);
      ellipse(position.x, position.y, radius*2, radius*2);
    }

    void move()
    {
      position.x = position.x + velocity.x;
      position.y = position.y + velocity.y;

      if (position.x - radius < 0 && velocity.x < 0 )
      {
        velocity.x = -1*velocity.x;
      } else if (position.x + radius > width && velocity.x > 0)
      {
        velocity.x = -1*velocity.x;
      }

      if (position.y - radius < 0 && velocity.y < 0)
      {
        velocity.y = -1*velocity.y;
      } else if (position.y + radius > height && velocity.y > 0 )
      {
        velocity.y = -1*velocity.y;
      }
    }
  }
}
