# Hintergrund 

Bilder sind zwar schön anzusehen, jedoch sind sie nicht wirklich aussagekräftig was die Grösse und der Umfang des Objektes auf dem Bild angeht.  

Um dies zu vereinfachen, werden wir eine eine Applikation herstellen, mit der man Bilder und deren Metadaten laden und dann vermessen kann: Distanz zwischen zwei Punkten, der Umfang (z.B. einer Zelle) oder allgemein die Länge entlang einem Pfad (z.B. Länge der Wirbelsäule vom Sakrum bis zum Brustkorb), also Polygone. Manchmal sind auch noch Winkel praktisch, z.B. zwischen zwei Fingern oder Wirbelachsen. Die Angaben der Einheiten soll mindestens mm, cm, m und km enthalten und soll inklusive der Beschreibung angezeigt werden. 

Diese Applikation wird für den Kunden hergestellt und soll reibungslos und schnell funktionieren, um lange Wartezeiten zu vermeiden.  

Das Produkt hebt sich von anderen ab, indem es kostengünstiger ist und einfacher in der Handhabung als bereits bestehende Softwarelösungen wie beispielsweise Matlab. 

# Allgemeine Beschreibung
## Anspruchsgruppen

| Benutzer | Benutzt das System | Beschreibung | Repräsentiert von |
|--------------:|:-------------|----------------|:-------------:|
|Benutzer|X       |Der Benutzer kann Bilddateien auswählen, laden und im Fensteranzeigen lassen. Er kann mit der Maus zwei oder mehrere Punkte verbinden. Die erzeugten Pfade durch das verbinden der ausgewählten Punkte, können gemessen werden. Winkel zwischen zwei Pfaden können gemessen werden.         |Studierende, Dozenten       |
|Administrator|X       |Kann die Veränderungen an den zu verfügbar stehenden Daten vornehmen.          |Studierende, Dozenten         |
|Entwickler|        |Gutes erstes Projekt auf erstellen. Verbesserung der Fähigkeiten.          |Studierende        |

## Benutzende und deren Eigenschaften

|Benutzer   | Beschreibung  |
|---|---|
|Angestellte   |Angestellte zwischen 16 und 65 Jahren werden das Programm <br> ausschließlich auf PCs im Büro benutzen.|

## Risiken

Um allfällige Risiken abzudecken sollten die neusten Versionen der Entwicklungsumgebung sowie den Bibliotheken verwendet werden.  

## Resourcen

Zur Entwicklung des Produkts wird die Entwicklung IntelliJ IDEA Community verwendet. Das Knowhows wurde in den Kursen Programmieren II und Software Engineering der FHNW vermittelt. Die benötigten Information um die Software entwickeln zu können, stammen von den Dozenten die zugleich unsere Kunden sind.  

# Funktionale Anforderungen

Das System soll…  

  

Verschiedene .jpg und .png Dateien lesen können. 

Verschiedene .txt und .json Dateien lesen können. 

Die Bilddateien in einem bestimmten Ordner auswählen können und im Fenster darstellen. Die Dimension des Bildes soll sich bei einer Änderung der Fenster Grösse an dieses anpassen. Die Skalierung des Bildes angezeigen. Mit der Maus zwei oder mehrere Punkte mit einer Linie verbinden können 

Die Längen der Linien sowie mögliche Winkel zwischen Linien in metrischen Einheiten berechnen.  

Die berechneten Werte in einem Textfeld darstellen.  

In einem Nachtmodus verfügbar sein. 

Für Bilder ohne Hintergrunddaten die Masseinheit in Pixeln wieder geben.  

# Weitere Anforderungen
## Nicht-funktionale Anforderungen - Welche Qualitäten soll das System aufweisen und wie werden diese überprüft/gemessen?

Zuverlässigkeit: Durch die Benutzererfahrungen und Testläufen während der Entwicklung, soll ein Zuverlässiger Betrieb der Software gewährleistet werden.   

Leistung:  Durch das saubere Arbeit mit dem Code, soll der RAM Verbrauch des Systems nicht überbeansprucht werden. 

Sicherheit: Durch das Benutzen der neusten Software und Bibliotheken werden mögliche Sicherheitslücken geschlossen. 

Wartbarkeit: Das Einhalten der Coding Conventions sorgt für eine gute Wartbarkeit des Systems.  

## Externe Schnittstellen

Softwareschnittstellen: Das System muss in der Lage sein .txt, .json, .png und.jpg Daten lesen zu können. 

