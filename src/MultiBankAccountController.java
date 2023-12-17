public class MultiBankAccountController {
    private BankAccount bankAccount;
    private MultiBankAccount multiBankAccount;

    public MultiBankAccountController(BankAccount newBankAccount) {
        bankAccount = newBankAccount;
        multiBankAccount = new MultiBankAccount(bankAccount);
    }

    public void processOpenAccount() {
        multiBankAccount.addAccount();
    }
}
