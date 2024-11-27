#include<iostream>
using namespace std;
class amount{
    public:
    int n;//miners
    int m;//toasters
    int p;//fans;
    int discount();
     void getdata(){
        cout<<"miners :";
        cin>>n;
        cout<<"toasters :";
        cin>>m;
        cout<<"fans :";
        cin>>p;
    }
    };
    inline int amount::discount(){
    return (n*0.85*1500 + m*0.75*200 + p*0.80*450 );
    }
    int main(){
        amount p1;
        p1.getdata();
        int a= p1.discount();
        cout<<"the store has to pay :"<<a;

    }