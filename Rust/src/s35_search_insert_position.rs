struct Solution;

impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        let mut low = 0_usize;
        let mut high = nums.len();
        while low < high {
            let mid = low + (high - low) / 2;
            if nums[mid] == target {
                return mid as i32;
            } else if nums[mid] < target {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        low as i32
    }
}

#[test]
fn test() {
    assert_eq!(2, Solution::search_insert(vec![1, 3, 5, 6], 5));
    assert_eq!(1, Solution::search_insert(vec![1, 3, 5, 6], 2));
    assert_eq!(4, Solution::search_insert(vec![1, 3, 5, 6], 7));
    assert_eq!(0, Solution::search_insert(vec![1, 3, 5, 6], 0));
    assert_eq!(0, Solution::search_insert(vec![1], 0));
}
