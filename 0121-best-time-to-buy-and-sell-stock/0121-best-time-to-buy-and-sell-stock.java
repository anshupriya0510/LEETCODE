class Solution {
    public int maxProfit(int[] prices) {
        /*int maxprofit = 0;
        int buyprice = prices[0];
        
        for(int i = 0;i<prices.length;i++){
            int currentbuy = prices[i]-buyprice;
            if(prices[i]<buyprice){
                buyprice= prices[i];
            }
            if(currentbuy>maxprofit){
                maxprofit=currentbuy;
            }
        }
        return maxprofit;
        
    }
}
class solution{
    public int maxprofit(int[]prices){*/
        int maxprofit = 0;
        int cp = prices[0];
        for(int i=0;i<prices.length;i++){
            cp=Math.min(cp,prices[i]);
            int profit = prices[i]-cp;
            maxprofit= Math.max(profit,maxprofit);
        }
        return maxprofit;
    }
}