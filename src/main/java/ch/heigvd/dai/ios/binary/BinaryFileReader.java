package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * A class that reads binary files. This implementation reads the file byte per byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    /* Opening binary file */
    InputStream fis = null;
    try {
      fis = new FileInputStream(filename);
      int b;
      /* Reading file */
      while ((b = fis.read()) != -1) ;
    } catch (IOException e) { throw new RuntimeException(e); }
    /* Closing binary file */
    if (fis != null) {
      try {
        fis.close();
      } catch (IOException e) { e.printStackTrace(); }
    }
  }
}
