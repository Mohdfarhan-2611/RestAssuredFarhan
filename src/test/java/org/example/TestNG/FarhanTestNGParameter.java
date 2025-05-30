package org.example.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FarhanTestNGParameter {

    @Parameters("browser")
    @Test
    public void openBrowser(String value) {
        System.out.println("Browser is "+value);
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start chrome");
        }
        if (value.equalsIgnoreCase("firefox")){
            System.out.println("Start firefox");
        }
    }
}
