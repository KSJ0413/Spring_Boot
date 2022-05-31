package model; 

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

public class CommandService{ 

    /** 
     * 기본 생성자 
     */ 
    public CommandService() { 
        super(); 
    } 

    public StringBuffer getHello(){ 
        StringBuffer sb = new StringBuffer(); 
        sb.append("<li> 이름..MVC 입니다.<br>"); 
        sb.append("<li> Template Page<br>"); 
        sb.append("<li> URI Command Pattern<br>"); 
        sb.append("<li> Properties 파일을 이용한 처리입니다.<br>"); 
         
        return sb; 

    } 

    public String getDate(){ 
        Date dt = new Date(); 
        String str = dt.toLocaleString();  
         
        return str; 
    }

    public StringBuffer getMyinfo() {
      StringBuffer sb = new StringBuffer(); 
      sb.append("<li>이름:홍길동 .<br>"); 
      sb.append("<li> 전화번호: 111-1111-1111<br>"); 
      sb.append("<li> 주소:경기도 서울 북한<br>"); 
      sb.append("<li> 상세주소 : 151848-4848<br>"); 
      return sb;
    }

    public List<Map> getTeam() {
      List<Map>list = new ArrayList<Map>(); 
      Map map= new HashMap();
      map.put("name", "홍길동");
      map.put("skill", "JAVA, JSP, SPRING");
      map.put("phone", "010-1111-0000");
      map.put("address", "북한");

      list.add(map);
      
      
      map= new HashMap();
      map.put("name", "김길동");
      map.put("skill", "JAVA, JSP, ");
      map.put("phone", "010-0000-1111");
      map.put("address", "평양");

      list.add(map);
      
      
      
      map= new HashMap();
      map.put("name", "이길동");
      map.put("skill", "JAVA, SPRING");
      map.put("phone", "010-2222-0000");
      map.put("address", "함경북도");

      list.add(map);
      
      
      
      map= new HashMap();
      map.put("name", "삼길동");
      map.put("skill", "JSP, SPRING");
      map.put("phone", "010-0000-2222");
      map.put("address", "진군");

      list.add(map);
      
      
      
      
      map= new HashMap();
      map.put("name", "사길동");
      map.put("skill", "JAVA");
      map.put("phone", "010-3333-4444");
      map.put("address", "사화");

      list.add(map);
      return list;
    } 

}