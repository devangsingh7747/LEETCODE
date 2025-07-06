/*
LEETCODE CONTEST QUESTION



You are given three arrays of length n that describe the properties of n coupons: code, businessLine, and isActive. The ith coupon has:

code[i]: a string representing the coupon identifier.
businessLine[i]: a string denoting the business category of the coupon.
isActive[i]: a boolean indicating whether the coupon is currently active.
A coupon is considered valid if all of the following conditions hold:

code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
isActive[i] is true.
Return an array of the codes of all valid coupons, sorted first by their businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant", and then by code in lexicographical (ascending) order within each category.



Example 1:

Input: code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]

Output: ["PHARMA5","SAVE20"]

Explanation:

First coupon is valid.
Second coupon has empty code (invalid).
Third coupon is valid.
Fourth coupon has special character @ (invalid).
Example 2:

Input: code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]

Output: ["ELECTRONICS_50"]

Explanation:

First coupon is inactive (invalid).
Second coupon is valid.
Third coupon has invalid business line (invalid).


Constraints:

n == code.length == businessLine.length == isActive.length
1 <= n <= 100
0 <= code[i].length, businessLine[i].length <= 100
code[i] and businessLine[i] consist of printable ASCII characters.
isActive[i] is either true or false.©leetcode
*/




import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> validCoupons = new ArrayList<>();
        Pattern alphanumericUnderscore = Pattern.compile("^[a-zA-Z0-9_]+$");

        String[] businessLineOrder = {"electronics", "grocery", "pharmacy", "restaurant"};
        
        for (int i = 0; i < code.length; i++) {
            boolean isCodeValid = code[i] != null && !code[i].isEmpty() && alphanumericUnderscore.matcher(code[i]).matches();

            boolean isBusinessLineValid = false;
            for (String category : businessLineOrder) {
                if (businessLine[i].equals(category)) {
                    isBusinessLineValid = true;
                    break;
                }
            }

            boolean isActiveValid = isActive[i];

            if (isCodeValid && isBusinessLineValid && isActiveValid) {
                validCoupons.add(new Coupon(code[i], businessLine[i]));
            }
        }

        Collections.sort(validCoupons, new Comparator<Coupon>() {
            @Override
            public int compare(Coupon c1, Coupon c2) {
                int index1 = getBusinessLineIndex(c1.businessLine, businessLineOrder);
                int index2 = getBusinessLineIndex(c2.businessLine, businessLineOrder);

                if (index1 != index2) {
                    return Integer.compare(index1, index2);
                } else {
                    return c1.code.compareTo(c2.code);
                }
            }
        });

        List<String> result = new ArrayList<>();
        for (Coupon coupon : validCoupons) {
            result.add(coupon.code);
        }

        return result;
    }

    private int getBusinessLineIndex(String bl, String[] order) {
        for (int i = 0; i < order.length; i++) {
            if (bl.equals(order[i])) {
                return i;
            }
        }
        return -1;
    }

    private static class Coupon {
        String code;
        String businessLine;

        public Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1:
        String[] code1 = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine1 = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive1 = {true, true, true, true};
        List<String> result1 = sol.validateCoupons(code1, businessLine1, isActive1);
        System.out.println("Example 1 Output: " + result1); // Expected: ["PHARMA5", "SAVE20"]

        // Example 2:
        String[] code2 = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine2 = {"grocery", "electronics", "invalid"};
        boolean[] isActive2 = {false, true, true};
        List<String> result2 = sol.validateCoupons(code2, businessLine2, isActive2);
        System.out.println("Example 2 Output: " + result2); // Expected: ["ELECTRONICS_50"]

        // Custom Test Case 1: All valid, different order
        String[] code3 = {"ZCOUPON", "ACODE", "BFOOD"};
        String[] businessLine3 = {"pharmacy", "electronics", "grocery"};
        boolean[] isActive3 = {true, true, true};
        List<String> result3 = sol.validateCoupons(code3, businessLine3, isActive3);
        System.out.println("Custom Test 1 Output: " + result3); // Expected: ["ACODE", "BFOOD", "ZCOUPON"] (sorted by business line, then code)

        // Custom Test Case 2: No valid coupons
        String[] code4 = {"INVALID@", "EMPTY", "INACTIVE"};
        String[] businessLine4 = {"electronics", "grocery", "pharmacy"};
        boolean[] isActive4 = {true, true, false};
        List<String> result4 = sol.validateCoupons(code4, businessLine4, isActive4);
        System.out.println("Custom Test 2 Output: " + result4); // Expected: []

        // Custom Test Case 3: Empty inputs (though constraints say n >= 1)
        String[] code5 = {};
        String[] businessLine5 = {};
        boolean[] isActive5 = {};
        List<String> result5 = sol.validateCoupons(code5, businessLine5, isActive5);
        System.out.println("Custom Test 3 Output: " + result5); // Expected: []
    }
}