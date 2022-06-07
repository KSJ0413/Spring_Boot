package com.example.validator;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller 
public class CalcController {
  public CalcController() {
    System.out.println("--> CalcController created.");
  }
  // http://localhost:8000/calc
  @GetMapping("/calc")
  public String calc() {
    return "/calc/form";
  }
  // 에러가 발생했을때 자동으로 이전 폼으로 이동
  @PostMapping("/calc")
  public String calc(CalcVO calcVO, 
             BindingResult result,
             Model model) {
     
    CalcValidator calcValidator = new CalcValidator();
    calcValidator.validate(calcVO, result);  // 검증
    
    if (result.hasErrors()) { // 에러 발생시
      return "/calc/form";
    } else { // 에러 미발생
      int payment = calcVO.getPrice() * calcVO.getCount();
      model.addAttribute("payment", payment);
      return "/calc/proc"; 
    }
  }  
}
