package algorithms.strings;

/**
 * 字符串匹配算法
 */
public class StringMatcher {


    public static int violentStringMatcher(String source, String pattern) {
        int i = 0, j = 0;
        char[] s = source.toCharArray();
        char[] p = source.toCharArray();
        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                //匹配成功,i++ j++
                i++;
                j++;
            } else {
                //匹配失败,i回溯,j重置
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == p.length) {
            //匹配成功
            return i - j;
        } else {
            //匹配失败
            return -1;
        }
    }

    public static int KMPStringMatcher(String source, String pattern) {
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                //如果 j=-1,或当前字符匹配成功,则 i++,j++
                i++;
                j++;
            } else {
                //如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j] , next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * @param p
     * @return 匹配失败:-1 ，其它 匹配成功
     */
    private static int[] getNext(char[] p) {
        int[] next = new int[p.length];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                //不断递归前缀索引
                k = next[k];
            }
        }
        return next;
    }

}
