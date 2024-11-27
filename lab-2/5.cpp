#include<iostream>
using namespace std;
class fraction{
    int num;
    int deno;
    public:
    fraction(int num,int deno){
        this->num=num;
        this->deno=deno;
    }
    inline void sum(fraction a,fraction b){
        cout<<"sum :"<<((a.num*b.deno)+(b.num*a.deno))/(b.deno*a.deno)<<endl;
    }
    inline void subtract(fraction &a ,fraction &b){
        cout<<"difference :"<<((a.num*b.deno)-(b.num*a.deno))/(b.deno*a.deno)<<endl;
    }
    inline void multiply(fraction *a ,fraction *b){
        cout<<"multiplication is :"<<((a->num)*(b->num))/((b->deno)*(a->deno))<<endl;
        
    }

};
int main(){
    fraction a(14,2);
    fraction b(16,2);
a.sum(a,b);
a.subtract(a,b);
a.multiply(&a,&b);

}