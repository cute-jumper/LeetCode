struct Solution;

use std::cmp;
impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        let mut max = 0;
        let (mut start, mut end) = (0usize, height.len() - 1);
        while start < end {
            max = cmp::max(
                max,
                (end - start) * (cmp::min(height[start], height[end])) as usize,
            );
            if height[start] < height[end] {
                start += 1
            } else {
                end -= 1
            }
        }
        max as i32
    }
}

#[test]
fn test() {
    assert_eq!(Solution::max_area(vec![1, 1]), 1);
    assert_eq!(Solution::max_area(vec![4, 3, 2, 1, 4]), 16);
    assert_eq!(Solution::max_area(vec![1, 2, 1]), 2);
}
