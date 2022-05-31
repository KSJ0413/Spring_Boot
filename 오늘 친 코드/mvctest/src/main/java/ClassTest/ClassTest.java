package ClassTest;

interface Action{
  public void execute();
}
class Spring implements Action{

  @Override
  public void execute() {
System.out.println("따듯한 봄 입니다. -새싹");    
  }
  
}
class Summer implements Action{

  @Override
  public void execute() {
    System.out.println("더운 여름 입니다. -바다");    
    
  }
  
}
class Fall implements Action{

  @Override
  public void execute() {
    System.out.println("쌀쌀한 가을 입니다. -단풍");    
    
  }
  
}
class Winter implements Action{

  @Override
  public void execute() {
    System.out.println("추운 겨울 입니다. -폭설");    
    
  }
  
}
public class ClassTest {

  public static void main(String[] args) {
     String className = args[0];
     try {
      Class object  =    Class.forName(className);
      Action instance = (Action) object.newInstance();
      instance.execute();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
     
      e.printStackTrace();
    }
  }

}
