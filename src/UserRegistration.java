#include <iostream>
using namespace std;

class Complex {
private:
    double real;
    double imag;
public:
    Complex(double r = 0.0, double i = 0.0) : real(r), imag(i) {}

    Complex operator+(const Complex& other) const {
        return Complex(real + other.real, imag + other.imag);
    }

    Complex operator-(const Complex& other) const {
        return Complex(real - other.real, imag - other.imag);
    }
    bool operator==(const Complex& other) const {
        return (abs(real - other.real) < 1e-9) && (abs(imag - other.imag) < 1e-9);
    }

    friend ostream& operator<<(ostream& out, const Complex& c);
    friend istream& operator>>(istream& in, Complex& c);
};

ostream& operator<<(ostream& out, const Complex& c) {
    out << c.real;
    if (c.imag > 0) {
        out << " + " << c.imag << "i";
    } else if (c.imag < 0) {
        out << " - " << abs(c.imag) << "i";
    }
    return out;
}
istream& operator>>(istream& in, Complex& c) {
    cout << "Enter real part: ";
    in >> c.real;
    cout << "Enter imaginary part: ";
    in >> c.imag;
    return in;
}

int main() {
    Complex num1, num2, num3;

    cout << "Enter the first complex number: " << endl;
    cin >> num1;
    cout << "Enter the second complex number: " << endl;
    cin >> num2;

    num3 = num1 + num2;
    cout << "num1 + num2 = " << num3 << endl;

    num3 = num1 - num2;
    cout << "num1 - num2 = " << num3 << endl;

    if (num1 == num2) {
        cout << "num1 and num2 are equal" << endl;
    } else {
        cout << "num1 and num2 are not equal" << endl;
    }

    return 0;
}
