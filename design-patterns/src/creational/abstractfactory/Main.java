package creational.abstractfactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<SmartPhone> phones = new ArrayList<>();
        List<Tablet> tables = new ArrayList<>();

        /*
         * Apple Factory
         */
        MobileFactory appleFactory = MobileProducer.getMobileFactory(MobileFactoryType.AppleFactory);
        // Phones
        phones.add(appleFactory.createSmartPhone(SmartPhoneType.Iphone6));
        phones.add(appleFactory.createSmartPhone(SmartPhoneType.Iphone6Plus));
        // Tablet
        tables.add(appleFactory.createTablet(TabletType.IPadMini4));
        tables.add(appleFactory.createTablet(TabletType.IPadPro));

        /*
         * Sumsung Factory
         */
        MobileFactory sumsungFactory = MobileProducer.getMobileFactory(MobileFactoryType.SamsungFactory);
        // Phones
        phones.add(sumsungFactory.createSmartPhone(SmartPhoneType.GalaxyJ7));
        phones.add(sumsungFactory.createSmartPhone(SmartPhoneType.Galaxy7));
        // Tablet
        tables.add(sumsungFactory.createTablet(TabletType.GalaxyTabA));
        tables.add(sumsungFactory.createTablet(TabletType.GalaxyTabS2));

        /*
         * Display Phone Info
         */
        System.out.println("==========PHONE INFO=============");
        phones.forEach(phone->System.out.println(phone.info()));

        /*
         * Display Tablet Info
         */
        System.out.println("==========TABLET INFO=============");
        tables.forEach(table->System.out.println(table.info()));
    }
}
