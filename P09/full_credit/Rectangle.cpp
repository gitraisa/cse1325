#include "Rectangle.h"

Rectangle::Rectangle(double width, double height) : width_(width), height_(height) {}

std::string Rectangle::name() const {
    return "Rectangle " + std::to_string(width_) + "x" + std::to_string(height_);
}

double Rectangle::area() const {
    return width_ * height_;
}
