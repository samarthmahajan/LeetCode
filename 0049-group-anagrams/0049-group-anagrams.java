class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = new char[26];
            for (char ch : str.toCharArray())
                chars[ch - 'a']++;

            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(str);
        }
        return  new ArrayList<>(map.values());
    }
}