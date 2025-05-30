package org.example.TestNG;

import org.testng.annotations.Test;

public class FarhanTestNGInvocationCount {

    int i=1;

    @Test(invocationCount = 5)
    public void invocationcount(){
        System.out.println("print "+ i +" times");
        i++;
    }
}
