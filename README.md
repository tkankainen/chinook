Harjoitustyö Ohjelmointi 2 -kurssille

Projektipohjana käytetty [https://github.com/ohjelmointi2/embedded-tomcat-template](https://github.com/ohjelmointi2/embedded-tomcat-template)

Tiedosto	                            | Tarkoitus
----------------------------------------|---------------------
[README.md](README.md)                                                  | Tämä tiedosto
[pom.xml](pom.xml)                                                      | Project Object Model-tiedosto mm. riippuvuuksien määrittelemiseksi
[src/main/java](src/main/java)                                          | Java-pakettien juurihakemisto
[src/main/java/launch/Main.java](src/main/java/launch/Main.java)        | Luokka Tomcat-palvelimen käynnistämiseksi
[src/main/java/database/Database.java](src/main/java/database/Database.java) 		| Luokka yhteyksien luomista varten
[src/main/java/database/AlbumDao.java](src/main/java/database/AlbumDao.java) 		| DAO-luokka albumeihin liittyviä operaatioita varten
[src/main/java/database/ArtistDao.java](src/main/java/database/ArtistDao.java) 		| DAO-luokka artisteihin liittyviä operaatioita varten
[src/main/java/servlet/IndexServlet.java](src/main/java/servlet/IndexServlet.java) | HTTP-liikennettä tukeva Java-luokka kotisivua ja hakutuloksia varten
[src/main/java/servlet/AlbumListServlet.java](src/main/java/servlet/AlbumListServlet.java) | HTTP-liikennettä tukeva Java-luokka albumeihin liittyviä toimintoja varten
[src/main/java/servlet/ArtistListServlet.java](src/main/java/servlet/ArtistListServlet.java) | HTTP-liikennettä tukeva Java-luokka artisteihin liittyviä toimintoja varten
[src/main/java/model/Album.java](src/main/java/model/Album.java) 		| Model-luokka Albumin tietoja varten
[src/main/java/model/Artist.java](src/main/java/model/Artist.java) 		| Model-luokka Artistin tietoja varten
[src/main/webapp/WEB-INF/index.jsp](src/main/webapp/WEB-INF/index.jsp)  | IndexServlet-luokan käyttämä sivupohja
[src/main/webapp/WEB-INF/searchResults.jsp](src/main/webapp/WEB-INF/searchResults.jsp)  | Sivupohja hakutuloksia varten
[src/main/webapp/WEB-INF/artistList.jsp](src/main/webapp/WEB-INF/artistList.jsp)  | ArtistListServlet-luokan käyttämä sivupohja
[src/main/webapp/WEB-INF/albumList.jsp](src/main/webapp/WEB-INF/albumList.jsp)  | AlbumListServlet-luokan käyttämä sivupohja
[src/test/java](src/test/java)                                          | JUnit-testiluokkien pakettien juurihakemisto
[src/test/java/servlet/ServletTest.java](src/test/java/servlet/ServletTest.java)  | AlbumListServlet-, ArtistListServlet- ja IndexServlet-luokkien JUnit-testit
[src/test/java/testserver/TestServer.java](src/test/java/testserver/TestServer.java)  | Apuluokka palvelimen testaamiseksi
[git-log.txt](git-log.txt)												| Lista tehdyistä commiteista
