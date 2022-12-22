import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JSCalculatorPage;
import utilities.ExcelUtils;

import java.lang.reflect.Method;

public class CalulatorTests extends BaseTest {

    @Test()
    public static void AddNumbers(Method m) {
        String num1 = ExcelUtils.getCellData(m.getName(), "num1");
        String num2 = ExcelUtils.getCellData(m.getName(), "num2");
        String result = ExcelUtils.getCellData(m.getName(), "result");
        JSCalculatorPage.enterNumber(num1);
        String numvalue1 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue1, num1, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("+");
        String oper = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(oper, num1 + "+", "Expression is not entered as expected");
        JSCalculatorPage.enterNumber(num2);
        String numvalue2 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue2, num1 + "+" + num2, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("=");
        String resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, result, "Result is not as expected");

    }

    @Test()
    public static void SubNumbers(Method m) {
        String num1 = ExcelUtils.getCellData(m.getName(), "num1");
        String num2 = ExcelUtils.getCellData(m.getName(), "num2");
        String result = ExcelUtils.getCellData(m.getName(), "result");
        JSCalculatorPage.enterNumber(num1);
        String numvalue1 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue1, num1, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("-");
        String oper = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(oper, num1 + "-", "Expression is not entered as expected");
        JSCalculatorPage.enterNumber(num2);
        String numvalue2 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue2, num1 + "-" + num2, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("=");
        String resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, result, "Result is not as expected");

    }

    @Test()
    public static void MulNumbers(Method m) {
        String num1 = ExcelUtils.getCellData(m.getName(), "num1");
        String num2 = ExcelUtils.getCellData(m.getName(), "num2");
        String result = ExcelUtils.getCellData(m.getName(), "result");
        JSCalculatorPage.enterNumber(num1);
        String numvalue1 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue1, num1, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("x");
        String oper = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(oper, num1 + "×", "Expression is not entered as expected");
        JSCalculatorPage.enterNumber(num2);
        String numvalue2 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue2, num1 + "×" + num2, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("=");
        String resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, result, "Result is not as expected");

    }

    @Test()
    public static void DivNumbers(Method m) {
        String num1 = ExcelUtils.getCellData(m.getName(), "num1");
        String num2 = ExcelUtils.getCellData(m.getName(), "num2");
        String result = ExcelUtils.getCellData(m.getName(), "result");
        JSCalculatorPage.enterNumber(num1);
        String numvalue1 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue1, num1, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("/");
        String oper = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(oper, num1 + "/", "Expression is not entered as expected");
        JSCalculatorPage.enterNumber(num2);
        String numvalue2 = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(numvalue2, num1 + "/" + num2, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("=");
        String resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, result, "Result is not as expected");

    }

    @Test()
    public static void ValidateInfinity(Method m) {
        String num1 = ExcelUtils.getCellData(m.getName(), "num1");
        String num2 = ExcelUtils.getCellData(m.getName(), "num2");
        String result = ExcelUtils.getCellData(m.getName(), "result");
        JSCalculatorPage.enterNumber(num1);
        JSCalculatorPage.enterOperation("/");
        JSCalculatorPage.enterNumber(num2);
        JSCalculatorPage.enterOperation("=");
        String resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, result, "Result is not as expected");

    }

    @Test()
    public static void ValidateErrors(Method m) {
        String num1 = ExcelUtils.getCellData(m.getName(), "num1");
        String num2 = ExcelUtils.getCellData(m.getName(), "num2");
        String result = ExcelUtils.getCellData(m.getName(), "result");
        JSCalculatorPage.enterNumber(num1);
        JSCalculatorPage.enterOperation("+");
        JSCalculatorPage.enterOperation("-");
        JSCalculatorPage.enterOperation("/");
        JSCalculatorPage.enterNumber(num2);
        JSCalculatorPage.enterOperation("=");
        String resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, result, "Result is not as expected");
        JSCalculatorPage.cleanText(resulteq);
        resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, "", "Result is not as expected");
        JSCalculatorPage.enterNumber("1234567890");
        JSCalculatorPage.enterOperation("/");
        JSCalculatorPage.enterOperation("x");
        JSCalculatorPage.enterOperation("-");
        JSCalculatorPage.enterOperation("+");
        JSCalculatorPage.enterOperation("+");
        JSCalculatorPage.enterOperation("-");
        JSCalculatorPage.enterOperation("x");
        JSCalculatorPage.enterOperation("/");
        JSCalculatorPage.enterOperation("=");
        resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, result, "Result is not as expected");

    }

    @Test()
    public static void ValidateCalculation() {
        JSCalculatorPage.enterNumber("12");
        JSCalculatorPage.enterOperation("x");
        JSCalculatorPage.enterNumber("2");
        JSCalculatorPage.enterOperation("+");
        JSCalculatorPage.enterNumber("6");
        JSCalculatorPage.enterOperation("+");
        JSCalculatorPage.enterNumber("6");
        JSCalculatorPage.enterOperation("x");
        JSCalculatorPage.enterNumber("90");
        JSCalculatorPage.enterOperation("/");
        JSCalculatorPage.enterNumber("010");
        JSCalculatorPage.enterOperation("=");
        String resulteq = JSCalculatorPage.validatetext();
        Assert.assertEquals(resulteq, "84", "Result is not as expected");

    }

    @Test()
    public static void ValidateButtons() {
        JSCalculatorPage.enterNumber("1234567890");
        JSCalculatorPage.enterOperation("=");
        String num = JSCalculatorPage.validateexpressionJs();
        String num1 = JSCalculatorPage.validatetext();
        Assert.assertEquals(num1, num, "Expression is not entered as expected");
        JSCalculatorPage.enterOperation("+");
        JSCalculatorPage.enterOperation("-");
        JSCalculatorPage.enterOperation("x");
        JSCalculatorPage.enterOperation("/");
        String resulteq = JSCalculatorPage.validateexpressionJs();
        JSCalculatorPage.cleanText(resulteq);
        resulteq = JSCalculatorPage.validateexpressionJs();
        Assert.assertEquals(resulteq, "", "Result is not as expected");
    }

}
