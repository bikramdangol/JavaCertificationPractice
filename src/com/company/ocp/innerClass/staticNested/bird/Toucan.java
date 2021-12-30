package com.company.ocp.innerClass.staticNested.bird;

/**
 * Created by bikra on 11/28/2019 10:40 AM.
 */
public class Toucan {
    public static class Beak {
        public static int NUMBER = 100;
        public void makeSoundPublicly() {
            System.out.println("Making sound Publicly");
        }
        void makeSoundPackageWise() {
            System.out.println("Making sound PackageWise");
        }
        private void makeSoundPrivately() {
            System.out.println("Making sound Privately");
        }
    }
}
