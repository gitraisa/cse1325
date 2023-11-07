#include "Rectangle.h"
#include <fstream>

Rectangle::Rectangle(double width, double height, int red, int green, int blue)
    : width_(width), height_(height), red_(red), green_(green), blue_(blue) {}

std::string Rectangle::name() const {
    return "Rectangle " + std::to_string(width_) + "x" + std::to_string(height_);
}

double Rectangle::area() const {
    return width_ * height_;
}

void Rectangle::drawPPM() const {
    std::ofstream file("rectangle.ppm");
    file << "P3" << std::endl;
    file << width_ << " " << height_ << std::endl;
    file << "255" << std::endl;
    
    for (int i = 0; i < height_; ++i) {
        for (int j = 0; j < width_; ++j) {
            file << red_ << " " << green_ << " " << blue_ << " ";
        }
        file << std::endl;
    }
    file.close();
    
    system("open -a Preview rectangle.ppm");  // Modify the viewer command as needed
}
