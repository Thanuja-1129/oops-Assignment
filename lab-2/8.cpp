#include<iostream>
using namespace std;
class book{
 int price;
 string name;
 public:
 book(string name,int price){
    this->name=name;
    this->price=price;
 }
};
int main(){
    cout<<"no. of books in a subject"<<endl;
    int n;
    cin>>n;
    int max=10000;
    string name;
    string cheapest_book;
    for(int i=0;i<n;i++){
        cout<<"book name"<<endl;
        string bname;
        cin>>bname;
        cout<<"price :"<<endl;
        int a;
        cin>>a;
     book b(bname,a);
     if(max>a){
        cheapest_book=bname;
        max=a;
     }
    }
    cout<<"cheapest book :"<<cheapest_book;
}