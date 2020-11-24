struct Solution;

impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        let num_rows = num_rows as usize;
        let group_count = 2 * num_rows - 2;
        if group_count == 0 {
            return s;
        }
        let chars: Vec<char> = s.chars().collect();
        let mut result = String::new();
        for i in 0..num_rows {
            for j in (i..s.len()).step_by(group_count) {
                result.push(chars[j]);
                let next = j + group_count - 2 * i;
                if i > 0 && i < num_rows - 1 && next < s.len() {
                    result.push(chars[next]);
                }
            }
        }
        result
    }
}

#[test]
fn test() {
    assert_eq!(
        "PAHNAPLSIIGYIR".to_owned(),
        Solution::convert("PAYPALISHIRING".to_owned(), 3)
    );
    assert_eq!(
        "PINALSIGYAHRPI".to_owned(),
        Solution::convert("PAYPALISHIRING".to_owned(), 4)
    );
    assert_eq!("A".to_owned(), Solution::convert("A".to_owned(), 1));
}
