# Java IOs

## Comparaison des méthodes de lecture-écriture  

### 1 Byte

| Implémentation      | Temps d'écriture moyen (ms) | Temps de lecture moyen (ms) |
|---------------------|-----------------------------|-----------------------------|
| BINARY              | 165.1                       | 176.3                       |
| BUFFERED_BINARY     | 165.6                       | 160.1                       |
| TEXT                | 166.5                       | 168.0                       |
| BUFFERED_TEXT       | 169.5                       | 171.9                       |

### 1024 Bytes

| Implémentation      | Temps d'écriture moyen (ms) | Temps de lecture moyen (ms) |
|---------------------|-----------------------------|-----------------------------|
| BINARY              | 169.4                       | 169.4                       |
| BUFFERED_BINARY     | 171.2                       | 165.5                       |
| TEXT                | 178.9                       | 177.0                       |
| BUFFERED_TEXT       | 187.4                       | 182.6                       |

### 1 MB

| Implémentation      | Temps d'écriture moyen (ms) | Temps de lecture moyen (ms) |
|---------------------|-----------------------------|-----------------------------|
| BINARY              | 2548.2                      | 1321.4                      |
| BUFFERED_BINARY     | 204.8                       | 200.5                       |
| TEXT                | 309.6                       | 318.4                       |
| BUFFERED_TEXT       | 207.0                       | 202.6                       |

### 5 MB

| Implémentation      | Temps d'écriture moyen (ms) | Temps de lecture moyen (ms) |
|---------------------|-----------------------------|-----------------------------|
| BINARY              | 11035.0                     | 5441.2                      |
| BUFFERED_BINARY     | 261.4                       | 254.2                       |
| TEXT                | 441.0                       | 444.6                       |
| BUFFERED_TEXT       | 289.0                       | 274.3                       |





### Which type of stream is the most efficient for each use case?

Pour le temps d'écriture moyen, la méthode binaire est plus efficace.  
Selon le benchmark, la version sans buffer est plus efficace sur de petit fichier (1 à 1024).
Dès que le fichier devient plus conséquent, la version avec buffer est nettement plus efficace.  
En lecture, le binaire avec buffer est le plus efficace.

### Why is it more efficient than the other types of streams?  
La méthode binaire avec buffer lis les données en plus grand bloc que le binaire.
Par rapport au texte, on gagne en vitesse car pas d'encodage/décodage du pour avoir le format texte.
### What is the difference between binary data and text data?  
Chaque byte doit être traduit pour donner du texte.
### What is a character encoding?
C'est une mapping entre un byte et un caractère 
### Why is this benchmark methodology important?
Pour comparer les différents outils à notre disposition et choisir le plus efficaces

PS: J'ai utilisé le script run_benchmark de la solution [ici](https://github.com/heig-vd-dai-course/heig-vd-dai-course-solutions/blob/main/05-java-ios/run_benchmarks.sh).