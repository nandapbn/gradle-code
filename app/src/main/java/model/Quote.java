package model;

import java.util.Objects;

public class Quote {

    String _securityId;
    long _qty;
    double _price;

    public Quote(String security, long qty, double price) {
        this._securityId = security;
        this._qty = qty;
        this._price = price;
    }

    public String getSecurity() {
        return this._securityId;
    }

    public void setSecurityId(String securityId) {
        this._securityId = securityId;
    }

    public long getQty() {
        return this._qty;
    }

    public void seQty(long qty) {
        this._qty = qty;
    }

    public double getPrice() {
        return this._price;
    }

    public void setPrice(double price) {
        this._price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Quote)) {
            return false;
        }
        Quote quote = (Quote) o;
        return Objects.equals(_securityId, quote._securityId) && _qty == quote._qty && _price == quote._price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_securityId, _qty, _price);
    }

    @Override
    public String toString() {
        return "{" +
                " _securityId='" + getSecurity() + "'" +
                ", _qty='" + getQty() + "'" +
                ", _price='" + getPrice() + "'" +
                "}";
    }

}
