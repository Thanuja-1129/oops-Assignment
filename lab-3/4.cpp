#include<iostream>
using namespace std;
class bankAccount{
    string Account_holder;
    string AccountType;
    int money=0;
    int BalanceAmmount;
    public:
    bankAccount(string Account_holder,string AccountType){
        this->Account_holder=Account_holder;
        this->AccountType=AccountType;
    }
     int deposite(int a){
        money=money+a;
        return money+a;
     }
     int withdraw(int b){
        money=money-b;
        return money-b;
     }
    int BalanceAmount(){
        
        cout<<endl<<"Account_holder :"<<Account_holder<<endl;
        cout<<"AccountType :"<<AccountType<<endl;
        cout<<"Balance of "<<Account_holder<<" is "<<money;
    }    
};
int main(){
    bankAccount b("Thanuja","Saving");
    b.deposite(5000);
    b.withdraw(20);
    b.BalanceAmount();
    return 0;
}