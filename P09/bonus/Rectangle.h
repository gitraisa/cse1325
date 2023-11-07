#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape {
public:
    Rectangle(double width, double height);
    std::string name() const override;
    double area() const override;

private:
    double width_;
    double height_;
};

#endif
