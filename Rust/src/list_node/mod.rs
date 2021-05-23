// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }

    pub fn from_vec(numbers: Vec<i32>) -> Option<Box<Self>> {
        let mut head = Some(Box::new(ListNode::new(0)));
        let mut current = &mut head;
        for i in numbers {
            let node = Some(Box::new(ListNode::new(i)));
            current.as_mut().unwrap().next = node;
            current = &mut current.as_mut().unwrap().next;
        }
        head.unwrap().next
    }

    pub fn to_vec(list: Option<Box<Self>>) -> Vec<i32> {
        let mut result = vec![];
        let mut current = &list;
        while *current != None {
            result.push(current.as_ref().unwrap().val);
            current = &current.as_ref().unwrap().next;
        }
        result     
    }
}