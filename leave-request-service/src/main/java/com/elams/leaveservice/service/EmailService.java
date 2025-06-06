//package com.elams.leaveservice.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
// 
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class EmailService {
//	 
//	    private final JavaMailSender mailSender;
//	 
//	    public void sendLeaveRequestEmail(String toEmail, String employeeId, String leaveType, String fromDate, String toDate) {
//	        SimpleMailMessage message = new SimpleMailMessage();
//	        message.setTo(toEmail);
//	        message.setSubject("New Leave Request from " + employeeId);
//	        message.setText("Employee ID: " + employeeId +
//	                        "\nLeave Type: " + leaveType +
//	                        "\nFrom: " + fromDate +
//	                        "\nTo: " + toDate +
//	                        "\n\nPlease review and take action in the system.");
//	 
//	        try {
//	            mailSender.send(message);
//	log.info("Leave request email sent to {}", toEmail);
//	        } catch (Exception ex) {
//	            log.error("Failed to send email: {}", ex.getMessage());
//	        }
//	    }
//	
//
//}
