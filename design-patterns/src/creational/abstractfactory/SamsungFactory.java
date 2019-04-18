package creational.abstractfactory;

import creational.abstractfactory.samsung.phone.Galaxy7;
import creational.abstractfactory.samsung.phone.GalaxyJ7;
import creational.abstractfactory.samsung.tablet.GalaxyTabA;
import creational.abstractfactory.samsung.tablet.GalaxyTabS2;

public class SamsungFactory implements MobileFactory {

    @Override
    public SmartPhone createSmartPhone(SmartPhoneType type) {
        SmartPhone phone = null;
        switch(type){
            case GalaxyJ7:
                phone = new GalaxyJ7();
                break;
            case Galaxy7:
                phone = new Galaxy7();
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
            case GalaxyTabA:
                tablet = new GalaxyTabA();
                break;
            case GalaxyTabS2:
                tablet = new GalaxyTabS2();
                break;
            default:
                break;
        }
        return tablet;
    }
}
