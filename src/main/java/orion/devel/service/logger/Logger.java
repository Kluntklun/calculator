package orion.devel.service.logger;

import org.slf4j.LoggerFactory;

public class Logger {

	private org.slf4j.Logger innerLogger;

	private Logger(Class<? extends Object> clazz) {
		this.innerLogger = LoggerFactory.getLogger(clazz);
	}

	public static Logger getLogger(Class<? extends Object> clazz) {
		return new Logger(clazz);
	}

	public void info(String msg, Object... params) {
		innerLogger.info(msg, params);
	}

	public void warn(String msg, Object... params) {
		innerLogger.warn(msg, params);
	}

	public void trace(String msg, Object... params) {
		innerLogger.trace(msg, params);
	}

	public void error(String msg, Object... params) {
		innerLogger.error(msg, params);
	}

	public void debug(String msg, Object... params) {
		innerLogger.debug(msg, params);
	}

}