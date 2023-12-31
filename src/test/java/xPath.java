import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class xPath extends TestBase {

    @Test
    public void xpathTestleri() {
        driver.get("https://theautomationzone.blogspot.com/2020/07/xpath-practice.html");

        // XPATH Basics
        System.out.println(driver.findElement(By.xpath("//*[@id='id1']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@name='name1']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@value='value1']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[@class='class1']")).getText());

        System.out.println(driver.findElement(By.xpath("//p[@name='a' and @id='a']")).getText());

        System.out.println(driver.findElement(By.xpath("//p[text()='unique id']")).getText());

        driver.findElement(By.xpath("//div[@id='divA']/*"));
        driver.findElement(By.xpath("//div[@id='divA']/input"));
        driver.findElement(By.xpath("//div[@id='divC']/span/input"));
        driver.findElement(By.xpath("//div[@id='divC']//input[@type='text']"));

        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'logged in')]")));
        System.out.println(driver.findElement(By.xpath("//p[starts/with(text(),'logged in')]")));
        System.out.println(driver.findElement(By.xpath("(//label[@id='lable'])[last()]")));

    }
}
/*
    the automation zone website: x-path ile ilgili uygulamalari buradan bulabiliriz.

XPath:
// sonrasi ya * ya da tagName kullaniriz. tagName kullanmak hiz acisindan daha dogru olur. Dogrudan ismini verdigimiz ilgili tag name'e bakar.
* kullanirsak tum tag ve onlarin attribute'lerini arar.

//*[@Attribute='Value']
//tagName[@Attribute='Value']

id ve degerini x-path ile alirken uc kere o bolume basinca tumunu alir.

Eger bir attribute aliyorsak basina @ isaretini koymaliyiz. Attribute degilse basa @ eklemeye gerek yok. Bazen bir deger icerisinde tek tirnak varsa x-path ile locate almaya engel
oluyor. Cunku degerin bas ve sonuna tek tirnak koyuyoruz ve onunla karisiyor. Boyle olunca degeri bas ve sonundan tek tirnak degil cift tirnak icine almak yeterli olur.

Bazen className ile locate alirken deger olan yazi icinde ikili yazilar olup arada bosluk varsa locate alamayabiliriz. Baska bir locator ile locate alabiliriz.
Bazen tagname yerine yildiz isareti yazinca attribute ile degeri ayni olan baska taglara da bakar ve yavaslama olmus olur.

and / or ile birden fazla attribute'u almamiz mumkundur.
2 ve ya 3 tane ayni tag, ayni attribute ancak degeri farkli olan HTML kodunda hangisini almaliyiza bakmaliyiz. index almadan or veya and ile unique olarak locate'i alabilirsek indexten
daha guvenli olur. Cunku index numarasi degisebilir.

 Bazen and ve or'u attribute'un icinde oldugu parantez icerisinde bazen de parantez disinda kullanabiliriz.

 Bir texti locate'de almaya ornek: //p[text()='unique id'] Burada @ isaretini kullanmadik. text alma methodu faydali bir methoddur. Bir metin bir sitede genellikle tekrar etmez.
 tekrar etmeyen yani unique olani ariyorsak text methodunu kullanmamiz daha dogru olur.

 XPath with parent/child

 //tagName[@Attribute='Value']/tagName/tagName  ilk tagName bolumu Parent, ikincisi, ucuncusu Child
 //tagName[@Attribute='Value']//tagName ilk tagName bolumu Parent, ikincisi Child

 //input[@type="text"] 11 tane oldugunu gorduk. Bunlari HTML kodlari sayfasinda tek tek inceledik. Farklarini gorduk. Parent'ini bulduk. div'e ait bir child oldugunu anladik.
 //div[@id="divC"]/input yani parent ve child'i dogrudan yazdik. Ancak dogrudan child degil, child'in child'i ise ki biz input'un span'in dogrudan child'i oldugunu anladik.
 //div[@id="divC]/span/input yeter ki child ya da grandchild olsun.
 //div[@id="divC"]//input[@type='text'] yazinca sonucta unique'a ulastik. Parent ve child tek basina alininca aralarina //, alacagimiz attribute dogrudan child'i degilse aralara
 tek slash yaziyoruz.

 indexler kolayca degisebilir. Genellikle attribute degistirilmiyor. Bu nedenle index ile almayi aliskanlik haline getirmeyelim.

 //p[@name="a"][1] baska turlu locate alamadigimzda bu sekilde index ile alabiliriz.
 //label[@id="lable"][1] yazinca 1 of 3 oldu. Unique degil. bir ustte locate'i alirken birden fazla idi ancak ayni parent icinde oldugundan parantez icine almadan [1] indexi
 kullandik. Burada ise parentez icine alirsak 1 0f 3'den 1 of 1'e yani unique olana gecer. (//label[@id="lable"])[1]

 Copy Full xpath bize uzun yazilacak bir kod veriyor. Cok sayida div arka rakaya siralaniyor. div[2]/div[2]/div[2]/div[2]/div[4]..... uzunca devam eder. HTML basindan sonuna kadar tag ne
 ise ilgili tag ve indexleri uzunca siralanir. Bu absolute xpath'e ornektir.  Ornegimizde tagimiz div idi.

 Bazi developerlar dinamik id, dinamik webelement kullanir. Dinamik degisken degerler demektir. Yani degismelere aciktir.
 Bir random butonuna basinca verilen isimler degisir. Ornek Tom daha sonra Lary olarak isim degisir. Ancak degismeyen degerler olabilir. Ornegin logged in successfully.

 Xpath with contains:
 //tagName[contains(arananOge, arananOgeAdresi]
 //p[contains(,)] virgul basina istersek text() virgul sonrasina 'logged in')] yazabiliriz.
 strats-with --> basindaki degere bakar
 //tagName[starts-with(arananOge, arananOgeAdresi]
 //p[starts-with(text(),'logged in')]

 //input[@type="text"] 11 tane oldugunu gorduk. Parantez icine alip[2] olarak indexi ekleyince unique olur. Ancak sondaki indexi alacaksak index numarasi kullanmak yerine
 [last()] yazinca son indexi developer silse dahi problem olmaz. hatta burada [last()-1] deyince bizi birinci index'e [last()-2] yazinca bizi yine birinciye goturdu. Sayiyi
 bilmedigimiz durumlarda last() kullanmak dogru olur.

 */

