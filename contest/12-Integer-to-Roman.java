class Solution {
    public String intToRoman(int num) 
    {
        String ths[]={\\,\M\,\MM\,\MMM\};
        String hus[]={\\,\C\,\CC\,\CCC\,\CD\,\D\,\DC\,\DCC\,\DCCC\,\CM\};
        String tens[]={\\,\X\,\XX\,\XXX\,\XL\,\L\,\LX\,\LXX\,\LXXX\,\XC\};
        String ones[]={\\,\I\,\II\,\III\,\IV\,\V\,\VI\,\VII\,\VIII\,\IX\};
        StringBuilder sb=new StringBuilder();
        sb.append(ths[num/1000]).append(hus[(num%1000)/100]).append(tens[(num%100)/10]).append(ones[num%10]);
        return sb.toString();
    }
}