#include <stdio.h>
struct cost{
    int miners;
    int toasters;
    int fans;
    float (*price)(int,int ,int);
};
float calculate_price(int n ,int m ,int p){
    float q=(n*1500*0.95)+(m*200*0.85)+(p*450*0.9);
    q=q*0.9;
    return q;
}
int main(){
    struct cost c1;
    printf("no. of miners");
    scanf("%d",&c1.miners);
    printf("no. of toasters");
    scanf("%d",&c1.toasters);
    printf("no. of fans");
    scanf("%d",&c1.fans);
    c1.price=calculate_price;
    printf("total price : %f",c1.price(c1.miners,c1.toasters,c1.fans));
    return 0;
}