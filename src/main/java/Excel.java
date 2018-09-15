import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;

public class Excel {
    public void readExcel() throws Exception{

        File file= new File("C:\\selenium\\rupesh.xls");
        FileInputStream fis= new FileInputStream(file);
        Workbook wb= new HSSFWorkbook(fis);
        Sheet sheet=  wb.getSheetAt(0);
        int rowCount =sheet.getLastRowNum()-sheet.getFirstRowNum();
        for(int i=0;i<rowCount+1;i++){
            Row row= sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
//                    DataFormatter dt= new DataFormatter();
//                    System.out.print(" "+dt.formatCellValue(row.getCell(j)));
                System.out.print(row.getCell(j).getStringCellValue()+"|| ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        Excel ex= new Excel();
        ex.readExcel();

    }
}
