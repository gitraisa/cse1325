#include <iostream>
#include <string>
#include <vector>
#include <cctype>
#include <algorithm>

bool compareLengthThenAlphabetical(const std::string& a, const std::string& b) {
    if (a.length() == b.length()) {
        return a < b;
    }
    return a.length() < b.length();
}
int main(int argc, const char * argv[]) {
    std::vector<std::string> caps;
    std::vector<std::string> no_caps;
    
    for (int i =1; i < argc; i++) {
        std::string word = argv[i];
        
        if (!word.empty()) {
            if (std::isupper(word[0])) {
                caps.push_back(word);
            } else {
                no_caps.push_back(word);
            }
        }
    }
    
    std::sort(caps.begin(), caps.end());

    std::sort(no_caps.begin(), no_caps.end(), compareLengthThenAlphabetical);
    
    std::cout << "Capitalized:" << std::endl;
    for (const std::string& word : caps) {
        std::cout << word << std::endl;
    }
    
    std::cout << "Lower Case:" << std::endl;
    for (const std::string& word : no_caps) {
        std::cout << word << std::endl;
    }
    
    return 0;
}
