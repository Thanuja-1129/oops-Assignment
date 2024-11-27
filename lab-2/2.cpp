#include<iostream>
using namespace std;
class due_date{
    public:

    int day;
    int duedate();
    int month;
    int year;
    int due_days;

        void current_date(){

            cout<<"day";
            cin>>day;

            cout<<"month";
            cin>>month;

            cout<<"year";
            cin>>year;

            cout<<"due_days";
            cin>>due_days;

        }
    };

    int due_date::duedate(){
      for(int i=1;i<=due_days;i++){

        if(day==31 && (month==1||3||5||7||9||11) ){

            day=1;
            month++;

        }

        else if(day==30 && (month==4||6||8||10||12)){
            if(month==12 && day==30){
                year++;
            }
            day=1;
            month++;

        }
        else if((day==28 ||day==29) && (month==2)){
            if((year%4==0 && day==29)||(year%4!=0 && day==28)){
                day=1;
                month++;
            }
            else if(year%4==0 && day!=29){
                day++;
            }
            else {
                day++;
            }
        }
      }
      cout<<"due date :"<<day<<"/"<<month<<"/"<<year;
    }
    int main(){
        due_date p;
        p.current_date();
        p.duedate();
    }