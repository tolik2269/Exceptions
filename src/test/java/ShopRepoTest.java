import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ShopRepoTest {

    private ShopRepository shopRepository;

    @BeforeEach
    public void setup() {
        shopRepository = new ShopRepository();
        shopRepository.add(new Product(1, "Халва", 100));
        shopRepository.add(new Product(2, "вино", 200));
        shopRepository.add(new Product(3, "кола", 300));
    }

    @Test
    public void testRemoveExistingProduct() {
        int idRemove = 2;

        shopRepository.remove(idRemove);
        Product[] products = shopRepository.findAll();

        Assertions.assertEquals(2, products.length);
        Product[] expectedProducts = {new Product(1, "Халва", 100), new Product(3, "кола", 300)};
        Assertions.assertArrayEquals(expectedProducts, products);
    }


    @Test
    public void testRemoveNonExistingProduct() {
        int nonExistingProductId = 10;

        Assertions.assertThrows(NotFoundException.class, () -> shopRepository.remove(nonExistingProductId));
    }

}

