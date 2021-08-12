public class IndividualBusinessman extends Client {

    public IndividualBusinessman() {
        System.out.println(" Счет юридического лица. Доступный баланс - " + getAmount());
        System.out.println("При пополнении счета на сумму меньшую 1000руб. - комисиия 1%");
        System.out.println("При пополнении счета на сумму больше или равную 1000руб. - комисиия 0.5%");

    }

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000.0) {
            super.put(amountToPut * 0.99);
        }else {
            super.put(amountToPut*0.995);
        }

    }
}
