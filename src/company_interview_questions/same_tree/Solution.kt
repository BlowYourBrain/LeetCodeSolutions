package company_interview_questions.same_tree

import binary_tree.TreeNode
import java.util.*

fun main(){
}

@ExperimentalStdlibApi
class Solution {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

        if ((p == null && q != null) || (p != null && q == null)){
            return false
        }

        val pQueue = LinkedList<TreeNode?>()
        val qQueue = LinkedList<TreeNode?>()

        pQueue.add(p)
        qQueue.add(q)

        var pNode: TreeNode?
        var qNode: TreeNode?

        while(!pQueue.isEmpty() && !qQueue.isEmpty()) {
            pNode = pQueue.poll()
            qNode = qQueue.poll()

            if (!((pNode == null && qNode == null) || (pNode?.`val` == qNode?.`val`))){
                return false
            }

            addNodeChildren(pQueue, pNode)
            addNodeChildren(qQueue, qNode)
        }

        return pQueue.isEmpty() && qQueue.isEmpty()
    }

    private fun addNodeChildren(queue: LinkedList<TreeNode?>, node: TreeNode?){
        node?.let{
            queue.add(it.left)
            queue.add(it.right)
        }
    }
}