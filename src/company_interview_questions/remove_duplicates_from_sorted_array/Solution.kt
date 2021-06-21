package company_interview_questions.remove_duplicates_from_sorted_array

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        var prevNum: Int
        var prevNumPos: Int

        if (nums.isEmpty()){
            return 0
        }else{
            prevNum = nums.first()
            prevNumPos = 0
        }


        //index = 3
        //prevNum = 1
        //prevNumPos = 1
        while(index < nums.size){
            if (nums[index] == prevNum){
                //do nothing
            }else{
                prevNumPos++
                nums[prevNumPos] = nums[index]
                prevNum = nums[index]
            }

            index++
        }

        return prevNumPos + 1
    }
}