# Hintergrund 

Bilder sind zwar schön anzusehen, jedoch sind sie nicht wirklich aussagekräftig was die Grösse und den Umfang des Objektes auf dem Bild angeht.  

Um dies zu vereinfachen, werden wir eine eine Applikation herstellen, mit der man Bilder und deren Metadaten laden und dann vermessen kann: Distanz zwischen zwei Punkten, den Umfang (z.B. einer Zelle) oder allgemein die Länge entlang einem Pfad (z.B. Länge der Wirbelsäule vom Sakrum bis zum Brustkorb), also Polygone. Manchmal sind auch noch Winkel praktisch, z.B. zwischen zwei Fingern oder Wirbelachsen. Die Angaben der Einheiten soll mindestens mm, cm, m und km enthalten und soll inklusive der Beschreibung angezeigt werden. 

Diese Applikation wird für den Kunden hergestellt und soll reibungslos und schnell funktionieren, um lange Wartezeiten zu vermeiden.  

Das Produkt hebt sich von anderen ab, indem es kostengünstiger und einfacher in der Handhabung als bereits bestehende Softwarelösungen wie beispielsweise Matlab ist. 

# Allgemeine Beschreibung
## Anspruchsgruppen

| Benutzer | Benutzt das System | Beschreibung | Repräsentiert von |
|--------------:|:-------------|----------------|:-------------:|
|Anwender|X       |Verwenden die Applikation um bei der Arbeit Objekte auf Bildern vermessen zu lassen. |Studierende, Kunden       |
|Entwickler|        |Gutes erstes Projekt erstellen. Verbesserung der Fähigkeiten.          |Studierende        |

## Benutzende und deren Eigenschaften

|Benutzer   | Beschreibung  |
|---|---|
|Angestellte   |Angestellte zwischen 16 und 65 Jahren werden das Programm <br> ausschließlich auf PCs im Büro benutzen.|




## Risiken

Es besteht das Risiko, dass wir mit den für uns neuen Tools Maven und Gitlab nicht effizient arbeiten.
Es besteht weiter das Risiko, dass wir aufgrund mangelnder Erfahrung zu viel Zeit für das Programmieren brauchen.
Um zu verhindern, dass wir dadurch mit unseren Tasks in Verzug geraten, werden wir regelmässig Rücksprache mit den Dozierenden oder Applikationsentwicklern halten.  

## Resourcen

Zur Entwicklung des Produkts wird die Entwicklung IntelliJ IDEA Community verwendet. Das Knowhows wurde in den Kursen Programmieren II und Software Engineering der FHNW vermittelt. Die benötigten Information um die Software entwickeln zu können, stammen von den Dozenten die zugleich unsere Kunden sind.  

# Funktionale Anforderungen

Das System soll: 

  Prio 1:
    
    1. Eine Bilddatei in einem bestimmten Ordner auswählen können
    
    2. Die gewählte Bilddatei im Fenster darstellen:
      2.1. Die Skalierung des Bildes angezeigen.
      
    3. Mit der Maus zwei oder mehrere Punkte mit einer Linie verbinden können.

    4. Die berechneten Werte in einem Textfeld darstellen:
      4.1. Die Längen der Linien in Anzahl Pixel anzeigen
      4.2. Falls Metadaten vorliegen, die Längen der Linien in metrischen Einheiten anzeigen
      4.3. Falls zwei Linien gewählt werden, den Winkel zwischen diesen zwei Linien anzeigen
      4.4. Die Längen mehrerer verbundenen Linien summieren können (als Umfang).
    
  Prio 2:
  
    1. Die Dimension des Bildes soll sich bei einer Änderung der Fenster Grösse an dieses anpassen.

    2. Mehrere Farben und Dicken für die Linien zur verfügung stellen.

    3. In einem Nachtmodus verfügbar sein.

    4. Profil der Bilddaten entlang einer Linie (z.B. um Höhenmodelle analysieren zu können)
    

# Weitere Anforderungen
## Nicht-funktionale Anforderungen

    Prio 1:

    1. GUI muss mit JavaFX programmatisch (d.h. ohne visuelle Layout Tools wie Scene Builder) implementiert werden.

    2. 3-Schichten Architektur (damit die Logik-Klassen auch unabhängig vom GUI wiederverwendet werden können).

    3. Keine zusätzlichen Bibliotheken erlaubt ausser zum Lesen der JSON Daten.
    
    4. Unterstützte Bilddateitypen: .jpg, .png

    5. Metadaten (Metrik, Beschreibung, Bilddatei, etc.) aus Textdatei pro Bild von .txt und .json auslesen können.

    6. Unterstütze Einheiten: mm, cm, m, km
   
    7. Formatagnostisch: Bilder dürfen nicht verzerrt dargestellt werden.

    8. MTBF: 6 Stunden (Applikation soll bei einem Gebrauch von einer Stunde nicht mehr als ein mal abstürzen)

  

    

## Externe Schnittstellen

    1. Softwareschnittstellen: Das System muss in der Lage sein .txt, .json, .png und.jpg Daten lesen zu können.



