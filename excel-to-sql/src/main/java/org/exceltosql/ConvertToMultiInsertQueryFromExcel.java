package org.exceltosql;

import static org.exceltosql.utils.Param.READ_PATH;
import static org.exceltosql.utils.Param.WRITE_PATH;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author : iyeong-gyo
 * @package : org.exceltosql
 * @since : 2023/08/05
 */
public class ConvertToMultiInsertQueryFromExcel {

  public static void main(String[] args) {
    try {
      FileInputStream excelFile = new FileInputStream(READ_PATH + "sample-data.xlsx");
      FileWriter fileWriter = new FileWriter(WRITE_PATH + LocalDateTime.now() + "-data.sql");

      Workbook workbook = WorkbookFactory.create(excelFile);
      Sheet datatypeSheet = workbook.getSheetAt(0);
      Iterator<Row> iterator = datatypeSheet.iterator();

      StringBuilder insertQuery = new StringBuilder("INSERT INTO your_table (");

      // 스키마 정보를 가져옴
      if (iterator.hasNext()) {
        Row currentRow = iterator.next();
        Iterator<Cell> cellIterator = currentRow.iterator();
        while (cellIterator.hasNext()) {
          Cell currentCell = cellIterator.next();
          insertQuery.append(currentCell.getStringCellValue());
          if (cellIterator.hasNext()) {
            insertQuery.append(", ");
          }
        }
        insertQuery.append(") VALUES ");
      }

      // 데이터 정보를 가져옴
      while (iterator.hasNext()) {
        insertQuery.append("(");
        Row currentRow = iterator.next();
        Iterator<Cell> cellIterator = currentRow.iterator();
        while (cellIterator.hasNext()) {
          Cell currentCell = cellIterator.next();
          if (currentCell.getCellType() == CellType.STRING) {
            insertQuery.append("'").append(currentCell.getStringCellValue()).append("'");
          } else if (currentCell.getCellType() == CellType.NUMERIC) {
            insertQuery.append(currentCell.getNumericCellValue());
          }
          if (cellIterator.hasNext()) {
            insertQuery.append(", ");
          }
        }
        insertQuery.append(")");
        if (iterator.hasNext()) {
          insertQuery.append(", ");
        }
      }

      fileWriter.write(insertQuery.toString());
      workbook.close();
      excelFile.close();

      System.out.println(insertQuery);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
