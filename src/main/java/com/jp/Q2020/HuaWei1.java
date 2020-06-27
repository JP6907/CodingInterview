package com.jp.Q2020;

import java.util.*;

public class HuaWei1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] names = line.split(",");
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<names.length;i++){
            String name = names[i];
            //判断非法输入
            for(int j=0;j<name.length();j++){
                boolean flag = true;
                if(j==0){//首字母大写
                    if(name.charAt(j)<'A'||name.charAt(j)>'Z')
                        flag = false;
                }else{//其它小写
                    if(name.charAt(j)<'a'||name.charAt(j)>'z')
                        flag = false;
                }
                if(!flag){
                    System.out.println("error.0001");
                    return;
                }
            }
            if(map.containsKey(name))
                map.put(name,map.get(name)+1);
            else
                map.put(name,1);

        }
        List<Employee> employees = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            employees.add(new Employee(key,map.get(key)));
        }
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.voteCount!=o2.voteCount){
                    return o2.voteCount - o1.voteCount;
                }else {
                    return o1.name.compareTo(o2.name);
                }
            }
        });
        System.out.println(employees.get(0).name);
    }

    public static class Employee{
        public String name;
        public int voteCount;

        public Employee(String name, int voteCount) {
            this.name = name;
            this.voteCount = voteCount;
        }
    }
}
