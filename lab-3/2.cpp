#include<iostream>
using namespace std;
class employee{
    string name;
    int calls;
    int bill_amount;
    public:
void input(){
    cout<<"name :";
    cin>>name;
    cout<<"calls :";
    cin>>calls;
}
int compute(){
   if(calls<=100){
    return 200;
   } 
   else if (calls<=150)
   {
     return 200 + (calls-100)*0.6;
   }
    else if (calls<=200)
   {
     return 200 + 50*0.6 +(calls-150)*0.5;
   }
   else if (calls>200)
   {
     return 200 + 50*0.6 + 50*0.5 + (calls-200)*0.4;
   }
}
 void output(){
    
    int a=compute();
    cout<<"bill of "<<name<<" is :"<<a;
 }
};
int main(){
    employee e;
    e.input();
    e.compute();
    e.output();
    return 0;
}