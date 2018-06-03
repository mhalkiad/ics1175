# RDF literals to DB

Η βάση δεδομένων που επέλεξα να αποθηκευτούν τα literals είναι η PostgreSQL (version 9.6.9). Για τον σκοπό αυτό δημιούργησα μία καινούρια βάση με όνομα `ics1175` και σε αυτήν όρισα έναν πίνακα με όνομα `literals` ο οποίος αποτελείται από μόνο ένα column τύπου `text`. Για την εξαγωγή των literals από το RDF αρχείο `output.ttl` χρησιμοποίησα τη βιβλιοθήκη jena-arq (version 3.7). Πιο συγκεκριμένα φόρτωνω το output.ttl σε ένα `Model` έτσι ώστε να μπορώ να το κάνω parse. Στη συνέχεια για όλα τα `Statements` αυτού του model ελέγχω αν υπάρχει literal. Aν κάτι τέτοιο συνέβαινε εισάγω το συγκεκριμένο literal στον πίνακα `literals` της βάσης μέσω ενός `INSERT` SQL query. Για την εκτέλεση αυτού του query έχω συνδεθεί στη βάση χρησιμοποιώντας τον `JDBC` driver της Postgres. Η σύνδεση γίνεται χρησιμοποιώντας τον default χρήστη της Postgres (username: postgres, password: postgres) στην πόρτα 5432.

To export της βάσης υπάρχει στο αρχείο [`ics1175.sql`](https://github.com/mhalkiad/ics1175/blob/master/rdf2db/ics1175.sql)

Εκτέλεση:

`java -jar rdf2db.jar output.ttl`
