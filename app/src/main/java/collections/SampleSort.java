package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Laptop implements Comparable<Laptop> {
    private final String _brand;
    private double _price;

    public Laptop(final String brand, final double price) {
        this._brand = brand;
        this._price = price;
    }

    public String getBrand() {
        return _brand;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        this._price = price;
    }

    @Override
    public String toString() {
        return "Laptop [_brand=" + _brand + ", _price=" + _price + "]";
    }

    @Override
    public int compareTo(Laptop other) {
        return other.getBrand().compareTo(_brand);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Laptop)) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return Objects.equals(_brand, laptop._brand) && _price == laptop._price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_brand, _price);
    }

}

public class SampleSort {

    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();

        laptops.add(new Laptop("Acer", 1000));
        laptops.add(new Laptop("Asus", 1100));
        laptops.add(new Laptop("Dell", 1200));
        laptops.add(new Laptop("Surface", 2000));

        Collections.sort(laptops);

        System.out.println(laptops);

        // Using comparator.

        Comparator<Laptop> comparator = (x, y) -> Double.compare(x.getPrice(), y.getPrice());
        Collections.sort(laptops, comparator );
        System.out.println(laptops);
    }

}
