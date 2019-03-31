package algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//347 Given a non-empty array of integers, return the k most frequent elements.
public class TopKFrequentElemts {

    public List<Integer> solution(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1]; // index -> frequency , bucket[index] = {n1,n2 ...}
        HashMap<Integer, Integer> map = new HashMap<>();  // key->num , value->frequency

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }

        return res;
    }

}
