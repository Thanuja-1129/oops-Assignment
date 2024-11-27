#include<iostream>
using namespace std;
class student{
    string name;
    int total;
    public:
    student(string name,int total){
        this->name=name;
        this->total=total;
    }
};
int main(){
    cout<<"no. of students";
    int n;
    cin>>n;
    int max=0;
    string name;
    string topper_name;
    for(int i=0;i<n;i++){
        cout<<"name";
        string sname;
        cin>>sname;
        cout<<"total"<<endl;
        int a;
        cin>>a;
     student s(sname,a);
     if(max<a){
        topper_name=sname;
     }
    }
    cout<<"topper of class"<<topper_name;
}
