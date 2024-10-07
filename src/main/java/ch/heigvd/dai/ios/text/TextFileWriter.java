package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation write the file byte per byte. It manages the
 * file writer properly with a try-catch-finally block.
 */
public class TextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    Writer write = null;
    try {
      /* Open file */
      write = new FileWriter(filename, StandardCharsets.UTF_8);
      /* Write file */
      for (int i = 0; i < sizeInBytes; i++) {
        write.write('a');
      }
    } catch (IOException e) { throw new RuntimeException(e); }
    /* Close file */
    if (write != null) {
      try {
        write.close();
      } catch (IOException e) { throw new RuntimeException(e); }
    }

  }
}
