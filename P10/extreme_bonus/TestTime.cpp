#include "Time.h"
#include <iostream>

int main() {
    Time time(9, 30, 0);
    int hour = time[0];    // hour is 9
    int minute = time[1];  // minute is 30
    int second = time[2];  // second is 0

    std::cout << "Hour: " << hour << ", Minute: " << minute << ", Second: " << second << std::endl;

    return 0;
}
