use structopt::StructOpt;
mod s1_two_sum;
mod s2_add_two_numbers;
mod s3_length_of_longest_substring;
mod s5_longest_palindrome;
mod s6_zigzag;
mod s7_reverse_integer;
mod s8_string_to_integer;
mod s9_palindrome_number;

#[derive(Debug, StructOpt)]
#[structopt(name="Leetcode problem parser", about = "Argument parser to parse the leetcode problem")]
struct Args {
    #[structopt(short="n", long="name")]
    name: String
}

fn main() {
    //let args = Args::from_args();
}
