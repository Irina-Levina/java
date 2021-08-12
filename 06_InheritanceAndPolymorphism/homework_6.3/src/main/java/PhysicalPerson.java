public class PhysicalPerson extends Client {

    public PhysicalPerson() {
        System.out.println("Счет физ.лица. Доступный баланс - " + this.getAmount());
        System.out.println("Комиссии за пополнение и снятия нет");
    }
}

