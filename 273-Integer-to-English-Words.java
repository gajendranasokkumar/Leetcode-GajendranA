// class Solution {
//     public String numberToWords(int num) {
//         if(num == 0)
//         {
//             return \Zero\;
//         }
//         List<String> numbers = Arrays.asList(\Zero\, \One\, \Two\, \Three\, \Four\, \Five\, \Six\, \Seven\, \Eight\, \Nine\);
//         List<String> eleven = Arrays.asList(\Ten\, \Eleven\, \Twelve\, \Thirteen\, \Fourteen\, \Fifteen\, \Sixteen\, \Seventeen\, \Eighteen\, \Nineteen\);
//         List<String> ten = Arrays.asList(\\, \Ten\, \Twenty\, \Thirty\, \Forty\, \Fifty\, \Sixty\, \Seventy\, \Eighty\, \Ninety\);
//         List<String> largeNumbers = Arrays.asList(\\, \Thousand\, \Million\, \Billion\, \Trillion\, \Quadrillion\, \Quintillion\, \Sextillion\, \Septillion\, \Octillion\, \Nonillion\);
//         String strnum = Integer.toString(num);
//         String result = \\;
//         List<String> list = new ArrayList<>();
//         int three=1, ones;
//         while(num != 0)
//         {
//             for(int i=1; num!=0 && i<=3; i++)
//             {
//                 ones = num%10;
//                 if(i == 1)
//                 {
//                     list.add(numbers.get(ones));
//                 }
//                 else if(i == 2)
//                 {
//                     if(ones == 1)
//                     {
//                         String prev = list.remove(list.size() - 1);
//                         int index = numbers.indexOf(prev);
//                         list.add(eleven.get(index));
//                     }
//                     else
//                     {
//                         if(list.get(list.size() - 1) == \Zero\) 
//                             list.remove(list.size() - 1);
//                         list.add(ten.get(ones));
//                     }
//                 }
//                 else
//                 {
//                     if(ones != 0)
//                     {
//                         list.add(\Hundred\);
//                         list.add(numbers.get(ones));
//                     }
//                 }
//                 num /= 10;
//             }
//             if(num != 0)
//             {
//                 list.add(largeNumbers.get(three++));
//             }
//         }
//         Collections.reverse(list);
//         // System.out.println(list);
//         int i=0;
//         for(i=0;i<list.size()-1;i++)
//         {
//             if(list.get(i) != \\)
//             result += list.get(i) + \ \;
//         }
//         if(list.size() != 0)
//             return (result + list.get(i)).strip();
//         return result.strip();
//     }
// }



import java.util.*;

class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return \Zero\;
        }

        List<String> numbers = Arrays.asList(\Zero\, \One\, \Two\, \Three\, \Four\, \Five\, \Six\, \Seven\, \Eight\, \Nine\);
        List<String> eleven = Arrays.asList(\Ten\, \Eleven\, \Twelve\, \Thirteen\, \Fourteen\, \Fifteen\, \Sixteen\, \Seventeen\, \Eighteen\, \Nineteen\);
        List<String> ten = Arrays.asList(\\, \Ten\, \Twenty\, \Thirty\, \Forty\, \Fifty\, \Sixty\, \Seventy\, \Eighty\, \Ninety\);
        List<String> largeNumbers = Arrays.asList(\\, \Thousand\, \Million\, \Billion\, \Trillion\, \Quadrillion\, \Quintillion\, \Sextillion\, \Septillion\, \Octillion\, \Nonillion\);

        String result = \\;
        List<String> list = new ArrayList<>();
        int three = 0; 
        int segment;

        while (num != 0) {
            segment = num % 1000; 
            if (segment != 0) {
                list.add(0, largeNumbers.get(three)); 
                list.add(0, threeDigitsToWords(segment, numbers, eleven, ten)); 
            }
            num /= 1000;
            three++;
        }

        return String.join(\ \, list).strip();
    }

    private String threeDigitsToWords(int num, List<String> numbers, List<String> eleven, List<String> ten) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        int remainder = num % 100;
        int tenUnit = remainder / 10;
        int oneUnit = remainder % 10;

        if (hundred != 0) {
            sb.append(numbers.get(hundred)).append(\ Hundred \);
        }
        if (remainder != 0) {
            if (remainder < 10) {
                sb.append(numbers.get(oneUnit));
            } else if (remainder < 20) {
                sb.append(eleven.get(remainder - 10));
            } else {
                sb.append(ten.get(tenUnit)).append(\ \);
                if (oneUnit != 0) {
                    sb.append(numbers.get(oneUnit));
                }
            }
        }

        return sb.toString().trim();
    }
}
