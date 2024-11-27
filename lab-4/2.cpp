#include<iostream>
using namespace std;
class A{
public:
int a;
};
class B:public A{
public:
int b;
void getdata(){
    cout<<"A:";
    cin>>a;
    cout<<"A:";
    cin>>a;
    }
friend void mean(int a, int b);
};
void mean(int a ,int b){
    cout<<"mean of a and b is"<<(a+b)/2;
}

int main(){
    B an;
    an.getdata();
   mean(an.a, an.b);
    return 0;
}
