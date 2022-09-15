import junit.framework.Assert.assertEquals
import org.junit.Test
import task_2.calculateTax

class MainKtTest {

    @Test
    fun calculateTaxType1IfTrue() {
        val type = 1
        val sum = 500_000
        val previousSum = 5_000_000
        val result = calculateTax(type, sum, previousSum)
        assertEquals(0.0, result)
    }

    @Test
    fun calculateTaxType1IfFalse() {
        val type = 1
        val sum = 500_000
        val previousSum = 8_500_000
        val result = calculateTax(type, sum, previousSum)
        val expectedResult = (sum * 0.006) + 2000
        assertEquals(expectedResult, result)
    }

    @Test
    fun calculateTaxType2IfTrue() {
        val type = 2
        val sum = 200_000
        val previousSum = 1_000_000
        val result = calculateTax(type, sum, previousSum)
        assertEquals(3500.0, result)
    }

    @Test
    fun calculateTaxType2IfFalse() {
        val type = 2
        val sum = 500_000
        val previousSum = 8_500_000
        val result = calculateTax(type, sum, previousSum)
        assertEquals(0.0, result)
    }
    @Test
    fun calculateTaxType0() {
        val type = 0
        val sum = 500_000
        val previousSum = 8_500_000
        val result = calculateTax(type, sum, previousSum)
        assertEquals(0.0, result)
    }
}

