package readExcel;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * This class can import data from a specify sample excel
 * @author alex
 */
public class ReadExcel {

    public ReadExcel() {
    }

    private final List<String> dataFromExcels = new ArrayList<>();
    private String fileName;

    public List<String> getDataFromExcels() {
        return dataFromExcels;
    }

    public String getFileName() {
        return fileName;
    }
    
    

    public ReadExcel(String fileName) throws IOException {
        this.fileName = fileName;
        readData(fileName);

    }

    public void readData(String fileName) {
        List<List<XSSFCell>> sheetData = new ArrayList<>();
        List<XSSFCell> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName)) {

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {

                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                if (row.getRowNum() == 0) {
                    continue; //just skip the rows if row number is 0
                }

                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);

            }

            DataFormatter df = new DataFormatter();

            for (int i = 0; i < data.size(); i++) {
                dataFromExcels.add(df.formatCellValue(data.get(i)));
            }

            // Closing the workbook
            workbook.close();

        } catch (EncryptedDocumentException | IndexOutOfBoundsException | IOException e) {
          //  System.out.println("*"+e.getMessage());
        }
    }      
}
