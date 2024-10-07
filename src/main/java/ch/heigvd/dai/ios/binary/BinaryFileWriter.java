package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * A class that writes binary files. This implementation writes the file byte per byte. It manages
 * the file output stream properly with a try-catch-finally block.
 */
public class BinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    /* Opening binary file */
    OutputStream os = null;
    try {
      os = new FileOutputStream(filename);
      /* Writing binary file */
      for (int i = 0; i < sizeInBytes; i++) {
        os.write(i);
      }
    } catch (IOException e) { throw new RuntimeException(e); }
    /* Closing binary file*/
    if (os != null) {
      try {
        os.close();
      } catch (IOException e) { throw new RuntimeException(e); }
    }
  }
}
