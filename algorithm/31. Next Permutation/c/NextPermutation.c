// 2 1 7 6 5 4 3
// 2 3 1 4 5 6 7
// step 1: find the point where i > i-1
// step 2: swap i-1 with min of i+1 to numsSize
// step 3: reverse i+1 to numsSize
void nextPermutation(int* nums, int numsSize){
    int max = 0,min = numsSize-1,temp;
    for(int i = numsSize-1; i>0;i--){ // i[1,numsSize-1]
        if(nums[i] > nums[i-1]){
            max = i;
            break;
        }
    }
    for(int i = numsSize-1;i>max-1;i--){
        if(max>0 && nums[i]>nums[max-1]){
            min = i;
            break;
        }
    }
    // find min that > i-1
    // swap max-1 and min
    if(max > 0){
        temp = nums[min];
        nums[min] = nums[max-1];
        nums[max-1] = temp;
    }
    // reverse max to numsSize-1
    for(int l = max, r = numsSize-1;l<r;l++,r--){
        temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
