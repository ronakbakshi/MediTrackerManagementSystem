/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s524975
 */
public class Appointment {
    public String doctorName;
    public String hospitalName;
    public String appDate;
    public String appTime;
    public String status;
    public String patientName;
    public int appointmentID;

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public Appointment(int appointmentID, String patientName, String appDate, String appTime, String status) {
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.appDate = appDate;
        this.appTime = appTime;
        this.status = status;
    }

    public Appointment(int appointmentID, String doctorName, String hospitalName, String appDate, String appTime, String status) {
        this.appointmentID = appointmentID;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.appDate = appDate;
        this.appTime = appTime;
        this.status = status;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getAppDate() {
        return appDate;
    }

    public String getAppTime() {
        return appTime;
    }

    public String getStatus() {
        return status;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
