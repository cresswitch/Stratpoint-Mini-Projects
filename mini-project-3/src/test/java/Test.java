import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ecart.Cart;
import org.ecart.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

class ECartTest {

    @Test
    void addToCart(){
        // test addition of new product, including handling of incorrect input
        Scanner scanner = new Scanner("a\n1\nproduct1\na\n1\n");
        Cart cart = new Cart();
        cart.addProduct(scanner);
        assertEquals(1, cart.getProducts().size());

        // test addition of existing product
        Scanner scanner2 = new Scanner("1\n");
        cart.addProduct(scanner2);
        assertEquals(1, cart.getProducts().size());
        assertEquals(2, cart.getProducts().get(0).getQuantity());
    }

    @Test
    void removeFromCart(){
        Product prod1 = new Product(1, "prod1", 10);
        Product prod2 = new Product(2, "prod2", 20);
        prod1.addQuantity();
        ArrayList<Product> toCart = new ArrayList<>();
        toCart.add(prod1);
        toCart.add(prod2);

        // ensure correct starting variables
        Cart cart = new Cart(toCart);
        assertEquals(2, cart.getProducts().size());
        assertEquals(2, cart.getProducts().get(0).getQuantity());
        assertEquals(1, cart.getProducts().get(1).getQuantity());

        // remove single item
        Scanner scanner = new Scanner("2\n");
        cart.removeProduct(scanner);
        assertEquals(1, cart.getProducts().size());

        // remove item not in cart
        Scanner scanner2 = new Scanner("2\n");
        cart.removeProduct(scanner2);
        assertEquals(1, cart.getProducts().size());

        // remove one out of two items
        Scanner scanner3 = new Scanner("1\n1\n");
        cart.removeProduct(scanner3);
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void getTotal(){
        Product prod1 = new Product(1, "prod1", 10.12);
        Product prod2 = new Product(2, "prod2", 20.67);
        prod1.addQuantity();
        ArrayList<Product> toCart = new ArrayList<>();
        toCart.add(prod1);
        toCart.add(prod2);

        // ensure creation and addition of Products
        Cart cart = new Cart(toCart);
        assertEquals(2, cart.getProducts().get(0).getQuantity());
        assertEquals(1, cart.getProducts().get(1).getQuantity());

        // test total
        assertEquals((10.12*2.0)+20.67, cart.totalPrice());
    }}
