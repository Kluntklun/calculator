package orion.devel.service.logger;

public class RequestLogger {

	private static Logger log = Logger.getLogger(RequestLogger.class);

	// private static final String DIRECTORY_PATH = "./log";
	// private static final SimpleDateFormat SDF_FILE_NAME = new
	// SimpleDateFormat("yyyy-dd-MM.HH-mm-ss");

	public static synchronized void logRequest(String requestName, String requestMsg) {
		log.info("logging incoming request with start: {}...",
				requestMsg.substring(0, Math.min(350, requestMsg.length())));
		// DataWriter dataWriter = new DataWriter();
		// dataWriter.init(getFolderPath(requestName),
		// generateFileName(requestName));
		// dataWriter.write(requestMsg);
		// dataWriter.close();
	}

	// private static String generateFileName(String requestName) {
	// return "req_" + SDF_FILE_NAME.format(new Date()) + "_" + requestName +
	// ".xml";
	// }

	// private static String getFolderPath(String requestName) {
	// return DIRECTORY_PATH + "/res";
	// }

}
