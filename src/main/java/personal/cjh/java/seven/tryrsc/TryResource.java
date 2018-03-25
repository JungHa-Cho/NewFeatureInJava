/*
 * Copyright (c) 2018. JeongHa, Cho
 */

package personal.cjh.java.seven.tryrsc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by cho_jeong_ha on 2018-03-25 오전 11:17
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
public class TryResource {
  /**
   * Try Resources Test.
   */
  public void test() {
    File file = new File("TryResourceTest.txt");

    try (FileInputStream fis = new FileInputStream(file);
         Reader reader = new InputStreamReader(fis, "utf-8");
         BufferedReader in = new BufferedReader(reader);
         FileOutputStream fos = new FileOutputStream(file)) {

      int chk;
      while ((chk = in.read()) >= 0) {
        System.out.print((char)chk);
      }

      fos.write("아웃풋 테스트".getBytes("UTF-8"));
      fos.flush();

      while ((chk = in.read()) >= 0) {
        System.out.print((char) chk);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
