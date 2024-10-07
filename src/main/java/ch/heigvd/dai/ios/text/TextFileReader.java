package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file byte per byte. It manages the
 * file reader properly with a try-catch-finally block.
 */
public class TextFileReader implements Readable {

  @Override
  public void read(String filename) {
    Reader reader = null;
    try {
      /* Open file */
      reader = new FileReader(filename, StandardCharsets.UTF_8);
      /* Read file */
      while ((reader.read()) != -1);
    } catch (IOException e) { System.out.println("Exception: " + e); }
    finally {
      /* Close file */
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {System.out.println("Exception: " + e);        }
      }
    }
  }
}
