package orion.devel.service.app;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import orion.devel.service.logger.Logger;

public class MainApp implements ServletContextListener {

	private static final Logger log = Logger.getLogger(MainApp.class);

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("Calculator SERVICE has started...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("Calculator SERVICE has ended...");
	}

}
