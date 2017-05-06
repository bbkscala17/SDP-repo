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
// why use generics for Storage object?  Because we may have more than one type of thing we want to store
// and can use the same Storage object to store them.  What are the benefits?  It may save
//time and complexity over implementing different Storage classes for each type, while remaining
//easy to read and understand what is going on

//Q3 when complie get this error:
        //Driver.java:12: error: method setValue in class Storage<T> cannot be applied to given types;
        //            aStorage.setValue(myAccount);
        //                    ^
        //                    required: BankAccount
        //                    found: Object
        //                    reason: argument mismatch; Object cannot be converted to BankAccount
        //                    where T is a type-variable:
        //                    T extends Object declared in class Storage
        //Driver.java:14: error: cannot find symbol
        //        myAccount.deposit(15);
        //        ^
        //        symbol:   method deposit(int)
        //        location: variable myAccount of type Object
        //        2 errors

// The problem is that
// - we have an object of type "BankAccount" contained in the Storage<T> object
// - then we call the aStorage.setValue(T value) method on that object, it also requires a type T (i.e. a "BankAccont" object again)
// - but we send it the argument myAccount, which is of type Object instead

//Q4 If we change the line
//        Object myAccount = baCls.newInstance();
//        to
//        BankAccount myAccount = baCls.newInstance();
//we still get an error:
//Driver.java:10: error: incompatible types: Object cannot be converted to BankAccount
//        BankAccount myAccount = baCls.newInstance();
// here the error has moved 2 lines earlier in the code than it was before.
// Instead of saying
// //        BankAccount myAccount = baCls.newInstance();
// we could have said
//          BankAccount myAccount = new BankAccount();
// then there would be no error.
// The object produced by baCls.newInstance(); *is* a BankAccount as if we create it as Object then print it we get BankAccount@7852e922
// but for some reason it is not recognised as such by the compiler when we try to assign it to BankAccount myAccount
// https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#newInstance--

//Q5 if I add a cast then it does compile i.e. BankAccount myAccount = (BankAccount)baCls.newInstance();

//Q6 if I remove the cast from Q5 and then replace
//        Class baCls = BankAccount.class;
    //with
//Class<BankAccount> baCls = BankAccount.class;
// then it does compile.  This is because generics have a role in the Class<T> and in partilcar the newInstance method returns a type T instance
// ie in this case when we did not specify a type for T it returned an object
// https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html


//Q7 if i add the code specified then the runtime output is
//        115.0
//        EQUAL
// The value of aStorage is what you wouild expect as it is 100 balance + 15
// The "EQUAL" is also what you would expect as both sStorage and aStorage are of type Storage
// and the fact that one might be Storage<String> does not affect this.

