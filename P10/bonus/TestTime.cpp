#include "Time.h"
#include <iostream>

int main() {
    
    int seconds = 600;
    Time time(9, 30, 0); //I was not able to run my program with {},my compiler was not compatible. Hence why I used ()
    std::cout << time + seconds << " is also " << seconds + time << std::endl;

    return 0;
}
