#include <iostream>
using namespace std;
class data{

    private:
        int day;
        int month;
        int year;

    public:

        // data(){

        //     this->day=12;
        //     this->month=10;
        //     this->year=1993;

        // }
        data(int day=12,int month=10,int year=2000){

             cout<<"day";
             cin>>day;
             
             cout<<"month";
             cin>>month;

             cout<<"year";
             cin>>year;

        }

        data(data &p){

            p.day=day;
            p.month=month;
            p.year=year;

        }

};
int main(){
    data p(12,10,2000);
    data p2(p);
}
