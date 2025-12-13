class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("electronics", new ArrayList<>());
        map.put("grocery", new ArrayList<>());
        map.put("pharmacy", new ArrayList<>());
        map.put("restaurant", new ArrayList<>());

        int n = code.length;
        for (int i = 0; i < n; i++) {
            if (code[i].matches("^[a-zA-Z0-9_]+$") && isActive[i] && isAny(businessLine[i])) {
                map.get(businessLine[i]).add(code[i]);
            }
        }

        List<String> result = new ArrayList<>();
        String[] categoryOrder = {"electronics", "grocery", "pharmacy", "restaurant"};

        for (String category : categoryOrder) {
            List<String> codes = map.get(category);
            Collections.sort(codes);
            result.addAll(codes);
        }

        return result;
    }

    public boolean isAny(String str) {
        return str.equals("electronics") || str.equals("grocery") || str.equals("pharmacy") || str.equals("restaurant");
    }
}
