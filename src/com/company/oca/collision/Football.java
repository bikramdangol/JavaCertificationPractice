package com.company.oca.collision;

/**
 * Created by bikra on 11/25/2019 11:05 AM.
 */
public class Football extends AbstractBall { //implements Rollable{

    public int roll() {
        return 0;
    }

   /* public void roll() {
        System.out.println("Rolling ball.");;
    }*/


   public void playOtherGame() {
       VolleyBall volleyBall = new VolleyBall();
       volleyBall.play();

       GolfBall golfBall = new GolfBall();
       golfBall.play();
       System.out.println("The golfBall price is: " + golfBall.price);
   }

    private class GolfBall {
       private int price = 5;
        private void play() {
            System.out.println("playing Golf privately.");
        }
    }
}

class VolleyBall {
    void play() {
        System.out.println("playing volleyball.");
    }
}
