package YBtestData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ReadExcelFile(String excelPath)
    {
        try{
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetnumber, int row, int column) {
        sheet = wb.getSheetAt(sheetnumber);
        Cell cell = sheet.getRow(row).getCell(column);

        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    // Format numeric value as a string without scientific notation
                    return String.format("%.0f", cell.getNumericCellValue());
                default:
                    // Handle other cell types if needed
                    return "";
            }
        } else {
            return "";
        }
    }

    public int getRowCount(int sheetIndex)
    {
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row = row+1;
        return row;

        }

    }

