package com.blockchain.pai.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Venta implements Serializable {

	private static final long serialVersionUID = -3737776733691807108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long appId;
	private String cancelReason;
	private String cancelledAt;
	private Boolean confirmed;
	private String contactEmail;
	private String createdAt;
	private Long customerId;
	private String email;
	private String financialStatus;
	private String fulfillmentStatus;
	private String gateway;
	private Long idShopify;
	private String landingSite;
	private String locationId;
	private String name;
	private String note;
	private Long orderNumber;
	private String orderStatusUrl;
	private String phone;
	private String processingMethod;
	private Long shippingAddressId;
	private String subtotalPrice;
	private String tags;
	private String totalDiscounts;
	private String totalLineItemsPrice;
	private String totalPrice;
	private String totalTax;
	private Long totalWeight;
	private String updatedAt;
	private BigInteger userId;

	public Venta() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelledAt() {
		return cancelledAt;
	}

	public void setCancelledAt(String cancelledAt) {
		this.cancelledAt = cancelledAt;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFinancialStatus() {
		return financialStatus;
	}

	public void setFinancialStatus(String financialStatus) {
		this.financialStatus = financialStatus;
	}

	public String getFulfillmentStatus() {
		return fulfillmentStatus;
	}

	public void setFulfillmentStatus(String fulfillmentStatus) {
		this.fulfillmentStatus = fulfillmentStatus;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public Long getIdShopify() {
		return idShopify;
	}

	public void setIdShopify(Long idShopify) {
		this.idShopify = idShopify;
	}

	public String getLandingSite() {
		return landingSite;
	}

	public void setLandingSite(String landingSite) {
		this.landingSite = landingSite;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatusUrl() {
		return orderStatusUrl;
	}

	public void setOrderStatusUrl(String orderStatusUrl) {
		this.orderStatusUrl = orderStatusUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProcessingMethod() {
		return processingMethod;
	}

	public void setProcessingMethod(String processingMethod) {
		this.processingMethod = processingMethod;
	}

	public Long getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(Long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(String subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTotalDiscounts() {
		return totalDiscounts;
	}

	public void setTotalDiscounts(String totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
	}

	public String getTotalLineItemsPrice() {
		return totalLineItemsPrice;
	}

	public void setTotalLineItemsPrice(String totalLineItemsPrice) {
		this.totalLineItemsPrice = totalLineItemsPrice;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

	public Long getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Long totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", appId=" + appId + ", cancelReason=" + cancelReason + ", cancelledAt="
				+ cancelledAt + ", confirmed=" + confirmed + ", contactEmail=" + contactEmail + ", createdAt="
				+ createdAt + ", customerId=" + customerId + ", email=" + email + ", financialStatus=" + financialStatus
				+ ", fulfillmentStatus=" + fulfillmentStatus + ", gateway=" + gateway + ", idShopify=" + idShopify
				+ ", landingSite=" + landingSite + ", locationId=" + locationId + ", name=" + name + ", note=" + note
				+ ", orderNumber=" + orderNumber + ", orderStatusUrl=" + orderStatusUrl + ", phone=" + phone
				+ ", processingMethod=" + processingMethod + ", shippingAddressId=" + shippingAddressId
				+ ", subtotalPrice=" + subtotalPrice + ", tags=" + tags + ", totalDiscounts=" + totalDiscounts
				+ ", totalLineItemsPrice=" + totalLineItemsPrice + ", totalPrice=" + totalPrice + ", totalTax="
				+ totalTax + ", totalWeight=" + totalWeight + ", updatedAt=" + updatedAt + ", userId=" + userId + "]";
	}

}
