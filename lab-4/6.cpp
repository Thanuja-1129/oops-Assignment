/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
using namespace std;
class employee{
    public:
    int emp_id;
    string emp_name;
    int age;
    public:
    void getinput();
    void display();
};

void employee::getinput(){
    cout<< " emp_id :";
    cin>>emp_id;
    cout<<"emp_name :";
    cin>>emp_name;
    cout<<"age :";
    cin>>age;
}
void employee::display(){
    cout<< " emp_id :"<<emp_id;
     cout<< " emp_name :"<<emp_name;
      cout<< "age :"<<age;
}
int main(){
    employee arr[10];
    for(int i=0;i<10 ;i++){
        cout<<"arr["<<i<<"] info:";
        arr[i].getinput();
    }
    int a;
    cout<<"which id do you want"<<endl;
    cin>>a;
    for(int i=0;i<10;i++){
        if(arr[i].emp_id==a){
            arr[i].display();
            break;
        }
        if(i==10){
            cout<<"no employee with such id";
        }
    }
    return 0;
}
