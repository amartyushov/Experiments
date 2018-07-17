package io.mart;

import java.io.*;

public class Try_finally {

	private static final int BUFFER_SIZE = 10;

	// no longer the best practice to close resources
	static String firstLineOFFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine(); // can throw exception
		} finally {
			br.close();  // can throw exception. Will hide first exception
		}
	}

	// ugly when you have two resources to close
	static void copy(String src, String dst) throws IOException {
		InputStream in = new FileInputStream(src);
		try {
			OutputStream out = new FileOutputStream(dst);
			try {
				byte[] buf = new byte[BUFFER_SIZE];
				int n;
				while ((n = in.read(buf)) >= 0) {
					out.write(buf, 0, n);
				}
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
	}
}
