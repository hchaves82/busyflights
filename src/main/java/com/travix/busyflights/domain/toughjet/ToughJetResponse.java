package com.travix.busyflights.domain.toughjet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ToughJetResponse {
	
	public static final String SUPPLIER = "ToughJet";

    private String carrier;

    private String basePrice;
    private String tax;
    private String discount;

    private String departureAirportName;
    private String arrivalAirportName;
    
    private String departureDay;
    private String departureMonth;
    private String departureYear;
    private String returnDay;
    private String returnMonth;
    private String returnYear;
    
	/**
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}
	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	/**
	 * @return the basePrice
	 */
	public String getBasePrice() {
		return basePrice;
	}
	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	/**
	 * @return the tax
	 */
	public String getTax() {
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}
	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	/**
	 * @return the departureAirportName
	 */
	public String getDepartureAirportName() {
		return departureAirportName;
	}
	/**
	 * @param departureAirportName the departureAirportName to set
	 */
	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}
	/**
	 * @return the arrivalAirportName
	 */
	public String getArrivalAirportName() {
		return arrivalAirportName;
	}
	/**
	 * @param arrivalAirportName the arrivalAirportName to set
	 */
	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}
	/**
	 * @return the departureDay
	 */
	public String getDepartureDay() {
		return departureDay;
	}
	/**
	 * @param departureDay the departureDay to set
	 */
	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	/**
	 * @return the departureMonth
	 */
	public String getDepartureMonth() {
		return departureMonth;
	}
	/**
	 * @param departureMonth the departureMonth to set
	 */
	public void setDepartureMonth(String departureMonth) {
		this.departureMonth = departureMonth;
	}
	/**
	 * @return the departureYear
	 */
	public String getDepartureYear() {
		return departureYear;
	}
	/**
	 * @param departureYear the departureYear to set
	 */
	public void setDepartureYear(String departureYear) {
		this.departureYear = departureYear;
	}
	/**
	 * @return the returnDay
	 */
	public String getReturnDay() {
		return returnDay;
	}
	/**
	 * @param returnDay the returnDay to set
	 */
	public void setReturnDay(String returnDay) {
		this.returnDay = returnDay;
	}
	/**
	 * @return the returnMonth
	 */
	public String getReturnMonth() {
		return returnMonth;
	}
	/**
	 * @param returnMonth the returnMonth to set
	 */
	public void setReturnMonth(String returnMonth) {
		this.returnMonth = returnMonth;
	}
	/**
	 * @return the returnYear
	 */
	public String getReturnYear() {
		return returnYear;
	}
	/**
	 * @param returnYear the returnYear to set
	 */
	public void setReturnYear(String returnYear) {
		this.returnYear = returnYear;
	}
	
    public static LocalDateTime getLocalDateTime(String year, String month, String day) {
		LocalDateTime date = LocalDateTime.of(
				Integer.parseInt(year), Integer.parseInt(month),
				Integer.parseInt(day), 0, 0, 0);
        return date;
    }
    
    public BigDecimal getPrice() {
    	return getPrice(this.basePrice, this.tax, this.discount);
    }
    
    public static BigDecimal getPrice(String basePriceStr, String taxStr, String discountStr) {
		BigDecimal basePrice = new BigDecimal(basePriceStr.replaceAll(",", ".")).setScale(2);
		BigDecimal tax = new BigDecimal(taxStr.replaceAll(",", ".")).setScale(2);
		BigDecimal discountPercentage = new BigDecimal(discountStr.replaceAll(",", ".")).setScale(2);
		
		BigDecimal price = basePrice.add(tax);
		BigDecimal discount = price.multiply(discountPercentage.divide(new BigDecimal(100)));
		price = price.subtract(discount).setScale(2);
		
		return price;
    }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ToughJetResponse [carrier=" + carrier + ", basePrice=" + basePrice + ", tax=" + tax + ", discount="
				+ discount + ", departureAirportName=" + departureAirportName + ", arrivalAirportName="
				+ arrivalAirportName + ", departureDay=" + departureDay + ", departureMonth=" + departureMonth
				+ ", departureYear=" + departureYear + ", returnDay=" + returnDay + ", returnMonth=" + returnMonth
				+ ", returnYear=" + returnYear + "]";
	}

}
