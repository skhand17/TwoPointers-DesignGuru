
/*
*
* Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
Example 2:

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
Example 3:

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
Example 4:

Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
*
*
* */
public class ComparingStringsContainBackSpaces {

    public static void main(String[] args) {

        String str1 = "xyz##";
        String str2 = "xp#";

        boolean equal = compare(str1, str2);
        System.out.println(equal);
    }

    public static int getValidNextIndex(String str, int index) {
        int backSpaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backSpaceCount++;
            } else if (backSpaceCount > 0)
                backSpaceCount--;
            else
                break;

            index--;
        }
        return index;
    }


    public static boolean compare(String str1, String str2) {

        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;

        while (index2 >= 0 && index1 >= 0) {

            int validIndex1 = getValidNextIndex(str1, index1);
            int validIndex2 = getValidNextIndex(str2, index2);

            if (validIndex1 < 0 && validIndex2 < 0)
                return true;

            if (validIndex1 < 0 || validIndex2 < 0)
                return false;

            if (str1.charAt(validIndex1) != str2.charAt(validIndex2))
                return false;

            index1 = validIndex1 - 1;
            index2 = validIndex2 - 1;
        }

        return true;
    }
}
