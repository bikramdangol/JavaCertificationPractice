package com.company.ocp.innerClass.staticNested.watcher;

import com.company.ocp.innerClass.staticNested.bird.Toucan;
import com.company.ocp.innerClass.staticNested.bird.Toucan.Beak;
// or static import.
import static com.company.ocp.innerClass.staticNested.bird.Toucan.Beak;

/**
 * Created by bikra on 11/28/2019 10:41 AM.
 */
public class BirdWatcher {
    Beak beak;

    public static void main(String[] args) {
        int unicode1 = 'a';
        int unicode2 = 'A';
        int unicode3 = '0';
        int unicode4 = 'क';
        int unicode5 = 'ख';
        System.out.println((char)unicode1 + " " + (char)unicode4 + " " + (char)unicode5);
        System.out.println(new BirdWatcher().beak.NUMBER);
        System.out.println(Beak.NUMBER);

        Toucan toucan = new Toucan();
        // Not allowed to create Static class object using object reference.
        // Beak beak3 = toucan.Beak();
        Beak beak1 = new Toucan.Beak();
        Toucan.Beak beak2 = new Beak();

        int x = beak1.NUMBER;
        beak1.makeSoundPublicly();



        class BeakSub extends Toucan.Beak {

        }
    }
}
