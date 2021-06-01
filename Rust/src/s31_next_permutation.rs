struct Solution;

impl Solution {
    pub fn next_permutation(nums: &mut Vec<i32>) {
        let mut index = nums.len() as i32 - 2;
        while index >= 0 && nums[index as usize] >= nums[index as usize + 1] {
            index -= 1;
        }
        if index >= 0 {
            let mut replacement = nums.len() - 1;
            while replacement > index as usize && nums[replacement] <= nums[index as usize] {
                replacement -= 1;
            }
            nums.swap(index as usize, replacement);
        }
        nums[(index + 1) as usize..].reverse()
    }
}

#[test]
fn test() {
    assert_next_permutation(vec![1, 2, 3], vec![1, 3, 2]);
    assert_next_permutation(vec![3, 2, 1], vec![1, 2, 3]);
    assert_next_permutation(vec![1, 1, 5], vec![1, 5, 1]);
    assert_next_permutation(vec![1], vec![1]);
}

fn assert_next_permutation(mut input: Vec<i32>, expected: Vec<i32>) {
    Solution::next_permutation(&mut input);
    assert_eq!(expected, input);
}
