package org.example.TestNG;

import org.testng.annotations.Test;

public class FarhanTestNGGrouping {

    @Test(groups = {"sanity","regression"})
    public void getmethod1(){
        System.out.println("method1");
    }

    @Test(groups = {"sanity"})
    public void getmethod2(){
        System.out.println("method2");
    }


    @Test(groups = {"regression"})
    public void getmethod3(){
        System.out.println("method3");
    }
}
