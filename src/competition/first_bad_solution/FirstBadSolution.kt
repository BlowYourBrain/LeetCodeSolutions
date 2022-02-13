package competition.first_bad_solution

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution(badVersion: Int): VersionControl(badVersion) {
    fun firstBadVersion(n: Int) : Int {
        var up = n
        var down = 1
        var middle = calculateMiddle(up, down)

        while(up - down > 1){
            if (isBadVersion(middle)) {
                up = middle
            }else{
                down = middle
            }

            middle = calculateMiddle(up, down)
        }

        if (isBadVersion(down)) return down
        if (isBadVersion(up)) return up

        return -1
    }

    private fun calculateMiddle(up: Int, down: Int): Int {
        return down + (up - down) / 2
    }
}

open class VersionControl(private val badVersion: Int){
    fun isBadVersion(version: Int) = version <= badVersion
}