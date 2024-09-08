package week4;

import java.io.*;

public class ReadFromFile {
	public static void main(String[] args) throws Exception {
		FileReader fis = new FileReader("./xyz.txt");//character based

		int c;

		while ((c = fis.read()) != -1) {
			System.out.print((char) c);
		}

		fis.close();
	}
}