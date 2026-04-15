package nhannguyenh.datastructures;

public class StringDemo {

    public int getLengthOfString(String string) {
        return string.length();
    }

    public int findChar(String string, char character) {
        for (int index = 0; index < string.length(); index++) {
            if (character == string.charAt(index)) {
                return index;
            }
        }
        return -1;
    }
}
