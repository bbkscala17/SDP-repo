public class Driver {
    public static void main(String[] args) {
        Storage<BankAccount> aStorage = new Storage<>();
        Storage<String> sStorage = new Storage<>();

//        Class baCls = BankAccount.class;
        Class<BankAccount> baCls = BankAccount.class;
//        System.out.println(baCls);
        try {
//            Object myAccount = baCls.newInstance();
            BankAccount myAccount = baCls.newInstance();
//            BankAccount myAccount = (BankAccount)baCls.newInstance();
            System.out.println(myAccount);
            aStorage.setValue(myAccount);
            // Deposit
            myAccount.deposit(15);
        } catch (InstantiationException e) {
            System.err.println("Instantiation Exception");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("IllegalAccessException");
            e.printStackTrace();
        }

        System.out.println(aStorage.getValue().showBalance());

        System.out.println(aStorage.getClass());
        System.out.println(sStorage.getClass());
        if(aStorage.getClass() == sStorage.getClass()){
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT EQUAL");
        }
    }
}

