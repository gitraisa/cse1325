#include "Time.h"
#include <iomanip>

Time::Time() : _hour(0), _minute(0), _second(0) {}

Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second) {
    rationalize();
}

void Time::rationalize() {
    _hour = (_hour + _minute / 60 + _second / 3600) % 24;
    _minute = (_minute + _second / 60) % 60;
    _second %= 60;
}

Time Time::operator+(const Time& other) const {
    Time result(_hour + other._hour, _minute + other._minute, _second + other._second);
    result.rationalize();
    return result;
}


Time& Time::operator++() {
    ++_second;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time temp = *this;
    ++(*this);
    return temp;
}

bool Time::operator==(const Time& other) const {
    return (_hour == other._hour) && (_minute == other._minute) && (_second == other._second);
}

bool Time::operator!=(const Time& other) const {
    return !(*this == other);
}

bool Time::operator<(const Time& other) const {
    if (_hour != other._hour) return _hour < other._hour;
    if (_minute != other._minute) return _minute < other._minute;
    return _second < other._second;
}

bool Time::operator>(const Time& other) const {
    return other < *this;
}

bool Time::operator<=(const Time& other) const {
    return !(*this > other);
}

bool Time::operator>=(const Time& other) const {
    return !(*this < other);
}

int Time::operator[](int index) const {
    switch (index) {
        case 0:
            return _hour;
        case 1:
            return _minute;
        case 2: 
            return _second;
        default:
            return -1;
    }
}
std::ostream& operator<<(std::ostream& os, const Time& time) {
    os << std::setfill('0') << std::setw(2) << time._hour << ":"
       << std::setw(2) << time._minute << ":" << std::setw(2) << time._second;
    return os;
}

std::istream& operator>>(std::istream& is, Time& time) {
    char colon1, colon2;
    is >> time._hour >> std::noskipws >> colon1 >> time._minute >> colon2 >> time._second;

    if (is.fail() || colon1 != ':' || colon2 != ':') {
        is.clear(std::ios::failbit);
        return is;
    }

    time.rationalize();
    return is;
}
