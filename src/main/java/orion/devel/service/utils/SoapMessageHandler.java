package orion.devel.service.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import orion.devel.service.logger.Logger;
import orion.devel.service.logger.RequestLogger;

public class SoapMessageHandler implements SOAPHandler<SOAPMessageContext> {

	private static final Logger log = Logger.getLogger(SoapMessageHandler.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			SOAPMessage soapMsg = context.getMessage();
			soapMsg.writeTo(out);
			String stringMsg = new String(out.toByteArray());
			String requestName = getRequestName(soapMsg);
			RequestLogger.logRequest(requestName, stringMsg);
		} catch (SOAPException e) {
			log.error("SOAP Exception raised: {}", e);
		} catch (IOException e) {
			log.error("IO Exception raised: {}", e);
		} catch (Exception e) {
			log.error("Exception raised: {}", e);
		}

		return true;
	}

	private String getRequestName(SOAPMessage soapMessage) throws SOAPException {
		Iterator<?> it = soapMessage.getSOAPBody().getChildElements();
		if (it.hasNext()) {
			String nodeName = ((Node) it.next()).getNodeName();
			if (nodeName.contains(":")) {
				nodeName = nodeName.split(":")[1];
			}
			return nodeName;
		}
		return "request";
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}