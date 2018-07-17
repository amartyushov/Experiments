package io.mart;

import java.io.*;

public class Try_with_resource {
	private static final int BUFFER_SIZE = 10;

	// resource have to implement AutoClosable

	static String firstLineOFFile(String path) throws IOException {

		// best way to close resources
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine(); // can throw exception - and you will see it!
		}
	}

	// readability!
	static void copy(String src, String dst) throws IOException {

		try (InputStream in = new FileInputStream(src);
		     OutputStream out = new FileOutputStream(dst)) {

			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0) {
				out.write(buf, 0, n);
			}
		}
	}
}
