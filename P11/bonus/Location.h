#ifndef LOCATION_H
#define LOCATION_H

#include <string>

class Location {
private:
    static std::string last_filename;
    std::string _filename;
    int _line;

public:
    Location(const std::string& filename, int line);

    
    bool operator<(const Location& rhs) const;
    bool operator==(const Location& rhs) const;
    bool operator!=(const Location& rhs) const;
    bool operator<=(const Location& rhs) const;
    bool operator>(const Location& rhs) const;
    bool operator>=(const Location& rhs) const;

    
    friend std::ostream& operator<<(std::ostream& os, const Location& loc);

    static void next_word();

    std::string get_filename() const {
        return _filename;
    }

    int get_line() const {
        return _line;
    }
};

#endif 
