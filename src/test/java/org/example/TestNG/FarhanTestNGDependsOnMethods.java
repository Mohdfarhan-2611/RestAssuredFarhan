package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FarhanTestNGDependsOnMethods {

    @Test
    public void launchBrowser(){
        System.out.println("Launching the browser");
        Assert.assertTrue(true);
    }



    @Test(dependsOnMethods = "launchBrowser", alwaysRun = true)
    public void aopenurl(){
        System.out.println("Opening the url");
        Assert.assertEquals(1, 1);
    }
}
