package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file using a buffered reader around
 * a file reader. It manages the reader and the buffered reader properly with a try-with-resources
 * block.
 */
public class BufferedTextFileReader implements Readable {

  @Override
  public void read(String filename) {
    Reader reader = null;
    BufferedReader bufferedReader = null;
    try {
      /* Open file */
      reader = new FileReader(filename, StandardCharsets.UTF_8);
      bufferedReader = new BufferedReader(reader);
      /* Read file */
      while ((bufferedReader.read()) != -1) {};
    } catch (IOException e) { System.out.println("Exception: " + e); }
    finally {
      /* Close file */
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException e) { System.out.println("Exception: " + e); }
      }
    }
  }
}
