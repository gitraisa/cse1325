#include <iostream>
#include <string>
#include <vector>
#include <cctype>

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
