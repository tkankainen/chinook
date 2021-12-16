
Sijainti                                | Tarkoitus
----------------------------------------|---------------------
[README.md](README.md)                                                  | Tämä tiedosto
[pom.xml](pom.xml)                                                      | "[Project Object Model](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)"-tiedosto mm. riippuvuuksien määrittelemiseksi
[src/main/java](src/main/java)                                          | Java-pakettien juurihakemisto
[src/main/resources](src/main/resources)                                | Hakemisto esimerkiksi .properties-tiedostoille
[src/main/java/launch/Main.java](src/main/java/launch/Main.java)        | Luokka Tomcat-palvelimen käynnistämiseksi
[src/main/java/servlet/IndexServlet.java](src/main/java/servlet/IndexServlet.java) | Esimerkki HTTP-liikennettä tukevasta Java-luokasta
[src/main/webapp](src/main/webapp)                                      | Hakemisto staattisille tiedostoille (css, kuvat, JS)
[src/main/webapp/WEB-INF](src/main/webapp/WEB-INF)                      | Erityinen hakemisto, jonne on estetty suora pääsy selaimilta ¹
[src/main/webapp/WEB-INF/index.jsp](src/main/webapp/WEB-INF/index.jsp)  | IndexServlet-luokan käyttämä sivupohja
[src/test/java](src/test/java)                                          | JUnit-testiluokkien pakettien juurihakemisto
[src/test/java/servlet/IndexServletTest.java](src/test/java/servlet/IndexServletTest.java)  | IndexServlet-luokan JUnit-testit
[src/test/java/testserver/TestServer.java](src/test/java/testserver/TestServer.java)  | Apuluokka palvelimen testaamiseksi
[src/test/resources](src/test/resources)                                | Hakemisto esimerkiksi testien .properties-tiedostoille
