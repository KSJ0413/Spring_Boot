package factory;

public class TVUser {

  public static void main(String[] args) throws InstantiationException, IllegalAccessException {
TV tv = BeanFactory.getBean(args[0]);
tv.powerOn();
tv.powerOff();
tv.volumeUp();
tv.volumeDown();

}
}