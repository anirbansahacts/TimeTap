package com.elams.leaveservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(InvalidLeaveRequestException.class)
    public ResponseEntity<String> handleInvalidLeave(InvalidLeaveRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
 
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOthers(Exception ex) {
        return ResponseEntity.internalServerError().body("Error: " + ex.getMessage());
    }
    
        @ExceptionHandler(LeaveNotFoundException.class)
        public ResponseEntity<String> handleLeaveNotFound(LeaveNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        
        @ExceptionHandler(InsufficientLeaveBalanceException.class)
        public ResponseEntity<String> handleInsufficientLeaveBalance(InsufficientLeaveBalanceException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
}