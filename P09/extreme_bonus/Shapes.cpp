#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <vector>
#include <iostream>

int main() {
    std::vector<Shape*> shapes;

    Rectangle rectangle(14.0, 5.0, 255, 0, 0);  
    Circle circle(3.0);

    shapes.push_back(&rectangle);
    shapes.push_back(&circle);

    for (const auto shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }

    Rectangle* rect = dynamic_cast<Rectangle*>(shapes[0]);
    if (rect) {
        rect->drawPPM();
    }

    return 0;
}

