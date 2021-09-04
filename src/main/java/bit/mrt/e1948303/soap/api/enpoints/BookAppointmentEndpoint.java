package bit.mrt.e1948303.soap.api.enpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bit.mrt.e1948303.soap.api.contracts.BookAppointmentByE1948303Reponse;
import bit.mrt.e1948303.soap.api.contracts.CancelAppointmentRequest;
import bit.mrt.e1948303.soap.api.contracts.CancelAppointmentResponse;
import bit.mrt.e1948303.soap.api.contracts.QueryResponse;
import bit.mrt.e1948303.soap.api.services.AppointmentService;

@Endpoint
public class BookAppointmentEndpoint {

	private static final String NAMESPACE = "http://www.mrt.bit/e1948303/soap/api/contracts";

	@Autowired
	private AppointmentService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "BookAppointmentByE1948303Request")
	@ResponsePayload
	public BookAppointmentByE1948303Reponse bookAppointmentByE1948303() {
		return this.service.bookAppointmentByE1948303();
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "CancelAppointmentRequest")
	@ResponsePayload
	public CancelAppointmentResponse cancelAppointment(@RequestPayload CancelAppointmentRequest request) {
		return this.service.cancelAppointment(request.getReferenceNumber());
	}
	
	@PayloadRoot(namespace=NAMESPACE,localPart = "QueryRequest")
	@ResponsePayload
	public QueryResponse query() {
		return this.service.getAllAppointments();
	}

}
