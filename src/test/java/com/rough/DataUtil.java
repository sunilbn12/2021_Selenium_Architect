package com.rough;

import baseClasses.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataUtil {


    @Test(dataProviderClass = DataProviderClass.class,dataProvider = "getData",enabled = true)
    public void testDataProvider(String name,String email,String city){
        System.out.println("name is: "+name+" email is: "+email+" city is: "+city);
    }





    /*@DataProvider(name = "data")
    public Object[][] getData(){
        Object[][] data=new Object[2][3];
        data[0][0]="Siddanth";
        data[0][1]="sidd@email.com";
        data[0][2]="Ukkali";
        data[1][0]="Yazath";
        data[1][1]="yaza@email.com";
        data[1][2]="Ukkali";

         return data;
    }*/
}
