#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <vector>
#include <iostream>

int main() {
    std::vector<Shape*> shapes;

    Rectangle rectangle(4.0, 6.0);
    Circle circle(3.0);

    shapes.push_back(&rectangle);
    shapes.push_back(&circle);

    for (const auto shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }

    return 0;
}
