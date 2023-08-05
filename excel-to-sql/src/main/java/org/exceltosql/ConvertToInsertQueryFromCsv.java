package org.exceltosql;

import static org.exceltosql.utils.Param.READ_PATH;
import static org.exceltosql.utils.Param.WRITE_PATH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author : iyeong-gyo
 * @package : org.exceltosql
 * @since : 2023/08/05
 */
public class ConvertToInsertQueryFromCsv {
  public static void main(String[] args) throws IOException {
    String csvFile = READ_PATH + "sample-data.csv";

    String line;
    String cvsSplitBy = ",";
    StringBuilder insertQuery = new StringBuilder("INSERT INTO meterdaily");
    FileWriter fileWriter = new FileWriter(WRITE_PATH + LocalDateTime.now() + "-multi-data.sql");

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      boolean isFirstLine = true;
      while ((line = br.readLine()) != null) {
        String[] columns = line.split(cvsSplitBy);

        if (isFirstLine) {
          insertQuery.append(
                  Arrays.toString(columns)
                      .replace("[", "(")
                      .replace("]", ")"))
              .append(" VALUES\n");
          isFirstLine = false;
        } else {
          insertQuery.append(
              Arrays.toString(columns)
                  .replace("[", "(")
                  .replace("]", ")"));
          if (br.ready()) {
            insertQuery.append(",\n");
          }
        }
      }

      System.out.println(insertQuery.toString());
      fileWriter.write(insertQuery + "\n");
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}