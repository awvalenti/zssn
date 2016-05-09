package com.github.awvalenti.zssn.main;

import java.io.IOException;

public class MainRunServer {

	public static void main(String[] args) throws IOException {
		TestHttpServer server = new TestHttpServer();
		try {
			server.start();
			System.out.println("Server started. Press any key to stop.");
			System.in.read();
		} finally {
			server.stop();
		}
	}

}
