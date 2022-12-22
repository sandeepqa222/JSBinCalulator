package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.DriverManager;

import static utilities.UtilitiesManager.FindElement;

public class JSCalculatorPage {

    private static final By output = By.xpath("//div[@id='output']");
    private static final By expression = By.xpath("//input[@id='expression']");
    private static final By del = By.xpath("//button[@value='DEL' and contains(text(),'DEL')]");

    public static JSCalculatorPage enterNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            String genericnum = "//button[@value='{num}' and @class='numeric']";
            String fingenericnum = genericnum.replace("{num}", String.valueOf(input.charAt(i)));
            FindElement(fingenericnum).click();
        }
        return new JSCalculatorPage();
    }

    public static JSCalculatorPage cleanText(String input) {
        for (int i = 0; i < input.length(); i++) {
            FindElement(del).click();
        }
        return new JSCalculatorPage();
    }

    public static JSCalculatorPage cleanText(int delnum) {
        for (int i = 0; i < delnum; i++) {
            FindElement(del).click();
        }
        return new JSCalculatorPage();
    }

    public static JSCalculatorPage enterOperation(String input) {
        for (int i = 0; i < input.length(); i++) {
            String val = String.valueOf(input.charAt(i));
            String opr = "";
            switch (val) {
                case "=":
                    opr = "EQ";
                    break;
                case "+":
                    opr = "PLUS";
                    break;
                case "-":
                    opr = "MINUS";
                    break;
                case "x":
                    opr = "MULT";
                    break;
                case "/":
                    opr = "DIV";
                    break;
                default:
                    break;
            }
            String genericoperation = "//button[@class='operation' and contains(text(),'{opr}')]";
            String finGenericOperation = genericoperation.replace("{opr}", opr);
            FindElement(finGenericOperation).click();
        }
        return new JSCalculatorPage();
    }

    public static String validatetextJs() {
        return jsGetText(output);
    }

    public static String validatetext() {
        return FindElement(output).getText();
    }


    public static String validateexpressionJs() {
        return jsGetText(expression);
    }

    public static String jsGetText(By ele) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        return jse.executeScript("return arguments[0].value;", FindElement(ele)).toString();
    }


}
