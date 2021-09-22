package Utils;

import Utils.ExcelUtils;

public class ExcelUtilscallingclass {

    ExcelUtils excelUtils;

    public static void main(String[] args) {
        String xlxsLocationpath = System.getProperty("user.dir");
        ExcelUtils excel = new ExcelUtils(xlxsLocationpath+"/excel/data.xlsx","sheet1");
        excel.getrowcount();
        excel.getcolcount(0);
        excel.getcellcountString(1,0);
        excel.getcellcountnumber(1,1);
    }
}
