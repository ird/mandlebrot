package uk.ord.ird.mandlebrot;

public class Complex {
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re(), im + c.im());
    }

    public Complex sq() {
        return new Complex( re*re - im*im, 2*re*im);
    }

    public void print() {
        System.out.println(re + "+" + im + "j");
    }

    public double mag() {
        return Math.sqrt(re * re + im * im);
    }

    public double re() { return re; }
    public double im() { return im; }

    private double re;
    private double im;
}
