package orion.devel.service.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DataWriter {

	private Logger log = Logger.getLogger(DataWriter.class);

	private Writer writer;

	public void init(String directoryPath, final String originalFileName) {
		try {

			File folder = new File(directoryPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}

			String checkedFileName = getAndCheckFileName(directoryPath, originalFileName);
			File file = new File(folder, checkedFileName);
			writer = new BufferedWriter(new FileWriter(file));

		} catch (IOException e) {
			log.error("IO Exception raised: ", e);
		}
	}

	private String getAndCheckFileName(String directoryPath, String originalFileName) {

		int index = 1;
		String fileName = originalFileName;

		while (new File(directoryPath, fileName).exists()) {
			int lastIndexOfDot = originalFileName.lastIndexOf('.');
			String modifiedFileName = originalFileName.substring(0, lastIndexOfDot) + "_" + index
					+ originalFileName.substring(lastIndexOfDot, originalFileName.length());
			log.warn("File '{}' already exists, fileName will be modified to '{}'", fileName, modifiedFileName);
			fileName = modifiedFileName;
			index += 1;
		}

		return fileName;
	}

	public void writeln(String data) {
		write(data + "\n");
	}

	public void write(String data) {
		if (writer != null) {
			try {
				writer.write(data);
			} catch (IOException e) {
				log.error("IOException raised while writing to file: ", e);
			}
		}
	}

	public void flush() {
		if (writer != null) {
			try {
				writer.flush();
			} catch (IOException e) {
				log.error("IO Exception raised while flushing to writer: ", e);
			}
		}
	}

	public void close() {
		flush();
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				log.error("IO Exception raised while closing writer: ", e);
			}
		}
	}

}
