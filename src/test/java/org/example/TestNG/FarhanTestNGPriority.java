package org.example.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FarhanTestNGPriority {

    @Test(priority = 1)
    public void test01(){
        System.out.println("Test01");
        Assert.assertTrue(true);
    }


    @Test(priority = 3)
    public void test02(){
      SoftAssert softAssert = new SoftAssert();  //softAssertion
      softAssert.assertTrue(false);
      softAssert.assertEquals(1, 2);
      System.out.println("Test02");
      softAssert.assertAll();

    }


    @Test(priority = 2)
    public void test03(){
        //Assert.assertTrue(false);   //HardAssertion
        //Assert.assertEquals(1,2);
        System.out.println("Test03");


    }
}
