package orion.devel.service.services;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import orion.devel.calculator.generated.CalculatorWs;
import orion.devel.service.logger.Logger;

@WebService
@HandlerChain(file = "handler-chain.xml")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CalculatorImpl implements CalculatorWs {

	private static final Logger log = Logger.getLogger(CalculatorImpl.class);

	@Override
	@WebMethod
	public int multiply(@WebParam(name = "arg0") int arg0, @WebParam(name = "arg1") int arg1) {
		log.info("multiplying: {}, {}", arg0, arg1);
		return arg0 * arg1;
	}

	@Override
	@WebMethod
	public int sum(@WebParam(name = "arg0") int arg0, @WebParam(name = "arg1") int arg1) {
		log.info("summing: {}, {}", arg0, arg1);
		return arg0 + arg1;
	}

	@Override
	@WebMethod
	public int absolute(@WebParam(name = "arg0") int arg0) {
		log.info("absoluting: {}, {}", arg0);
		return Math.abs(arg0);
	}
}
