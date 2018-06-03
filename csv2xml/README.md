Για τη μετατροπή του αρχείου `data.csv` σε xml μορφή χρησιμοποίησα την Apache Commons-csv (version 1.4) βιβλιοθήκη για να μπορέσω να κάνω parse το csv αρχείο.
Φτιάχνω ένα root element και για κάθε record του csv αρχείου φτιάχνω ένα fish element. Κάθε fish element έχει τα εξής sub elements: `ScientificName`, `Country`,  `WaterArea`, και `CommonName`. Τέλος, δημιουργώ το xml αρχείο με όνομα `output_template.xml`.
 
Εκτέλεση:
`java -jar csv2xml.jar  data.csv`
