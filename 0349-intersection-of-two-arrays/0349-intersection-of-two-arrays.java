class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>(); 
        Set<Integer> s2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            s1.add(nums1[i]);

        }
        for(int i=0;i<nums2.length;i++){
            s2.add(nums2[i]);
        }
        int[] rest = new int[s1.size()];
        int k =0;
        for(int num:s1){
            if(s2.contains(num)){
                rest[k]=num;
                k= k+1;
            }
        }

        return Arrays.copyOfRange(rest,0,k);
    }
}