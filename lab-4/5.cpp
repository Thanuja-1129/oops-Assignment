#include<iostream>
using namespace std;
class employee{
    public:
int real;
int img;
inline void  getinput();
void display(){
    cout<<real<<" + "<<"i"<<img;
    }
friend employee mult(employee e,employee s);
};
void employee:: getinput(){
 cout<<"real";
 cin>>real;
 cout<<"img";
 cin>>img;
};
employee mult(employee &e,employee &s){
    employee a=e;
    employee b=s;
    employee ans;
   ans.real=(a->real)*(b->real) -(a->img)*(b->img);
    ans.img=((a->real)*(b->img))+((b->real)*(a->img));
    return ans;
}
int main(){
    employee a;
    a.getinput();
    employee b;
    b.getinput();
    employee ans=mult(a,b);
    ans.display();
}