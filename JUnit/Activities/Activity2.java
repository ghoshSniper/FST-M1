import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Activity2
{
	@Test
	void notEnoughFunds() {
		// Create an object for BankAccount class
		BankAccount account = new BankAccount(9);

		// Assertion for exception
		assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10),
				"Balance must be greater than amount of withdrawal");
	}

	@Test
	void enoughFunds() {
		// Create an object for BankAccount class
		BankAccount account = new BankAccount(100);

		// Assertion for no exceptions
		assertDoesNotThrow(() -> account.withdraw(100));
	}



	@SuppressWarnings("serial")
	public class NotEnoughFundsException extends RuntimeException {

		public NotEnoughFundsException(Integer amount, Integer balance) {
			super("Attempted to withdraw " + amount + " with a balance of " + balance);
		}

	}
	public class BankAccount {
		private Integer balance;

		// Create a constructor
		public BankAccount(Integer initialBalance) {
			balance = initialBalance;
		}

		// Add method to calculate
		// balance amount after withdrawal
		public Integer withdraw(Integer amount) {
			if (balance < amount) {
				throw new NotEnoughFundsException(amount, balance);
			}
			balance -= amount;
			return balance;
		}
	}
}

