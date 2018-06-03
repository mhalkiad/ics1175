# Web service

Για την υλοποίηση του web service χρησιμοποίησα το Java API for XML Services (JAX-WS 2.2). O web server που χρησιμοποίησα είναι ο Apache Tomcat 8.0.27. To web service έχει ένα μόνο operation (το searchTerm) που δέχεται ως είσοδο τον όρο που θέλουμε να αναζητήσουμε και επιστρέφει το string representation ενός `JSONArray`. Η επιλογή του JSON Array ως επιστρεφόμενου τύπου έγινε για να μπορεί να γίνει ευκολότερα το deserialization σε ένα web client. Για την εξαγωγή των literals από τη βάση, εκτελώ μέσω `JDBC Connection` ένα SQL `SELECT` query στον πίνακα literals όπου στο `WHERE` clause του ελέγχω για την ύπαρξη του όρου. Πιο συγκεκριμένα χρησιμοποιώ το keyword `ILIKE` της Postgres με το οποίο μπορούν να γίνουν match case-insensitive χαρακτήρες, το οποίο και έχει λογική σε μια διαδικασία αναζήτησης.


Ο web service client είναι ένα Maven Java application που ζητάει από το χρήστη τον όρο αναζήτησης, ελέγχει αν είναι ίσο ή παραπάνω από τρεις χαρακτήρες και στη συνέχεια καλεί το web service operation, το οποίο επιστρέφει τα literals στα οποία εμφανίζεται ο όρος.

Εκτέλεση:

Το web service γίνεται deploy στον Apache Tomcat. Ο web client τρέχει με την εντολή:

`java -jar ICS1175AppClient.jar`
