package com.example.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
public class CalcValidator implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    // 검증할 객체의 클래스 타입 정보 명시
    return CalcVO.class.isAssignableFrom(clazz);
  }
  @Override
  public void validate(Object target, Errors errors) {
    CalcVO calcVO = (CalcVO) target;
    String menu = calcVO.getMenu();
    if (menu == null || menu.trim().isEmpty()) {
      System.out.println("menu가 등록이 누락되었습니다.");
      errors.rejectValue("menu", "error"); // 임의 값 지정 가능, 에러 발생을 나타냄
    }
    int price = calcVO.getPrice();
    if (price < 1000 || price >= 10000000) {
      System.out.println("금액은 1000원이상 천만원 이하여야합니다.");
      errors.rejectValue("price", "error");
    }
    int count = calcVO.getCount();
    if (count <= 0 || count >= 1000) {
      System.out.println("수량은 1개이상 천개 이하여야합니다.");
      errors.rejectValue("count", "error");
    }
  }
}
 