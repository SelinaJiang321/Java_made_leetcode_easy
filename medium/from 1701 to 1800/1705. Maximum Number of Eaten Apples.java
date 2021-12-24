/*
There is a special kind of apple tree that grows apples every day for n days. On the ith day, the tree grows apples[i] apples that will rot after days[i] days, that is on day i + days[i] the apples will be rotten and cannot be eaten. On some days, the apple tree does not grow any apples, which are denoted by apples[i] == 0 and days[i] == 0.

You decided to eat at most one apple a day (to keep the doctors away). Note that you can keep eating after the first n days.

Given two integer arrays days and apples of length n, return the maximum number of apples you can eat.

 

Example 1:

Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
Output: 7
Explanation: You can eat 7 apples:
- On the first day, you eat an apple that grew on the first day.
- On the second day, you eat an apple that grew on the second day.
- On the third day, you eat an apple that grew on the second day. After this day, the apples that grew on the third day rot.
- On the fourth to the seventh days, you eat apples that grew on the fourth day.
Example 2:

Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
Output: 5
Explanation: You can eat 5 apples:
- On the first to the third day you eat apples that grew on the first day.
- Do nothing on the fouth and fifth days.
- On the sixth and seventh days you eat apples that grew on the sixth day.
 

Constraints:

apples.length == n
days.length == n
1 <= n <= 2 * 104
0 <= apples[i], days[i] <= 2 * 104
days[i] = 0 if and only if apples[i] = 0.



*/

class Solution {
    public int eatenApples(int[] apples, int[] days) {
  PriorityQueue<Apple> minHeap = new PriorityQueue<Apple>((a, b) -> (a.validDay - b.validDay));
        
        //start from day 1
        int currentDay = 1;
        int eatenAppleCount = 0;
        
        for(int i = 0; i < apples.length; i++){
            
            //add apple count and their valid day
            if(apples[i] > 0 && days[i] > 0) {
                
                //current day is included
                int validDay = currentDay + days[i] - 1;
                
                minHeap.add(new Apple(apples[i], validDay));
            }

            
            //check for eatable apple
            while(!minHeap.isEmpty()){
                //get that applen, with minimum valid date (going to expiry soon)
                Apple apple = minHeap.remove();
                
                if(apple.validDay >= currentDay){
                    //eat 1 apple
                    apple.count--;
                    
                    //increment count
                    eatenAppleCount++;

                    //add remaiing apple, if not gonna expiry current day
                    if(apple.count > 0 && apple.validDay > currentDay){
                        minHeap.add(apple);
                    }
                    
                    break;
                }
            }
           
            //move to the next day
            currentDay++;
        }
        
        
        //eat stored apple
        while(!minHeap.isEmpty()){
            Apple apple = minHeap.remove();

            if(apple.validDay >= currentDay){
                //eat 1 apple
                apple.count--;
                
                //increment count
                eatenAppleCount++;
                
                //add remaiing apple, if not gonna expiry current day
                if(apple.count > 0 && apple.validDay > currentDay){
                    minHeap.add(apple);
                }
                
                //apple is eaten in current day, now move to next day
                currentDay++;
            }
        }
        
        
        return eatenAppleCount;
    }
}


class Apple {
    int count;
    int validDay;
    
    public Apple(int count, int validDay){
        this.count = count;
        this.validDay = validDay;
    }
}
