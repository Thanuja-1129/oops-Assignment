#include<iostream>
using namespace std;
class employee{
    string name;
    int earnings;
    int bonus;
    public:
    void input(){
     cout<<"name :";
     cin>>name;
    cout<<"earnings :";
    cin>>earnings;
    }
    inline int b_compute(){
        if(earnings>2000){
        return earnings*0.1;}
        else{
            return 0;
        }
    }
    void output(){
        cout<<"name :"<<name<<endl;
        int a=b_compute();
         cout<<"Bonous to be paid :"<<a;
    }

};
int main(){
    employee a;
    a.input();
    a.b_compute();
    a.output();
    return 0;
}