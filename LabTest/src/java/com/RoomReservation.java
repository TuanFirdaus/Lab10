package com;


import java.util.Date;


public class RoomReservation {
    private int reservationCode;
    private String userID;
    private Date checkInDate;
    private Date checkOutDate;
    private String roomType;
    private String roomID;
    private int numOfCustomers;
    private double totalPrice;

    // Getters and Setters

    /**
     * @return the reservationCode
     */
    public int getReservationCode() {
        return reservationCode;
    }

    /**
     * @param reservationCode the reservationCode to set
     */
    public void setReservationCode(int reservationCode) {
        this.reservationCode = reservationCode;
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
     * @return the checkInDate
     */
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate the checkInDate to set
     */
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return the checkOutDate
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * @param checkOutDate the checkOutDate to set
     */
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * @return the roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * @return the roomID
     */
    public String getRoomID() {
        return roomID;
    }

    /**
     * @param roomID the roomID to set
     */
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    /**
     * @return the numOfCustomers
     */
    public int getNumOfCustomers() {
        return numOfCustomers;
    }

    /**
     * @param numOfCustomers the numOfCustomers to set
     */
    public void setNumOfCustomers(int numOfCustomers) {
        this.numOfCustomers = numOfCustomers;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

