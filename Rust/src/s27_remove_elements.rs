struct Solution;

impl Solution {
    pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
        let mut index = 0;
        for i in 0..nums.len() {
            if nums[i] != val {
                nums[index] = nums[i];
                index += 1;
            }
        }
        index as i32
    }
}

#[test]
fn test() {
    assert_eq!(2, Solution::remove_element(&mut vec![3,2,2,3], 3));
    assert_eq!(5, Solution::remove_element(&mut vec![0,1,2,2,3,0,4,2], 2));
}