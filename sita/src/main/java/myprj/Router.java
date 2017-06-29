package myprj;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;


public class Router {

	private static final Logger LOGGER = Logger.getLogger(Router.class);
	private static final String HEADER_FILE_NAME = "file_name";
	private static final String MSG_RECEIVED = "%s received. Content: %s";
	private static final String MSG_SENT = "File %s is sending to Chanel: %s";

	
	public String handleFile(Message<String> msg) {
		String fileName = (String) msg.getHeaders().get(HEADER_FILE_NAME);
		String content = msg.getPayload();
		LOGGER.debug(String.format(MSG_RECEIVED, fileName, content));
		String channel = fileContentValidation(content);
		LOGGER.info(String.format(MSG_SENT, fileName, channel));
		return channel;
	}


	public String fileContentValidation(String content) {
		String[] lines = content.split("\n");

		for (String line : lines) {

			if (line.matches("^-{0,1}\\d+$")) {
				content = "successChannel";
			}

			else {
				LOGGER.info("Invalid file");
				content = "failureChannel";
				break;
			}

		}

		return content;

	}
}
