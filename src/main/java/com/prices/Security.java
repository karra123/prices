package com.prices;

import java.math.BigDecimal;

public class Security {
	private String cusip;
	private BigDecimal price;
	public Security(String cusip) {
		super();
		this.cusip = cusip;
	}
	public String getCusip() {
		return cusip;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cusip == null) ? 0 : cusip.hashCode());
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
		Security other = (Security) obj;
		if (cusip == null) {
			if (other.cusip != null)
				return false;
		} else if (!cusip.equals(other.cusip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Security [cusip=" + cusip + ", price=" + price + "]";
	}
	
}
