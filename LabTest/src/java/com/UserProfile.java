package com;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tfird
 */
public class UserProfile {
    private String userID;
    private String userName;
    private String gender;
    private String contactNo;
    private String idNumber;
    private int age;
    private String address;

    public UserProfile(){
        
    }
    public UserProfile(String userID, String userName, String gender, String contactNo, String idNumber, int age, String address){
        super();
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.contactNo = contactNo;
        this.idNumber = idNumber;
        this.age = age;
        this.address = address;
    }
    
     public UserProfile(String userName, String gender, String contactNo, String idNumber, int age, String address){
        super();
        this.userName = userName;
        this.gender = gender;
        this.contactNo = contactNo;
        this.idNumber = idNumber;
        this.age = age;
        this.address = address;
    }
    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}

