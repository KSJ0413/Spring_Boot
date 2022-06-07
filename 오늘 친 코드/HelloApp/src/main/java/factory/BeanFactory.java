package factory;

public class BeanFactory {
public static TV getBean(String beanName) throws InstantiationException, IllegalAccessException {
Object obj = null;
  try {
   Class bean = Class.forName(beanName);
   obj = bean.newInstance();
  
} catch (ClassNotFoundException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
}
  return (TV)obj;
}
}
