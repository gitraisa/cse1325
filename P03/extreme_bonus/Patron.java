import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patron {
    private String name;

    public Patron(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}