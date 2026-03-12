class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }

        boolean union(int a,int b){
            int pa=find(a), pb=find(b);
            if(pa==pb) return false;

            if(rank[pa]<rank[pb]) parent[pa]=pb;
            else if(rank[pb]<rank[pa]) parent[pb]=pa;
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left=0, right=200000, ans=-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(can(n,edges,k,mid)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return ans;
    }

    private boolean can(int n,int[][] edges,int k,int target){

        DSU dsu = new DSU(n);
        int count=0;
        int upgrades=0;

        List<int[]> good = new ArrayList<>();
        List<int[]> upg = new ArrayList<>();

        // handle mandatory edges
        for(int[] e: edges){

            int u=e[0], v=e[1], s=e[2], must=e[3];

            if(must==1){
                if(s < target) return false;

                if(!dsu.union(u,v)) return false;

                count++;
            }
            else{
                if(s >= target) good.add(e);
                else if(2*s >= target) upg.add(e);
            }
        }

        // use good edges first
        for(int[] e: good){
            if(dsu.union(e[0],e[1])){
                count++;
                if(count==n-1) return true;
            }
        }

        // use upgrade edges
        for(int[] e: upg){
            if(upgrades==k) break;

            if(dsu.union(e[0],e[1])){
                upgrades++;
                count++;
                if(count==n-1) return true;
            }
        }

        return count==n-1;
    }
}