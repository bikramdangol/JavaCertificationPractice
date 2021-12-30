package com.company.oca.interfaceAccess;

/**
 * Created by bikra on 4/19/2021 11:26 PM.
 */

public class Bird implements IFly, ISwim {

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean canSwim() {
        return false;
    }
}
