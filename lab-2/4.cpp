#include<iostream>
using namespace std;
class student{
    private:
    int admno;
    char name[20];
    float marksEng;
    float marksMaths;
    float marksSci;
    float total;
    int compute(){
         return marksEng + marksMaths + marksSci;
    }
    public:
    void readData(){
        int admno;
        char name;
        float marksEng;
        float marksMaths;
        float marksSci;
        float total;
        cout<<"admno :";
        cin>>admno;
        this->admno=admno;
        cout<<"name :";
        cin>>name;
        this->name[10]=name;
        cout<<"marksEng :";
        cin>>marksEng;
        this->marksEng=marksEng;
        cout<<"marksSci :";
        cin>>marksSci;
        this->marksSci=marksSci;
        total=compute();
        this->total=total;
        cout<<"total :"<<total;
    }
    void displayData(){
        cout<<"admno :";
        cout<<admno;
        cout<<"name :";
    cout<<name[20];
    cout<<"marksEng :";
    cout<<marksEng;
    cout<<"marksMaths :";
    cout<<marksMaths;
    cout<<"marksSci :";
    cout<<marksSci;
    cout<<"total";
      cout<<total;
    }

};
int main(){
    student s;
    s.readData();
    s.displayData();
}