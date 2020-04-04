package com.java.thread;

import java.sql.*;
import java.util.*;

/**
 * Created by wangww on 2019.4.15.
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        String ss = "fffe6b1f-9449-4afc-8cc0-223665c95c49|HUAWEI|HWI-AL00|HWI-AL00|android";
        String[] s = ss.split("\\|");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }


    public static Connection getCon() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/monitor_plat?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "mysql";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static List<String> getAllTableNames(String dbName) {
        List<String> tableNames = new ArrayList<>();
        Connection conn;
        try {
            conn = getCon();
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rest = dbmd.getTables(dbName, null, null, new String[]{"TABLE"});
            while (rest.next()) {
                tableNames.add(rest.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableNames;
    }


    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[nums.length - 1] % nums[i]) == 0) {
                index = i;
                continue;
            } else {
                index = -1;
                break;
            }
        }
        return index;
    }

    public static int pivotIndex2(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) return -1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int j = 0; j < len - 1; j++) {
            if ((sum - nums[j]) % 2 == 0) {
                return j;
            }
        }
        return -1;
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = arr[i];
        }
        return b;
    }

    public static int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == A[i - 1]) { // 排序后只有一种情况前后两数相等
                int tmp = A[i];
                A[i] = A[i - 1] + 1;
                cnt += A[i] - tmp; // （A[i] - tmp）为排序后后面减去前面的值
            }
        }
        return cnt;
    }


    public static int countCharacters(String[] words, String chars) {
        char[] charsArr = chars.toCharArray();
        int len = 0;
        Map<Integer, Character> map = new HashMap();
        for (String w : words) {
            char[] targetArr = w.toCharArray();
            for (char tempChar : targetArr) {
                for (int i = 0; i < charsArr.length; i++) {
                    if (tempChar == charsArr[i] && !map.containsKey(i)) {
                        map.put(i, tempChar);
                        break;
                    }
                }
            }
            if (w.length() == map.size()) {
                len += targetArr.length;
            }
            map.clear();
        }
        return len;
    }

    public static int longestPalindrome(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            System.out.println(c);
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x : cnt) {
            ans += x - (x & 1);
        }
        return ans < s.length() ? ans + 1 : ans;
    }

    public static int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!map.containsKey(cs[i])) {
                map.put(cs[i], 1);
            } else {
                int v = map.get(cs[i]) + 1;
                map.put(cs[i], v);
            }
        }
        return map;
    }
}
