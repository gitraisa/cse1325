#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"

class Circle : public Shape {
public:
    Circle(double radius);
    std::string name() const override;
    double area() const override;

private:
    double radius_;
};

#endif
