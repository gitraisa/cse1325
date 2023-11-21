#include "Index.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <iterator>

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " file1 [file2 ...]" << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error opening file: " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int line_number = 1;
        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;
            while (iss >> word) {
                // Remove punctuation and convert to lowercase
                std::string cleaned_word;
                for (char c : word) {
                    if (isalpha(c)) {
                        cleaned_word.push_back(tolower(c));
                    }
                }

                index.add_word(cleaned_word, argv[i], line_number);
            }

            ++line_number;
        }

        file.close();
    }

    std::cout << index;

    return 0;
}
