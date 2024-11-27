#include<iostream>
using namespace std;
class  Publication{
    public:
    string title;
    int price;
    string authors_name;
};
class Book :public Publication{
    public:
 int pcount;
 void getdata(){
    cout<<"title :";
    cin>>title;
    cout<<"price :";
    cin>>price;
    cout<<"pcount :";
    cin>>pcount;
 }
 void displaydata(){
    cout<<"title :";
    cout<<title<<endl;
    cout<<"price :";
    cout<<price<<endl;
    cout<<"pcount :";
    cout<<pcount<<endl;
 }

};

class Ebook :public Publication{
 int ptime;
 public:
 void getdata_e(){
     cout<<"title :";
    cin>>title;
    cout<<"price :";
    cin>>price;
    cout<<"ptime :";
    cin>>ptime;
 }
 void displaydata_e(){
    cout<<"title :";
    cout<<title<<endl;
    cout<<"price :";
    cout<<price<<endl;
    cout<<"ptime :";
    cout<<ptime<<endl;
 }
};
int main(){
    char c;
   cout<<"which BOOK";
   cin>>c;
   if(c=='E'){
    Ebook a;
    a.getdata_e();
    a.displaydata_e();
   }
   if(c=='B'){
    Book b;
    b.getdata();
    b.displaydata();
   
   }
};
