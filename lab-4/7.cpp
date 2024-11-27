#include<iostream>
using namespace std;
class class_1;
class class_2{
    int b;
public:
void getin2(){
    cout<<"b :";
    cin>>b;
}
void display2(){
    cout<<" b :"<<b;
}
friend void excahnge(class_1 &a,class_2 &b);
};
class class_1{
    int a;
  public:
  void getin1(){
    cout<<"a :";
    cin>>a;
}
void display1(){
    cout<<" a :"<<a;
}
  friend void excahnge(class_1 &a,class_2 &b);  
};
void excahnge(class_1 &a,class_2 &b){
    cout<<"exchange";
    int temp=a.a;
    a.a=b.b;
    b.b=temp;
a.display1();
b.display2();
}
int main(){
    class_1 a;
    class_2 b;
    a.getin1();
    b.getin2();
    excahnge(a,b);
}

