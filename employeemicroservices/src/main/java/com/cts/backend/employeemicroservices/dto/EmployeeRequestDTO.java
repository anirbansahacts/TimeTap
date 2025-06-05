package com.cts.backend.employeemicroservices.dto;

import jakarta.validation.constraints.NotNull;

public class EmployeeRequestDTO {
    @NotNull
    private String employeeName;
    @NotNull
    private String gender;
    @NotNull
    private String email;
    @NotNull
    private Long contact;
    private int managerId;
    @NotNull
    private String role;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeRequestDTO{" +
                "employeeName='" + employeeName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", contact=" + contact +
                ", managerId=" + managerId +
                ", role='" + role + '\'' +
                '}';
    }
}
