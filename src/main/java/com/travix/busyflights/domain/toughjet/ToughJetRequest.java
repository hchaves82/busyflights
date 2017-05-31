package com.travix.busyflights.domain.toughjet;

public class ToughJetRequest {

    private String from;
    private String to;

    private String departureDay;
    private String departureMonth;
    private String departureYear;

    private String returnDay;
    private String returnMonth;
    private String returnYear;

    private Integer numberOfAdults;
    
	public ToughJetRequest(String from, String to, String departureDay, String departureMonth, String departureYear,
			String returnDay, String returnMonth, String returnYear, Integer numberOfAdults) {
    	this.from = from;
    	this.to = to;
    	this.departureDay = departureDay;
    	this.departureMonth = departureMonth;
    	this.departureYear = departureYear;
    	this.returnDay = returnDay;
    	this.returnMonth = returnMonth;
    	this.returnYear = returnYear;
    	this.numberOfAdults = numberOfAdults;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(String departureMonth) {
        this.departureMonth = departureMonth;
    }

    public String getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(String departureYear) {
        this.departureYear = departureYear;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }

    public String getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(String returnMonth) {
        this.returnMonth = returnMonth;
    }

    public String getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(String returnYear) {
        this.returnYear = returnYear;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
