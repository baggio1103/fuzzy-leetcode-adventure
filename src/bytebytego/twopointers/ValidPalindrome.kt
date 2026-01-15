package bytebytego.twopointers

fun main() {
//    println(isPalindrome("A man, a plan, a canal: Panama"))
//    println(isStringPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isStringPalindrome("race a car"))
}

fun isPalindrome(string: String): Boolean {
    var left = 0
    var right = string.length - 1
    while (left < right) {
        when {
            !string[left].isLetterOrDigit() -> left++
            !string[right].isLetterOrDigit() -> right--
            string[left].lowercase() != string[right].lowercase() -> return false
            else -> {
                left++
                right--
            }
        }
    }
    return true
}

fun isStringPalindrome(string: String): Boolean {
    fun isValid(string: String, left: Int, right: Int): Boolean {
        if (left >= right) return true
        return when {
            !string[left].isLetterOrDigit() -> isValid(string, left + 1, right)
            !string[right].isLetterOrDigit() -> isValid(string, left, right - 1)
            string[left].lowercase() != string[right].lowercase() -> return false
            else -> isValid(string, left + 1, right - 1)
        }
    }
    return isValid(string, 0, string.length - 1)
}
