#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape {
public:
    Rectangle(double width, double height, int red, int green, int blue);
    std::string name() const override;
    double area() const override;
    void drawPPM() const;

private:
    double width_;
    double height_;
    int red_;
    int green_;
    int blue_;
};

#endif
