class Solution {
    public String simplifyPath(String path) {
         Stack<String> stack = new Stack<>();
        String[] strArray = Arrays.stream(path.split("/+"))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        for (String dir : strArray){
            if("..".equals(dir) && !stack.isEmpty()){
                stack.pop();
                continue;
            }else if (".".equals(dir)  || "..".equals(dir)){
                continue;
            }
            stack.push("/"+dir);
        }

        return String.join("", stack).isEmpty()?"/":String.join("", stack);

        
    }
}