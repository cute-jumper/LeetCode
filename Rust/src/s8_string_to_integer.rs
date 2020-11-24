struct Solution;

impl Solution {
    pub fn my_atoi(s: String) -> i32 {
        let chars: Vec<char> = s.chars().skip_while(|&c| c == ' ').collect();
        if chars.is_empty() {
            return 0;
        }
        let mut index = 0;
        let is_negative = chars[0] == '-';
        if is_negative || chars[0] == '+' {
            index = 1;
        }
        let chars: Vec<&char> = chars[index..]
            .iter()
            .take_while(|c| c.is_numeric())
            .collect();
        if chars.is_empty() {
            return 0;
        }
        let min = ((1 << 31) as i32) as i64;
        let max = !min;
        let mut result = 0i64;
        for &&c in chars.iter() {
            result *= 10;
            result += (c as i64) - ('0' as i64);
            if is_negative && -result < min {
                return min as i32;
            } else if !is_negative && result > max {
                return max as i32;
            }
        }
        if is_negative {
            result = -result;
        }
        result as i32
    }
}

#[test]
fn test() {
    assert_eq!(42, Solution::my_atoi("42".to_owned()));
    assert_eq!(-42, Solution::my_atoi("      -42".to_owned()));
    assert_eq!(4193, Solution::my_atoi("4193 with words".to_owned()));
    assert_eq!(0, Solution::my_atoi("words and 987".to_owned()));
    assert_eq!(i32::MIN, Solution::my_atoi("-91283472332".to_owned()));
}
