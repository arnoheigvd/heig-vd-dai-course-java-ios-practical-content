package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation writes the file using a buffered writer
 * around a file writer. It manages the writer and the buffered writer properly with a
 * try-with-resources block.
 */
public class BufferedTextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    Writer write = null;
    BufferedWriter bufferedWriter = null;
    try {
      /* Open file */
      write = new FileWriter(filename, StandardCharsets.UTF_8);
      bufferedWriter = new BufferedWriter(write);
      /* Write file */
      for (int i = 0; i < sizeInBytes; i++) {
        bufferedWriter.write('a');
      }
    } catch (IOException e) { System.out.println("Exception: " + e); }
    finally {
      /* Close file */
      if (bufferedWriter != null) {
        try {
          bufferedWriter.flush();
          bufferedWriter.close();
        } catch (IOException e) { System.out.println("Exception: " + e); }
      }
    }
  }
}
