package YBtestData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    private XSSFWorkbook wb;
    private XSSFSheet sheet;

    public ReadExcelFile(String excelPath) {
        try {
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
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

    public int getRowCount(int sheetIndex) {
        return wb.getSheetAt(sheetIndex).getPhysicalNumberOfRows();
    }

    // New method to get header names
    public String[] getHeaders(int sheetIndex) {
        sheet = wb.getSheetAt(sheetIndex);
        int headerRow = 0; // Assuming the header is in the first row

        int columnCount = sheet.getRow(headerRow).getPhysicalNumberOfCells();
        String[] headers = new String[columnCount];

        for (int i = 0; i < columnCount; i++) {
            Cell cell = sheet.getRow(headerRow).getCell(i);
            if (cell != null) {
                headers[i] = cell.getStringCellValue();
            } else {
                headers[i] = "";
            }
        }

        return headers;
    }
}


