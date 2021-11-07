class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        // reverse the numbers
        StringBuilder rev1 = new StringBuilder(num1);
        StringBuilder rev2 = new StringBuilder(num2);
        rev1.reverse();
        rev2.reverse();
        
        // multiply each digit and store them in correct position
        int[] nums = new int[n1+n2];
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                nums[i+j] += (rev1.charAt(i)-'0')*(rev2.charAt(j)-'0');
            }
        }
        // normalize the list. make every slot contain only single digit int number
        for(int i = 1; i < n1+n2; i++){
            nums[i] += nums[i-1]/10;
            nums[i-1] %= 10;
        }
        
        // convert to string, reverse back before return
        StringBuilder result = new StringBuilder();
        int i = n1+n2-1;
        while(i>0 && nums[i]==0) i--;
        while(i>=0){
            result.append(nums[i--]);
        }
        return result.toString();
    }
}
