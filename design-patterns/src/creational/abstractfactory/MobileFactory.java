package creational.abstractfactory;

public interface MobileFactory {

    SmartPhone createSmartPhone(SmartPhoneType type);
    Tablet createTablet(TabletType type);
}
