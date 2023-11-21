#include "Location.h"
#include <iostream>

std::string Location::last_filename = "";

Location::Location(const std::string& filename, int line)
    : _filename(filename), _line(line) {}

bool Location::operator<(const Location& rhs) const {
    if (_filename != rhs._filename)
        return _filename < rhs._filename;
    return _line < rhs._line;
}

bool Location::operator==(const Location& rhs) const {
    return _filename == rhs._filename && _line == rhs._line;
}

bool Location::operator!=(const Location& rhs) const {
    return !(*this == rhs);
}

bool Location::operator<=(const Location& rhs) const {
    return *this < rhs || *this == rhs;
}

bool Location::operator>(const Location& rhs) const {
    return !(*this <= rhs);
}

bool Location::operator>=(const Location& rhs) const {
    return !(*this < rhs);
}

std::ostream& operator<<(std::ostream& os, const Location& loc) {
    return os << loc._filename << " line " << loc._line << std::endl;
}
 void Location::next_word() {
    Location::last_filename = "";
 }