package beans;

import java.util.Date;

public class Request {

    public enum RequestStates{
        POSLAT, OTKAZAN, ODBIJEN, REALIZOVAN
    }

    private class Address{
        private String county;
        private String streetNumber;

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
        }
    }

    private static int stId = 0;
    private int id = ++stId;
    private Handyman handyman;
    private int jobId;
    private Address address;
    private Date requestCreatedDate;
    private Date requestDate;
    private int urgency;
    private boolean cash = true;
    private RequestStates currentState = RequestStates.POSLAT;
    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Handyman getHandyman() {
        return handyman;
    }

    public void setHandyman(Handyman handyman) {
        this.handyman = handyman;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getRequestCreatedDate() {
        return requestCreatedDate;
    }

    public void setRequestCreatedDate(Date requestCreatedDate) {
        this.requestCreatedDate = requestCreatedDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public boolean isCash() {
        return cash;
    }

    public void setCash(boolean cash) {
        this.cash = cash;
    }

    public RequestStates getCurrentState() {
        return currentState;
    }

    public void setCurrentState(RequestStates currentState) {
        this.currentState = currentState;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
