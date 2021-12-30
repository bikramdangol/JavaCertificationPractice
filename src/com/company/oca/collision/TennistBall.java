package com.company.oca.collision;

/**
 * Created by bikra on 11/25/2019 11:24 AM.
 */
public class TennistBall extends AbstractBall {
    public int roll() {
        return 0;
    }

    // TODO: 1/25/2020
    public void playOtherGame() {
        VolleyBall volleyBall = new VolleyBall();
        volleyBall.play();
    }

    /***
     *
     */
    TennistBall() {

    }
    int x = 0;
}
