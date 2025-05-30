package org.example.TestNG;

import org.testng.annotations.Test;

public class FarhanEnabledTestNG {


    @Test(enabled = true)
    public void enableTest(){
        System.out.println("Enabled True");
    }

    @Test(enabled = false)
    public void enableFalse(){
        System.out.println("Enabled True");
    }
}
