package com.currencyconverter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CurrencyService {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Set<String> SUPPORTED_CURRENCIES = new HashSet<>() {{
        add("USD");
        add("BRL");
        add("EUR");
        add("GBP");
        add("JPY");
        add("AUD");
        add("CAD");
    }};

    public double convert(double amount, String fromCurrency, String toCurrency) throws IllegalArgumentException, IOException {
        if (amount <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero");
        }
        
        if (!isValidCurrency(fromCurrency) || !isValidCurrency(toCurrency)) {
            throw new IllegalArgumentException("Moeda não suportada. Use: " + String.join(", ", SUPPORTED_CURRENCIES));
        }

        try {
            // Get current exchange rates
            JsonNode rates = getExchangeRates();
            
            // Get conversion rates
            double fromRate = rates.path(fromCurrency).asDouble(0);
            double toRate = rates.path(toCurrency).asDouble(0);
            
            if (fromRate == 0 || toRate == 0) {
                throw new IOException("Taxa de câmbio não disponível para as moedas especificadas");
            }
            
            // Calculate and return the converted amount
            return (amount / fromRate) * toRate;
            
        } catch (IOException e) {
            throw new IOException("Erro ao converter moedas: " + e.getMessage(), e);
        }
    }

    private boolean isValidCurrency(String currency) {
        return currency != null && SUPPORTED_CURRENCIES.contains(currency);
    }

    private JsonNode getExchangeRates() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new IOException("Falha na requisição. Código: " + statusCode);
                }
                
                String responseBody = EntityUtils.toString(response.getEntity());
                if (responseBody == null || responseBody.trim().isEmpty()) {
                    throw new IOException("Resposta vazia da API de câmbio");
                }
                
                JsonNode rootNode = objectMapper.readTree(responseBody);
                JsonNode rates = rootNode.path("rates");
                
                if (rates.isMissingNode()) {
                    throw new IOException("Formato de resposta inválido da API de câmbio");
                }
                
                return rates;
            }
        } catch (Exception e) {
            throw new IOException("Erro ao obter taxas de câmbio: " + e.getMessage(), e);
        }
    }
}
