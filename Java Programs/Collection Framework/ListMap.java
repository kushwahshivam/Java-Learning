import java.util.*;
class ListMap {
    public static void main(String[] args) {
        // Create a list of maps
        List<Map<String, Object>> listOfMaps = new ArrayList<>();
        
        // Create the first map and populate it
        Map<String, Object> map1 = new HashMap<>();
        map1.put("Name", "Hardik");
        
        // Create the second map and populate it
        Map<String, Object> map2 = new HashMap<>();
        map2.put("Class", 16);
        
        // Add maps to the list
        listOfMaps.add(map1);
        listOfMaps.add(map2);
        
        // Print the keys and values of each map in the list
        for (Map<String, Object> map : listOfMaps) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + " " + value);
            }
        }
    }
}
