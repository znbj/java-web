package com.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.*;

public class Demo1 {
    /**
     * 验证 arr==>json
     */

    @Test
    public void test1(){
        String[] ss=new String[]{"tom","jack","rose"};
        JSONArray jsonArray = JSONArray.fromObject(ss);
        System.out.println(jsonArray);
    }
    /**
     * 验证 list==>json
     */

    @Test
    public void test2(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("xiaoming1");
        list.add("xiaoming2");
        list.add("xiaoming3");
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
    }
    /**
     * 验证 set==>json
     */

    @Test
    public void test3(){
        Set<Object> set = new HashSet<>();
        set.add("xiaoming1");
        set.add("xiaoming2");
        set.add("xiaoming3");
        JSONArray jsonArray = JSONArray.fromObject(set);
        System.out.println(jsonArray);

    }
    /**
     * 验证 map==>json
     */

    @Test
    public void test4(){
        Map map=new HashMap();
        map.put("name","tom");
        map.put("age",18);
        map.put("email","123@1213.com");

        JSONObject jsonObject = JSONObject.fromObject(map);
        System.out.println(jsonObject);

    }
    /**
     * 验证 javabean==>json
     */

    @Test
    public void test5(){
        User u1 = new User(1, "大郎");
        JSONObject jsonObject = JSONObject.fromObject(u1);
        System.out.println(jsonObject);
    }
    /**
     * 验证 list<javaBean></>==>json
     */

    @Test
    public void test6(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(new User(1, "大郎"));
        list.add(new User(2, "二郎"));
        list.add(new User(3, "太郎"));
        //原则 看外层
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);

    }






}
