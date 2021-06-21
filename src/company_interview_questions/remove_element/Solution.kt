package company_interview_questions.remove_element

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var prevPosition = 0
        var index = 0

        if (nums.isEmpty()){
            return 0
        }

        //index = 4
        //prevPosition = 2
        while(index < nums.size){
            if (nums[index] == `val`){
                //do nothing
            }else{
                nums[prevPosition] = nums[index]
                prevPosition++
            }
            index++
        }

        return prevPosition
    }
}