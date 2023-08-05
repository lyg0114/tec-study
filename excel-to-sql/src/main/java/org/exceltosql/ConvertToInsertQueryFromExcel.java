package org.exceltosql;

import static org.exceltosql.utils.Param.READ_PATH;
import static org.exceltosql.utils.Param.WRITE_PATH;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author : iyeong-gyo
 * @package : org.exceltosql
 * @since : 2023/08/05
 */
public class ConvertToInsertQueryFromExcel {

  public static void main(String[] args) throws IOException {
    FileInputStream consumerExcelFile
        = new FileInputStream(READ_PATH + "excel/sample-consumerinfo.xlsx");
    FileWriter consumerFileWriter
        = new FileWriter(WRITE_PATH + LocalDateTime.now() + "-multi-consumerinfo.sql");
    String consumerTable = "v_consumer_info";
    createSQL(consumerExcelFile, consumerFileWriter, consumerTable);

    FileInputStream meterDailyExcelFile
        = new FileInputStream(READ_PATH + "excel/sample-meterdaily.xlsx");
    FileWriter meterDailyFileWriter
        = new FileWriter(WRITE_PATH + LocalDateTime.now() + "-multi-meterdaily.sql");
    String meterdailyTable = "meterdaily";
    createSQL(meterDailyExcelFile, meterDailyFileWriter, meterdailyTable);
  }

  private static void createSQL(
      FileInputStream excelFile, FileWriter fileWriter, String tableName
  ) {
    try {
      Workbook workbook = WorkbookFactory.create(excelFile);
      Sheet sheet = workbook.getSheetAt(0);
      Iterator<Row> rowIterator = sheet.iterator();

      // 첫번째 행에서 스키마 정보를 가져옴
      Row schemaRow = rowIterator.next();
      Iterator<Cell> schemaIterator = schemaRow.cellIterator();
      StringBuilder schema = new StringBuilder();
      while (schemaIterator.hasNext()) {
        Cell cell = schemaIterator.next();
        schema.append(cell.getStringCellValue());
        if (schemaIterator.hasNext()) {
          schema.append(", ");
        }
      }

      // 데이터 행 처리
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        StringBuilder values = new StringBuilder("VALUES (");

        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          if (cell.getCellType() == CellType.STRING) {
            values
                .append("'")
                .append(cell.getStringCellValue())
                .append("'");
          } else if (cell.getCellType() == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
              SimpleDateFormat dateFormat;
              if (cell.getColumnIndex() == 1) {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
              } else {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
              }
              values.append("'").append(dateFormat.format(cell.getDateCellValue())).append("'");
            } else {
              values.append(cell.getNumericCellValue());
            }
          }

          if (cellIterator.hasNext()) {
            values.append(", ");
          }
        }

        String sql = "INSERT INTO " + tableName + " (" + schema + ") " + values + ");";
        fileWriter.write(sql + "\n");
      }

      fileWriter.close();
      excelFile.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}