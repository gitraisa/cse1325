#include "Time.h"
#include <iostream>

int main() {
    // Test constructor and streaming operators
    Time time1(8, 30, 45);
    std::cout << "Initial time: " << time1 << std::endl;

    // Test addition operator
    Time time2(4, 15, 30);
    Time sum = time1 + time2;
    std::cout << "Sum of times: " << sum << std::endl;

    // Test pre-increment operator
    ++time1;
    std::cout << "Time after pre-increment: " << time1 << std::endl;

    // Test post-increment operator
    Time postIncremented = time1++;
    std::cout << "Time after post-increment: " << time1 << std::endl;
    std::cout << "Post-incremented time: " << postIncremented << std::endl;

    // Test comparison operators
    if (time1 == sum) {
        std::cout << "Time1 is equal to the sum." << std::endl;
    } else if (time1 != sum) {
        std::cout << "Time1 is not equal to the sum." << std::endl;
    }

    if (time1 < sum) {
        std::cout << "Time1 is less than the sum." << std::endl;
    } else if (time1 > sum) {
        std::cout << "Time1 is greater than the sum." << std::endl;
    }

    if (time1 <= sum) {
        std::cout << "Time1 is less than or equal to the sum." << std::endl;
    } else if (time1 >= sum) {
        std::cout << "Time1 is greater than or equal to the sum." << std::endl;
    }

    // Test streaming in operator
    Time inputTime;
    std::cout << "Enter a time (HH:MM:SS): ";
    std::cin >> inputTime;

    if (std::cin.fail()) {
        std::cerr << "Invalid input format!" << std::endl;
        return 1;
    }

    std::cout << "You entered: " << inputTime << std::endl;

    return 0;
}
