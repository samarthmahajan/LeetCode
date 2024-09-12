class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointerNum1 = m-1;
        int pointerNum2 = n-1;
        int pointerMain = n + m -1;

        while(pointerNum1 >= 0 && pointerNum2>=0){
            if(nums1[pointerNum1] > nums2[pointerNum2]){
                nums1[pointerMain] = nums1[pointerNum1];
                pointerNum1--;
            }else{
                nums1[pointerMain] = nums2[pointerNum2];
                pointerNum2--;
            }
            pointerMain--;
        }

        while(pointerNum2 >= 0){
            nums1[pointerMain] = nums2[pointerNum2];
            pointerNum2--;
            pointerMain--;
        }

    }
}