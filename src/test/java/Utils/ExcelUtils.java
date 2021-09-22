package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public ExcelUtils(String xlxspath, String sheetname){
        try {
            workbook = new XSSFWorkbook(xlxspath);
            sheet = workbook.getSheet(sheetname);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getrowcount();
        getcolcount(0);
        getcellcountString(1,0);
        getcellcountnumber(1,1);
    }

    public static void getrowcount() {
        int rowcount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of row count is : " + rowcount);
    }

    public static void getcolcount(int rowNum) {
        int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Number of column count is : " + colcount);
    }

    public static void getcellcountString(int rowNum, int colNum) {
        String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        System.out.println("Username is : "+celldata);
    }

    public static void getcellcountnumber(int rowNum,int colNum) {
        double celldata1 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        System.out.println("Password is : "+celldata1);
    }
}

