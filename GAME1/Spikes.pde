class Spikes
{
  float spikeVY;

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
      spikeVY += -0.3;
    }
   
}
 
}
