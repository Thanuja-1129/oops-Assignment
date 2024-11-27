#include<iostream>
using namespace std;
class employee{
    public:
    string Name;
    int income;
    int Tax_due;
    void input(){
        cout<<"name :";
        cin>>Name;
        cout<<"Income :";
        cin>>income;
    }
    int compute(){
        if(income <=100000){
            return 0;
        }
        else if(income>100000 && income<=150000){
            return (income-100000)*0.1;
        } 
         else if(income>150000 && income<=200000){
            return (income-150000)*0.2;
        } 
         else if(income>200000 ){
            return (income-200000)*0.3;
        } 
    }
    void output(){
        int a=compute();
        cout<<Name<<"has to pay income tax of Rs."<<a;
    }
};
int main(){
    employee e;
    e.input();
    e.compute();
    e.output();
};