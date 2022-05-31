package properties;

import java.io.InputStream;
import java.util.Scanner;

public class error {

  public static void main(String[] args) {
    
    //InputStream i = System.in; 
    //BufferedReader  r = new BufferedReader(new InputStreamReader(i)); 
    //System.out.println("파일명을 입력하세요"); 
    //String file = r.readLine(); 


    Scanner r = new Scanner(System.in); 
    System.out.println("파일명을 입력하세요"); 
    String file = r.nextLine(); 

    System.out.println(file); 
    
    while(true){ 
      if(file.indexOf(".")==-1 || file.startsWith(".")==true || file.endsWith(".")==true) {
       System.out.println("파일이 오류입니다. 다시 입력하세요.");
        file = r.nextLine();
      }else {
        int p = file.indexOf(".");
        String f =file.substring(0,p);
        String e = file.substring(p);
        System.out.println("파일앞부분:"+f);
        System.out.println("파일확장자:"+e);
        
        break;
        
      }
      
      
      

//      1. 오류파일 검사(indexOf(), startsWith(), endsWith()) 
//          1-1 오류파일인경우  
//              - 메세지 출력  
//              - 다시 file입력받기 
//          1-2 정상적인 파일인 경우 
//              - .의 위치 추출(indexOf()) 
//              - .의 앞부분 문자열값 추출(substring()) 
//              - .의 뒤부분 문자열값 추출 
//              - 출력하고 break; 

     } 
  }

}
