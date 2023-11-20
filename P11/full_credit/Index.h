#ifndef INDEX_H
#define INDEX_H

#include <map>
#include <set>
#include <string>
#include "Location.h"

class Index {
private:
    using Word = std::string;
    using Locations = std::set<Location>;
    std::map<Word, Locations> _index;

public:
    void add_word(const std::string& word, const std::string& filename, int line);

    // Friend function for streaming out
    friend std::ostream& operator<<(std::ostream& os, const Index& index);
};

#endif // INDEX_H
