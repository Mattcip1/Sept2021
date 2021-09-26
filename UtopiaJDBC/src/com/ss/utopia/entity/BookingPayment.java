package com.ss.utopia.entity;

public class BookingPayment {

	private Booking paymentId;
	private String stripeId;
	private Integer refunded;
	
	public Booking getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Booking paymentId) {
		this.paymentId = paymentId;
	}
	public String getStripeId() {
		return stripeId;
	}
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	public Integer getRefunded() {
		return refunded;
	}
	public void setRefunded(Integer refunded) {
		this.refunded = refunded;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
		result = prime * result + ((refunded == null) ? 0 : refunded.hashCode());
		result = prime * result + ((stripeId == null) ? 0 : stripeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingPayment other = (BookingPayment) obj;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		if (refunded == null) {
			if (other.refunded != null)
				return false;
		} else if (!refunded.equals(other.refunded))
			return false;
		if (stripeId == null) {
			if (other.stripeId != null)
				return false;
		} else if (!stripeId.equals(other.stripeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookingPayment [paymentId=" + paymentId + ", stripeId=" + stripeId + ", refunded=" + refunded + "]";
	}
}
