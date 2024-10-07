package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A class that writes binary files. This implementation writes the file using a buffered output
 * stream. It manages the file output stream properly with a try-with-resources block.
 */
public class BufferedBinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    /* Opening binary file */
    OutputStream fos = null;
    BufferedOutputStream bos = null;
    try {
      fos = new FileOutputStream(filename);
      bos = new BufferedOutputStream(fos);
      /* Writing binary file */
      for (int i = 0; i < sizeInBytes; i++) {
        bos.write(i);
      }
    } catch (IOException e) { throw new RuntimeException(e); }
    /* Closing binary file*/
    if (fos != null) {
      try {
        bos.flush();
        bos.close();
      } catch (IOException e) { throw new RuntimeException(e); }
    }
  }
}
