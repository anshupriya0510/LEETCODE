class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int size = cardPoints.length-k;
        int total = 0;
        for(int nums:cardPoints){
            total += nums;
        }
        int i=0; 
        int j=0;
        int sum = 0;
        while(j<size){
            sum += cardPoints[j];
            j++;
        }
        int min = sum;
        while(j<cardPoints.length){
            sum += cardPoints[j];
            sum -= cardPoints[i];
            min = Math.min(sum,min);
           i++ ;
            j++;

        }
        return total - min;
        
    }
}