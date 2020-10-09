class Grid {
  /* int numCols;
  int numRows;
  ArrayList<Background>[][] grid;

  Grid() {
    numCols = int(sqrt(nBalls) + 0.5);
    numRows = numCols;
    
    // array with empty borders to simplify the logic;
    grid = new ArrayList[numCols+2][numRows+2];

    // initialize each grid as an empty list
    for (int k = 0; k < numCols+2; k = k+1)
    {
      for (int l = 0; l < numRows+2; l = l+1)
      {
        grid[k][l] = new ArrayList();
      }
    }
  }

  // Show the grid
  void draw()
  {
    stroke(0);
    for (int k = 1; k < numCols; k = k+1)
    {
      int x = k*width/numCols;
      line(x, 0, x, height);
    }
    for (int l = 1; l < numRows; l = l+1)
    {
      int y = l*height/numRows;
      line(0, y, width, y);
    }
  }

  void checkCollisions()
  {
    // empty grid
    for (int k = 1; k <= numCols; k = k+1)
    {
      for (int l = 1; l <= numRows; l = l+1)
      {
        grid[k][l].clear();
      }
    }
    
    // add balls to grid
    for (Background ball : background1)
    {
      int x = getStrip(position.x / width, numCols);
      int y = getStrip(ball.y / height, numRows);
      grid[x][y].add(ball);
    }

    // look for collisions with neighbours
    for (int k = 1; k <= numCols; k = k+1)
    {
      for (int l = 1; l <= numRows; l = l+1)
      {
        for (Ball ball : grid[k][l])
        {
          checkLocalCollisions(ball, grid[k-1][l-1]);
          checkLocalCollisions(ball, grid[k-1][l];
          checkLocalCollisions(ball, grid[k-1][l+1]);
          checkLocalCollisions(ball, grid[k][l-1]);
          checkLocalCollisions(ball, grid[k][l]);
          checkLocalCollisions(ball, grid[k][l+1]);
        }
      }
    }
  }

  void checkLocalCollisions(Ball ball, ArrayList<Ball> neighbours)
  {
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

  // The cell (1..count) corresponding to a fractional window position
  int getStrip(float frac, int count)
  {
    int k;
    k = int(frac * count) + 1;
    // ensure it is in range
    if (k < 1)
    {
      k = 1;
    } else if (k > count)
    {
      k = count;
    }
    return k;
  } */
}
