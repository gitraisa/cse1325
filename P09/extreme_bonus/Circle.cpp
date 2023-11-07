#include "Circle.h"
#include <cmath>

Circle::Circle(double radius) : radius_(radius) {}

std::string Circle::name() const {
    return "Circle of radius " + std::to_string(radius_);
}

double Circle::area() const {
    return M_PI * radius_ * radius_;
}
