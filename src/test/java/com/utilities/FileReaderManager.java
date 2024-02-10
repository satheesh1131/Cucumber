package com.utilities;

import java.io.IOException;

public class FileReaderManager {
	private FileReaderManager() {
	}
	public ConfigurationReader getCrInstance() throws IOException {
		return new ConfigurationReader();
	}
	public static FileReaderManager getInstance() {
		return new FileReaderManager();
	}

}
