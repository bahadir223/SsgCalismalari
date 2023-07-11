import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ssg_GetMetotlari extends TestBase {

    @Test
    public void test01() {/*
        Test Görevi:
        https://www.kitapyurdu.com/ adresine gidiniz.
        Anasayfanın açıldığını sayfa URL'si ile doğrulayınız.
        Anasayfanın açıldığını sayfa başlığı ile doğrulayınız. (Kitapyurdu, Kitapla buluşmanın en kolay yolu)
        Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
                Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        "Üye Ol" butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
        Haffont-familytanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
        quit() ve close() metotları arasındaki farkı inceleyelim.
     */
//        https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");

//        Anasayfanın açıldığını sayfa URL'si ile doğrulayınız.
        Assert.assertEquals("https://www.kitapyurdu.com/", driver.getCurrentUrl());
        //Anasayfanın açıldığını sayfa başlığı ile doğrulayınız. (Kitapyurdu, Kitapla buluşmanın en kolay yolu)
        Assert.assertEquals("Kitapyurdu, Kitapla buluşmanın en kolay yolu", driver.getTitle());
//Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
        Assert.assertTrue(driver.getPageSource().contains("Haftanın Yayınevi"));
        Assert.assertTrue(driver.getPageSource().contains("En Çok Satılanlar"));
        Assert.assertTrue(driver.getPageSource().contains("Ayın Yayınevleri"));

//Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        WebElement girisYap = driver.findElement(By.xpath("//*[.='Giriş Yap']"));
        Assert.assertEquals("Giriş Yap", girisYap.getText());

        //  "Üye Ol" butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        WebElement uyeOl = driver.findElement(By.linkText("Üye Ol"));
        System.out.println("uyeOl.getText() = " + uyeOl.getText());
        String uyeOlAttribute = uyeOl.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlAttribute);

//En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        List<WebElement> yazarIsmi = driver.findElements(By.cssSelector("[class='author line-clamp-2']"));
        for (WebElement w : yazarIsmi) {
            Assert.assertEquals("span", w.getTagName());

        }
        //       En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.

        for (WebElement w : yazarIsmi) {
            Assert.assertEquals("Arial, Helvetica, sans-serif", w.getCssValue("font-family"));

            // Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunun doğrulanması
            WebElement kurtulusGunu = driver.findElement(By.xpath("//img[@alt=\"Kurtuluş Günü\"]"));

            Assert.assertEquals(120, kurtulusGunu.getSize().getWidth());
            Assert.assertEquals(174, kurtulusGunu.getSize().getHeight());

        }
    }
}
