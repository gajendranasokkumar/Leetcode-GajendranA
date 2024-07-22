class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        People[] p = new People[names.length];
        for(int i=0;i<names.length;i++)
        {
            p[i] = new People(names[i], heights[i]);
        }

        Arrays.sort(p, (a,b) -> b.height - a.height);

        String[] result = new String[names.length];

        for(int i=0;i<names.length;i++)
        {
            result[i] = p[i].name;
        }

        return result;
    }
}

class People{
    String name;
    int height;
    public People(String n, int h)
    {
        name = n;
        height = h;
    }
}