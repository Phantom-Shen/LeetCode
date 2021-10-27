/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
// mergesort:
//      get mid
//      divide by mid
//      merge and sort
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if(!head || !head->next) return head;
        ListNode *slow = head, *fast = head->next;
        while(fast&&fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode *right = slow->next;
        slow->next = NULL;
        return merge(sortList(head), sortList(right));
    }
private:
    ListNode *merge(ListNode* l, ListNode *r){
        if(!l) return r;
        if(!r) return l;
        if(l->val < r->val){
            l->next = merge(l->next,r);
            return l;
        }
        r->next = merge(l,r->next);
        return r;
    }
};
/*
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if(!head || !head->next) return head;
        ListNode *slow = head, *fast = head->next;
        while(fast&&fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode *right = slow->next;
        slow->next = NULL;
        return merge(sortList(head), sortList(right));
    }
private:
    ListNode *merge(ListNode *l, ListNode *r){
        if(!l) return r;
        if(!r) return l;
        if(l->val < r->val){
            l->next = merge(l->next, r);
            return l;
        }
        r->next = merge(l, r->next);
        return r;
    }
};
*/
