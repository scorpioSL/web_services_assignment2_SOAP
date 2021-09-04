package bit.mrt.e1948303.soap.api.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.mrt.e1948303.soap.api.contracts.BookAppointmentByE1948303Reponse;
import bit.mrt.e1948303.soap.api.contracts.BookAppointmentReponse;
import bit.mrt.e1948303.soap.api.contracts.CancelAppointmentResponse;
import bit.mrt.e1948303.soap.api.contracts.QueryResponse;
import bit.mrt.e1948303.soap.api.contracts.Appointment;
import bit.mrt.e1948303.soap.api.database.Database;

@Service
public class AppointmentService {

	@Autowired
	private Database database;

//	Adding appointment for the default student
	public BookAppointmentByE1948303Reponse bookAppointmentByE1948303() {

		BookAppointmentByE1948303Reponse response = new BookAppointmentByE1948303Reponse();

		Appointment existing = this.database.findByIndexNumber("e1948303");
		if (existing == null) {
			Appointment newAppointment = new Appointment();
			newAppointment.setId(database.getNextId());
			newAppointment.setReferenceNumber(database.generateReferenceNumber());
			newAppointment.setStudentIndexNumber("e1948303");
			newAppointment.setIsCanceled(false);
			this.database.addAppointment(newAppointment);
			response.setStatus("SUCCESS");
			response.setDescription(
					"Your appointment is successful. Reference number is " + newAppointment.getReferenceNumber());
			return response;
		}
		response.setStatus("FAIL");
		response.setDescription(
				"You already have an appointment. Reference number is " + existing.getReferenceNumber());
		return response;
	}

//	Adding appointment for the dynamic student
	public BookAppointmentReponse bookAppointment(String index_number) {

		BookAppointmentReponse response = new BookAppointmentReponse();
		Appointment existing = this.database.findByIndexNumber(index_number);
		if (existing == null) {
			Appointment newAppointment = new Appointment();
			newAppointment.setId(database.getNextId());
			newAppointment.setReferenceNumber(database.generateReferenceNumber());
			newAppointment.setStudentIndexNumber(index_number);
			newAppointment.setIsCanceled(false);
			this.database.addAppointment(newAppointment);
			response.setStatus("SUCCESS");
			response.setDescription(
					"Your appointment is successful. Reference number is " + newAppointment.getReferenceNumber());
			return response;
		}

		response.setStatus("FAIL");
		response.setDescription(
				"You already have an appointment. Reference number is " + existing.getReferenceNumber());
		return response;
	}

//	Retrieving all the appointments
	public QueryResponse getAllAppointments() {
		QueryResponse response = new QueryResponse();
		Collection<Appointment> collection = this.database.getAppointmentList();
		response.getResult().addAll(collection);
		return response;
	}

//	Cancel an appointment by reference number
	public CancelAppointmentResponse cancelAppointment(int reference_number) {
		CancelAppointmentResponse response = new CancelAppointmentResponse();
		response.setStatus(this.database.cancelAppointment(reference_number));
		return response;
	}

//	Remove an appointment by reference number
	public boolean removeAppointmentByReferenceNumber(int reference_number) {
		return this.database.removeAppointmentByReferenceNumber(reference_number);
	}

//	Remove an appointment by id
	public boolean removeAppointmentById(int id) {
		return this.database.removeAppointmentById(id);
	}
}
