package java8.demo;

import java.util.Optional;

public class DemoOptional {

    static class Commande {
        String numero;
        Client client;

        public Client getClient() {
            return client;
        }
    }

    static class Client {
        String prenom;

        public String getPrenom() {
            return prenom;
        }
    }

    static Commande chercherCommande() {

        Commande commande = new Commande();

        Client client = new Client();

        client.prenom = "Jean";

        commande.client = client;

        //return commande;

        return commande;
    }

    public static void main(String[] args) {

        Commande commande = chercherCommande();

        Optional<Commande> optCommande = Optional.ofNullable(commande);

        //String prenom = optCommande
        //      .map(c -> c.client)
        //      .map(client -> client.prenom)
        //      .orElseGet(() -> "DEFAULT");

        String prenom = optCommande
                .map(Commande::getClient)
                .map(Client::getPrenom)
                .orElseGet(() -> "DEFAULT");

       // String prenom = commande.client.prenom;

        System.out.println(prenom);

    }
}
