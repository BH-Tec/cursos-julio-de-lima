package br.com.brunodorea.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Automatizados da Funcionalidade de Sign Up")
public class SignUpTests {
    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos() {
        // Abrir o Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        // Abrir o site TaskIt
        navegador.get("http://www.juliodelima.com.br/taskit/");

        // Clicar no botão que tem o ID = 'signup'
        navegador.findElement(By.id("signup")).click();

        // Digitar o nome = name-sign-up, login = login-sign-up, senha = password-sign-up e clicar no botão save = btn-submit-sign-up
        navegador.findElement(By.id("name-sign-up")).sendKeys("Bruno Henrique");
        navegador.findElement(By.id("login-sign-up")).sendKeys("brunohenrique123456789");
        navegador.findElement(By.id("password-sign-up")).sendKeys("123456789");
        navegador.findElement(By.id("btn-submit-sign-up")).click();

        // Validar se texto 'Hi,' foi apresentado no elemento = me
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi,", saudacaoAtual);

        // Fechar o navegador
        navegador.quit();
    }
}
