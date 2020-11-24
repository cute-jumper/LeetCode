struct Solution;

impl Solution {
    pub fn reverse(x: i32) -> i32 {
        let (mut r, mut x) = (0i64, x as i64);
        let min = ((1 << 31) as i32) as i64;
        let max = !min;
        while x != 0 {
            let d = x % 10;
            r = r * 10 + d;
            if r > max || r < min {
                return 0;
            }
            x /= 10;
        }
        r as i32
    }
}

#[test]
fn test() {
    assert_eq!(123, Solution::reverse(321));
    assert_eq!(-321, Solution::reverse(-123));
    assert_eq!(21, Solution::reverse(120));
    assert_eq!(0, Solution::reverse(0));
    assert_eq!(0, Solution::reverse(i32::MAX));
}
