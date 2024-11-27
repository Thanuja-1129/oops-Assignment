#include <stdio.h>

#define MAX_NAME_LENGTH 100

// Define the struct with the correct data types
struct bill {
    char Name[MAX_NAME_LENGTH];
    int Number_of_calls;
    float (*amount)(int);
    void (*inputs)(struct bill *);
};

// Function to calculate the amount
float calculate_amount(int n) {
    float p;
    if (n <= 100) {
        p = 200;
    } else if (n <= 150) {
        p = 200 + (n - 100) * 0.6;
    } else if (n <= 200) {
        p = 200 + 50 * 0.6 + (n - 150) * 0.5;
    } else {
        p = 200 + 50 * 0.6 + 50 * 0.5 + (n - 200) * 0.4;
    }
    return p;
}

// Function to input data
void calculate_input(struct bill *b1) {
    printf("Enter your name: ");
    scanf("%s", b1->Name); // Use %s to read a string
    printf("Number of calls: ");
    scanf("%d", &b1->Number_of_calls); // Use & to read an integer
}

int main() {
    struct bill b1;
    b1.inputs = calculate_input;
    b1.amount = calculate_amount;

    // Call the inputs function to fill in the data
    b1.inputs(&b1);

    // Calculate and print the total bill
    printf("Total bill: %.2f\n", b1.amount(b1.Number_of_calls));

    return 0;
}
