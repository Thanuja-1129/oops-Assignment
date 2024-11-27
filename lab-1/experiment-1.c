#include <stdio.h>
struct postalrates{
    float weight;
  float (*postage)(float);
};
  float calculate_postage(float n){
        float price=0;
        if(n<=50){
         price=n*0.5;
        }
        else if(n<=150){
         price=5*0.5 +((n-50)/10)*0.4;
        }
        else if(n<=400){
         price=5*0.5 + 10*0.4 + (n-1500)*0.25;
        }
        else if(n>400){
            price=5*0.5 + 10*0.4 + 25*0.25;
        }
        return price;
    }
int main(){
    struct postalrates p1;
    p1.postage=calculate_postage;
    printf("enter weight :");
    scanf("%f",&p1.weight);
    printf("here is postage");
    printf("%2f",p1.postage(p1.weight));
    return 0;
}