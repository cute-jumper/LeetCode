public class RamsonNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[256];
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i)]++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i)]--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) return false;
        }
        return true;
    }
}
