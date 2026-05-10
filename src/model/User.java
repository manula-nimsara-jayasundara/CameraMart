/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Manula
 */
public class User {

    private static User instance;

    private String employeeEmail;
    private String employeeName;
    private String password;
    private String jobRole;

    public User() {

    }

//    private static User getInstance() {
//        if (instance == null) {
//            instance = new User();
//        }
//        return instance;
//    }

    /**
     * @return the employeeEmail
     */
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /**
     * @param employeeEmail the employeeEmail to set
     */
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the jobRole
     */
    public String getJobRole() {
        return jobRole;
    }

    /**
     * @param jobRole the jobRole to set
     */
    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

//    public void logOut() {
//        instance = null;
//    }
}
