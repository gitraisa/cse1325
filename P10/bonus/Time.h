#ifndef TIME_H
#define TIME_H

#include <iostream>

class Time {
private:
    int _hour;
    int _minute;
    int _second;

public:
    Time();
    Time(int hour, int minute, int second);

    Time(int hour, int minute);

    void rationalize();

    Time operator+(int seconds) const;
    friend Time operator+(int seconds, const Time& time);
    Time operator+(const Time& other) const;
    Time& operator++(); // Preincrement
    Time operator++(int); // Postincrement
    bool operator==(const Time& other) const;
    bool operator!=(const Time& other) const;
    bool operator<(const Time& other) const;
    bool operator>(const Time& other) const;
    bool operator<=(const Time& other) const;
    bool operator>=(const Time& other) const;

    friend std::ostream& operator<<(std::ostream& os, const Time& time);
    friend std::istream& operator>>(std::istream& is, Time& time);
};

#endif
