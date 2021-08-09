package com.rough;

import baseClasses.TestBase;
import org.testng.annotations.DataProvider;

public class DataProviderClass extends TestBase {

   /* @DataProvider(name = "myData")
    public Object[][] getData() {
        Object[][] data = new Object[2][3];
        data[0][0] = "Siddanth";
        data[0][1] = "sidd@email.com";
        data[0][2] = "Ukkali";
        data[1][0] = "Yazath";
        data[1][1] = "yaza@email.com";
        data[1][2] = "Ukkali";

        return data;
    }*/

    @DataProvider(name = "getData")
    public Object[][] getExcelData() {
        String sheetName = "data";
        int rows = execlReader.getRowNumber(sheetName);
        int cols = execlReader.getColumnNumber(sheetName, rows);



      Object[][] data= new Object[rows][cols];

        for(int i=1;i<=rows;i++){
            for(int j=0;j<cols;j++){
                data[i-1][j]=execlReader.getCellValue(sheetName,j,i);
            }
        }



        return data;
    }
}
