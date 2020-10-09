package binary_tree

class LevelOrderSolution {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()

        var lvl = mutableListOf<TreeNode>()
        lvl.add(root)

        while (true) {
            result.add(lvl.toIntList())
            val nextLvl = mutableListOf<TreeNode>()
            lvl.forEach { node ->
                node.left?.let { nextLvl.add(it) }
                node.right?.let { nextLvl.add(it) }
            }
            if (nextLvl.isEmpty()){
                break
            }
            lvl = nextLvl
        }

        return result
    }

    fun MutableList<TreeNode>.toIntList(): List<Int> {
        val resultList = mutableListOf<Int>()
        forEach { resultList.add(it.`val`) }
        return resultList
    }

}