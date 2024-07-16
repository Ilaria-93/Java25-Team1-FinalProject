# Java25-Team1-FinalProject

# **Sistema di gestione bancaria online**

## **Titolo progetto:**
“My SecureBank Wallet”

**Descrizione del progetto:**
Un'applicazione web per la gestione bancaria online che consente ai clienti di gestire i propri conti
bancari, effettuare transazioni, e visualizzare estratti conto in modo sicuro e conveniente.

**Case Study:**
Una banca chiamata "SecureBank Online" vuole offrire ai suoi clienti un servizio di banking online
completo e sicuro. Attualmente, i clienti devono recarsi in filiale o utilizzare un sito web obsoleto
per gestire i loro conti. Con l'applicazione "SecureBank Online", i clienti possono accedere
facilmente ai loro conti, visualizzare estratti conto, effettuare bonifici e pagamenti vari, tutto in un
ambiente sicuro con autenticazione a due fattori, migliorando la comodità e la sicurezza delle
operazioni bancarie.

**Entità coinvolte:**
Clienti banca (Area Clienti), dipendenti banca (differente dominio):
Cliente: può accedere ai suoi conti, effettuare operazioni bancarie, gestione personale (cambio PIN
e password), sicurezza autenticazione (2FA).
Dipendente: può accedere ai conti dei vari clienti, effettuare operazioni bancarie su mandato dei
clienti, effettuare operazioni amministrative (es. aprire/chiudere un conto, prestiti), può aggiornare i
dati dei clienti

**Caratteristiche principali:**
*  Registrazione e login degli utenti
*  Visualizzazione del saldo e degli estratti conto
*  Effettuazione di bonifici e pagamenti
*  Gestione dei conti correnti, risparmi e carte di credito
*  Notifiche via email e SMS per transazioni e avvisi di sicurezza
*  Sistema di autenticazione a due fattori per la sicurezza (Opzionale)

**Tecnologie da utilizzare:**
*  Backend: Java, Spring Boot
*  Database: MySQL
*  Autenticazione: Spring Security per la gestione della sicurezza
*  API: RESTful API per comunicazioni tra frontend e backend
*  Testing: JUnit per i test unitari e di integrazione
*  Notifiche: JavaMail per email (Twilio per SMS)
*  Sicurezza: Implementazione di autenticazione a due fattori (2FA) (Opzionale)
