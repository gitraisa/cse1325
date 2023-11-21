#include "Index.h"
#include <iostream>

void Index::add_word(const std::string& word, const std::string& filename, int line) {
    
    std::string cleaned_word;
    for (char c : word) {
        if (isalpha(c)) {
            cleaned_word.push_back(tolower(c));
        }
    }

    _index.insert(WordLocationPair(cleaned_word, Location(filename, line)));
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    os << "Index" << std::endl;
    os << "=====" << std::endl;

    for (auto it = index._index.begin(); it != index._index.end();) {
        os << it->first << ": ";

        const auto& range = index._index.equal_range(it->first);
        std::string currentFilename;

        for (auto it2 = range.first; it2 != range.second; ++it2) {
            if (it2->second.get_filename() != currentFilename) {
                os << it2->second.get_filename() << " line ";
                currentFilename = it2->second.get_filename();
            }
            os << it2->second.get_line();
            if (std::next(it2) != range.second) {
                os << ", ";
            }
        }

        os << std::endl;

        it = range.second;
    }

    return os;
}
