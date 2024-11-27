#include<iostream>
using namespace std;
class area{
    int h;
    int w;
    int l;
    public:
    void getinput(){
        cout<<"height:";
        cin>>h;
        cout<<"width:";
        cin>>w;
        cout<<"length:";
        cin>>l;
    }
    float A_O_cuboid(){
        float a=2*(h*w + w*l + l*h);
        cout<<"area of cuboid :"<<a;
        return a;
    }
     friend class ctoc;
};
class ctoc{
    public:
  void cube(area &s){
  int a=min(s.h,s.w);
  int m=min(s.l,a);
  cout<<"it can be done by taking side of cube as"<<m;
  }
};
int main(){
    area A;
    A.getinput();
    A.A_O_cuboid();
    ctoc b;
    b.cube(A);
}
