class RandomizedSet {

    
        private final List<Integer> list;
        private final Map<Integer, Integer> map;
        private final Random random;

        public RandomizedSet() {
            // your solution here
            list = new ArrayList<>();
            map= new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            // your solution here
            if (map.containsKey(val)) return false;

            map.put(val, list.size());
            list.add(val);
            return true;




        }

        public boolean remove(int val) {
            // your solution here
            if (!map.containsKey(val)) return false;

            int index = map.get(val);
            int last = list.get(list.size() - 1);

            list.set(index, last);
            map.put(last, index);

            list.remove(list.size() - 1);
            map.remove(val);

            return  true;


        }

        public int getRandom() {
            // your solution here
            return list.get(random.nextInt(list.size()));
        }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */