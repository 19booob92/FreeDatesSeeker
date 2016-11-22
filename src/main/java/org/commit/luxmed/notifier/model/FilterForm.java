package org.commit.luxmed.notifier.model;

import java.util.Date;

public class FilterForm {

	private long referralId;
	private String DateOption = "SelectedDate";
	private long cityId = 5;
	private long serviceId = 4387;
	private long serviceId_2nd = 4540;
	private long LanguageId;
	private String payedOption = "Free";
	private boolean SearchFirstFree = false;
	private Date dateFrom;
	private Date dateTo;
	private String timeOption = "Any";
	private String __RequestVerificationToken;
	
	public long getReferralId() {
		return referralId;
	}
	public void setReferralId(long referralId) {
		this.referralId = referralId;
	}
	public String getDateOption() {
		return DateOption;
	}
	public void setDateOption(String dateOption) {
		DateOption = dateOption;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public long getServiceId_2nd() {
		return serviceId_2nd;
	}
	public void setServiceId_2nd(long serviceId_2nd) {
		this.serviceId_2nd = serviceId_2nd;
	}
	public long getLanguageId() {
		return LanguageId;
	}
	public void setLanguageId(long languageId) {
		LanguageId = languageId;
	}
	public String getPayedOption() {
		return payedOption;
	}
	public void setPayedOption(String payedOption) {
		this.payedOption = payedOption;
	}
	public boolean isSearchFirstFree() {
		return SearchFirstFree;
	}
	public void setSearchFirstFree(boolean searchFirstFree) {
		SearchFirstFree = searchFirstFree;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public String getTimeOption() {
		return timeOption;
	}
	public void setTimeOption(String timeOption) {
		this.timeOption = timeOption;
	}
	public String get__RequestVerificationToken() {
		return __RequestVerificationToken;
	}
	public void set__RequestVerificationToken(String __RequestVerificationToken) {
		this.__RequestVerificationToken = __RequestVerificationToken;
	}
	
}
