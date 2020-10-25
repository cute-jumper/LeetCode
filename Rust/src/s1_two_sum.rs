struct Solution;

use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map: HashMap<i32, i32> = HashMap::new();
        for (i, &n) in nums.iter().enumerate() {
            match map.get(&(target - n)) {
                Some(&index) => return vec![index, i as i32],
                _ => {
                    map.insert(n, i as i32);
                }
            }
        }
        vec![]
    }
}

#[test]
fn test() {
    assert_eq!(vec![0, 1], Solution::two_sum(vec![3, 1, 4, 2], 4));
    assert_eq!(Vec::<i32>::new(), Solution::two_sum(vec![3, 1, 4, 2], 10));
}
