package com.jaewa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyPatternTest {
	
	ShoppingCart cart = new ShoppingCart();
    @Test
    public void testCreditCardPayment() {

        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "John Doe"));
        cart.checkout(100.0); // Expect to see "Paid 100.0 using Credit Card."
        
    }

    @Test
    public void testPayPalPayment() {

        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        cart.checkout(200.0); // Expect to see "Paid 200.0 using PayPal."
    }

    @Test
    public void testNoPaymentStrategy() {
        
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            cart.checkout(300.0);
        });
        assertEquals("Payment strategy not set", exception.getMessage());
    }
}

