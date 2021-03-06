package com.study.member;
import java.util.List;
import java.util.Map;
 
public interface MemberService {
        int duplicatedId(String id);
 
        int duplicatedEmail(String email);
 
        int create(MemberDTO dto);
 
        int loginCheck(Map<String, String> map);
 
        Map getGrade(String id);
 
        MemberDTO read(String id);
 
        int update(MemberDTO dto);
 
        int total(Map map);
 
        List<MemberDTO> list(Map map);
 
        int updateFile(Map map);
        
        MemberDTO mypage(String id);
                 
        String getId(Map<String, String> map);
        
        String getPw(Map<String, String> map);
 
}