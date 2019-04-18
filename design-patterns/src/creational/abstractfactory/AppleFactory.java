package creational.abstractfactory;

import creational.abstractfactory.apple.phone.IPhone6;
import creational.abstractfactory.apple.phone.IPhone6Plus;
import creational.abstractfactory.apple.tablet.IPadMini4;
import creational.abstractfactory.apple.tablet.IPadPro;

public class AppleFactory implements MobileFactory{
    @Override
    public SmartPhone createSmartPhone(SmartPhoneType type) {
        SmartPhone phone = null;
        switch(type){
            case Iphone6:
                phone = new IPhone6();
                break;
            case Iphone6Plus:
                phone = new IPhone6Plus();
                break;
            default:
                break;
        }
        return phone;
    }

    @Override
    public Tablet createTablet(TabletType type) {
        Tablet tablet = null;
        switch(type){
            case IPadMini4:
                tablet = new IPadMini4();
                break;
            case IPadPro:
                tablet = new IPadPro();
                break;
            default:
                break;
        }
        return tablet;
    }
}
