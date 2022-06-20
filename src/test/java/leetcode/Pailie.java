package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 6/19/22 14:29
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/permutations/
 */
public class Pailie {
    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Pailie pl = new Pailie();
        pl.permute(nums).stream().forEach(e -> System.out.println(e));
    }
}
