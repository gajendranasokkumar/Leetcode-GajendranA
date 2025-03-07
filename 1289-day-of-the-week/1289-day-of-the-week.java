class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int yearCode=year>=2000?6:0;
        if(year==2100)yearCode=4;
        String days[]={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int mon[]={0,3,3,6,1,4,6,2,5,0,3,5};
        int monthCode=mon[month-1];
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            if(month==1)monthCode=6;
            else if(month==2)monthCode=2;
        }
        int ans=(yearCode+monthCode+(year%100)+day+((year%100)/4))%7;
        return days[ans];
    }
}// day of the week calendar problem -1185