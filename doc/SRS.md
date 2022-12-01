# Hintergrund 

Bilder sind zwar schön anzusehen, jedoch sind sie nicht wirklich aussagekräftig was die Grösse und den Umfang des Objektes auf dem Bild angeht.  

Um dies zu vereinfachen, werden wir eine eine Applikation herstellen, mit der man Bilder und deren Metadaten laden und dann vermessen kann: Distanz zwischen zwei Punkten, den Umfang (z.B. einer Zelle) oder allgemein die Länge entlang einem Pfad (z.B. Länge der Wirbelsäule vom Sakrum bis zum Brustkorb), also Polygone. Manchmal sind auch noch Winkel praktisch, z.B. zwischen zwei Fingern oder Wirbelachsen. Die Angaben der Einheiten soll mindestens mm, cm, m und km enthalten und soll inklusive der Beschreibung angezeigt werden. 

Diese Applikation wird für den Kunden hergestellt und soll reibungslos und schnell funktionieren, um lange Wartezeiten zu vermeiden.  

Das Produkt hebt sich von anderen ab, indem es kostengünstiger und einfacher in der Handhabung als bereits bestehende Softwarelösungen wie beispielsweise Matlab ist. 

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

Das System soll: 

    3. Die Bilddateien in einem bestimmten Ordner auswählen können und im Fenster darstellen. Die Dimension des Bildes soll sich bei einer Änderung der Fenster Grösse an dieses anpassen. Die Skalierung des Bildes angezeigen. Mit der Maus zwei oder mehrere Punkte mit einer Linie verbinden können.

    4. Die Längen der Linien sowie mögliche Winkel zwischen Linien in metrischen Einheiten berechnen.  

    5. Die berechneten Werte in einem Textfeld darstellen.  

    6. In einem Nachtmodus verfügbar sein. 

    7. Für Bilder ohne Hintergrunddaten die Masseinheit in Pixeln wieder geben.  

# Weitere Anforderungen
## Nicht-funktionale Anforderungen

    Prio 1:

    1. Metadaten (Metrik, Beschreibung, Bilddatei, etc.) sollen aus Textdatei pro Bild (.txt) gelesen werden.

    2. Unter anderem soll das System  die unterstützten Bilddateitypen: .jpg, .png lesen können. 

    3. Auflösung, Folgende Einheiten müssen mindestens unterstütz werden: mm, cm, m, km
    
    4. Wenn Auflösung in Metadaten fehlt, wird als Einheit 'px' (pixel) angezeigt.
    
    5. Format muss -agnostisch, d.h. Bilder dürfen nicht verzerrt dargestellt werden.
    
    6. GUI muss mit JavaFX programmatisch (d.h. ohne visuelle Layout Tools wie Scene Builder) implementiert werden.

    7. 3-Schichten Architektur (damit die Logik-Klassen auch unabhängig vom GUI wiederverwendet werden können).

    8. Keine zusätzlichen Bibliotheken erlaubt ausser zum Lesen der JSON Daten.

    9. Die Applikation soll bei einem Gebrauch von einer Stunde nicht mehr als ein mal abstürzen.

  Prio 2:
    
    1. Profil der Bilddaten entlang einer Linie (z.B. um Höhenmodelle analysieren zu können; könnte komplex werden:
        wie wird z.B. auf dem Bild mit der Schweizer Topokarte entschieden, wie gross der Höhenunterschied zwischen den
        Farben ist?)
    2. 3D Dateien lesen können.


    

## Externe Schnittstellen

    1. Softwareschnittstellen: Das System muss in der Lage sein .txt, .json, .png und.jpg Daten lesen zu können. 

