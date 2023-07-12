import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class css_Selector extends TestBase {

    @Test
    public void cssSelectorTesti(){
        driver.get("https://theautomationzone.blogspot.com/2020/07/css-selector-practice.html");

        System.out.println(driver.findElement(By.cssSelector("#id1")).getText());
        System.out.println(driver.findElement(By.cssSelector(".class1")).getText());
        System.out.println(driver.findElement(By.cssSelector("[name=name1]")).getText());
        System.out.println(driver.findElement(By.cssSelector("[name=a][id=a]")).getText());
    }
}
/*
    CSS SElector with id:
 [id='id1'] Burada // ile baslamiyoruz ve parantez sonrasi @ kullanmiyoruz.
 id'yi almak isteyince CSS de basa sadece # yazinca #id bize unique olani kolayca verir
 .class1 css ile unique olarak aliriz
 [name=name1] bize unique olani verdi.
 Eger bizim attribute'umuz bir value degil de bir fonksiyon donduruyorsa orengin onclick="change()" bize bir method donduruyor. change() bu bir fonksiyondur. [onclick='change()'] seklinde
 lacate'i unique olarak aliriz. fonksiyon ise her iki yaninda tek tirnak kullanmaliyiz.

 Multiple Attribute Changes: Locate alirken unique olani alamadik. p[name="a"] ancak birden fazla attribute yazarak daha guclu bir locate alma islemi olabilir. p[name=a][id=a]
 Parent/ Child
 xpath ile farki parent ile child arasinda > isaretini koyariz
 div[id=div1]>label[id=label]  div tagi icerisinde dogrudan child'i olarak label[id=label]'i bulduk. Eger dogrudan child degil ancak torunu ise araya > yerine bosluk(space) koyariz.
 Starts with ozelligi icin [ basinda id^ Ends with ozelligi icin id$, contains icin id* isaretlerini yazariz. Biz bir degerin bir kisminda degisiklik oldugunu biliyorsak bunlari kullaniriz.
 Bildigimiz degismeyen kismi almaya calisiriz. Ornegin p[id^='Class_AZ'  (id=Class_AZ8am ya da _AZ10am yaziyordu. AZ sonrasi degisiyordu bu nedenle starts with ^ isareti ve degismeyen degeri
 kullandik.
 CSS xpath'e gore daha hislidir. CSS'de index olmadigi soylense de kullanilir. indexi parent child olarak aldigimiz locatelerde aliyoruz.
 div[id="Index"]>b:first-of-type  ya da b:last-0f-type, b:nth-of-type(2) yazdik. div icersinde 10 tane b tagi ile baslayan kodu gorduk. Bunlardan birincisini almak istedik
 nth-of-type kullanirken index kullaniyoruz. Hangi indexi istiyorsak sona o numarayi yaziyoruz.
 nth-last-of-type(3) de yazilabilir.
}
*/

