package NBPAPI;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Main {


    public static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>(Arrays.asList("USD", "EUR", "CHF", "GBP"));

        for (String exchangeList : list) {


            ExchangeRates rates = downloadRates(exchangeList);

            System.out.println(rates.currency);


            System.out.println("Kurs kupna: ");
            Double askRates = rates.rates[0].getAsk();
            System.out.println(askRates);
            System.out.println("Kurs sprzedaży: ");
            Double bidRates = rates.rates[0].getBid();
            System.out.println(bidRates);
            System.out.println("Wartość 100 zł w walucie to :");
            Double bid = 100 / bidRates;
            System.out.println(bid);
            System.out.println("Wartość 100 zł po wymianie: ");
            System.out.format("%.2f%n", bid);

        }
    }

    public static ExchangeRates downloadRates(String urlRates) throws IOException {
        ;
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + urlRates + "/today/?format=json)");

        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        InputStream is = connection.getInputStream();
        try (Scanner scanner = new Scanner(is)) {
            String lines = scanner.nextLine();
            return GSON.fromJson(lines, ExchangeRates.class);
        }
    }

    public static Rates downloadRatesExchange(String urlRates) throws IOException {
        ;
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + urlRates + "/today/?format=json)");

        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        InputStream is = connection.getInputStream();
        try (Scanner scanner = new Scanner(is)) {
            String lines = scanner.nextLine();
            return GSON.fromJson(lines, Rates.class);
        }
    }
}
