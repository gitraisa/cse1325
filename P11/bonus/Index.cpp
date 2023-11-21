#include "Index.h"
#include <iostream>

void Index::add_word(const std::string& word, const std::string& filename, int line) {
    // Remove punctuation and convert to lowercase
    std::string cleaned_word;
    for (char c : word) {
        if (isalpha(c)) {
            cleaned_word.push_back(tolower(c));
        }
    }

    // Add the cleaned word to the index
    _index[cleaned_word].insert(Location(filename, line));
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    os << "Index" << std::endl;
    os << "=====" << std::endl;

    for (const auto& entry : index._index) {
        os << entry.first << ": ";
        const auto& locations = entry.second;
        std::string currentFilename; // To track the current filename being printed
        for (auto it = locations.begin(); it != locations.end(); ++it) {
            if (it->get_filename() != currentFilename) {
                os << it->get_filename() << " line ";
                currentFilename = it->get_filename();
            }
            os << it->get_line();
            if (std::next(it) != locations.end()) {
                os << ", ";
            }
        }
        os << std::endl;
    }
    return os;
}
