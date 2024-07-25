/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* deleteDuplicates(struct ListNode* head) {
     struct ListNode * temp;
     struct ListNode *i = head;
    while(i != NULL)
    {
        if(i->next != NULL && i->val == i->next->val)
        {
            temp = i->next;
            if(head == temp)
            {
                head = head->next;
            }
            else
            {
                while(i->next != NULL  && i->val == i->next->val)
                    i->next = i->next->next;
            }
            free(temp);
        }
        i = i->next;
    }
    return head;
}