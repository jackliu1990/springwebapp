package com.liufeng.spring.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	MyTest01();
        assertTrue( true );
    }
    
    /**
     * Map 转换为 json
     */
    public void MyTest01()
    {
      Map<String, String> hashMap = new HashMap<String, String>();
      hashMap.put("name", "zhang");
      hashMap.put("sex", "1");
      hashMap.put("login", "Jack");
      hashMap.put("password", "123abc");

      try
      {
        ObjectMapper objectMapper = new ObjectMapper();
        String userMapJson = objectMapper.writeValueAsString(hashMap);

        JsonNode node = objectMapper.readTree(userMapJson);

        // 输出结果转意，输出正确的信息
        System.out.println(node.get("password").asText());
        // 输出不转意,输出结果会包含""，这是不正确的，除非作为json传递，如果是输出结果值，必须如上一行的操作
        System.out.println(node.get("name"));
      }
      catch (IOException e)
      {
      }
    }
}
