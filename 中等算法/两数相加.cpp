/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *result;
        ListNode *start;
        start=new ListNode;
        result=start;
        int temp=0;    //进位
        while(l1!=NULL||l2!=NULL)  //结点不空时循环
        {
            if(l1!=NULL&&l2!=NULL)  //两个结点都不空时
            {
                if((l1->val+l2->val+temp)>9)
                {
                    result->val=(l1->val+l2->val+temp)%10;
                    temp=1;
                }
                else
                {
                    result->val=l1->val+l2->val+temp;
                    temp=0;
                }
                l1=l1->next;
                l2=l2->next;
            }
            else if(l1!=NULL)    //只有l1结点还有数时
            {
                if((l1->val+temp)>9)
                {
                    result->val=(l1->val+temp)%10;
                    temp=1;
                }
                else
                {
                    result->val=l1->val+temp;
                    temp=0;
                }
                l1=l1->next;
            }
            else   //只有l2结点还有数时
            {
                if((l2->val+temp)>9)
                {
                    result->val=(l2->val+temp)%10;
                    temp=1;
                }
                else
                {
                    result->val=l2->val+temp;
                    temp=0;
                }  
                l2=l2->next;
            }
            if(l1!=NULL||l2!=NULL)   //结果链表创建新结点
            {
                result->next=new ListNode;
                result=result->next;
            }
        }
        if(temp==1)
        {
            result->next=new ListNode;
            result=result->next;
            result->val=1;
            temp=0;
        }
        return start;
}
};
