class Solution {
    public int robotSim(int[] cmd, int[][] obs) {
        Set<String> st = new HashSet<>();
        for(int[] ob:obs){
            String key = ob[0]+"_"+ob[1];
            st.add(key);
        }
        int mxD=0;
        int x=0,y=0;
        int[] dir = {0,1};
        for(int i=0;i<cmd.length;i++){
            if(cmd[i]==-2){//left (x,y)->(-y,x)
                dir = new int[]{-dir[1], dir[0]};
            }else if(cmd[i]==-1){//right (x,y->(y,-x))
                dir = new int[]{dir[1], -dir[0]};
            }else{
                for(int steps=0;steps<cmd[i];steps++){
                    int newX=dir[0]+x;
                    int newY=dir[1]+y;
                    String newKey = newX+"_"+newY;
                    if(st.contains(newKey)) break;
                    x = newX;
                    y = newY;
                }
            }
            mxD = Math.max(mxD,x*x+y*y);
        }
        return mxD;
    }
}