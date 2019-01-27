package beans;


import java.time.LocalDate;

public class Request {

    public enum RequestStates{
        POSLAT, OTKAZAN, ODBIJEN, REALIZOVAN
    }

    public class Address{
        private String county;
        private String streetNumber;

        public Address(String county, String streetNumber) {
            this.county = county;
            this.streetNumber = streetNumber;
        }

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
    private Handyman.Job job;
    private Address address;
    private LocalDate requestCreatedDate;
    private LocalDate requestDate;
    private Double urgency;
    private Boolean cash;
    private RequestStates currentState = RequestStates.POSLAT;
    private Integer rating;

    public Request(Handyman handyman, Handyman.Job job, String county, String streetNumber,
                   LocalDate requestCreatedDate, LocalDate requestDate, Double urgency,
                   Boolean cash) {
        this.handyman = handyman;
        this.job = job;
        this.address = new Address(county, streetNumber);
        this.requestCreatedDate = requestCreatedDate;
        this.requestDate = requestDate;
        this.urgency = urgency;
        this.cash = cash;
    }

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

    public Handyman.Job getJob() {
        return job;
    }

    public void setJob(Handyman.Job job) {
        this.job = job;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getRequestCreatedDate() {
        return requestCreatedDate;
    }

    public void setRequestCreatedDate(LocalDate requestCreatedDate) {
        this.requestCreatedDate = requestCreatedDate;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public Double getUrgency() {
        return urgency;
    }

    public void setUrgency(Double urgency) {
        this.urgency = urgency;
    }

    public Boolean isCash() {
        return cash;
    }

    public void setCash(Boolean cash) {
        this.cash = cash;
    }

    public RequestStates getCurrentState() {
        return currentState;
    }

    public void setCurrentState(RequestStates currentState) {
        this.currentState = currentState;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
