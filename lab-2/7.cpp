#include<iostream>
using namespace std;
class bank{
    int current_money;
    public:
    bank(int current_money){
        this->current_money=current_money;
    }
    void diposite(int n){
        current_money=current_money+n;
        cout<<n<<"rs has been deposited"<<endl;
        cout<<current_money<<endl;
     cout<<"balance"<<current_money<<endl;
    }
    void withdraw(int a){
        if(current_money==0){
            cout<<"no sufficient money"<<endl;
            return;
        }
        current_money=current_money-a;
        cout<<a<<"rs has been withdrawed"<<endl;
         cout<<"balance"<<current_money<<endl;

    }
};
int main(){
    bank b(1000);
    b.withdraw(100);
    
}