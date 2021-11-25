package com.codecool.shop;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.IOException;

public class ProductServiceTest {

    @Test
    void getProductCategory_serverDown_throwsIOException() throws IOException {
        /*StockAPIService stockAPIService = new StockAPIService("");
        RemoteURLReader mockedRUR = Mockito.mock(RemoteURLReader.class);
        Mockito.when(mockedRUR.readFromUrl("")).thenThrow(IOException.class);
        Assertions.assertThrows(IOException.class, () -> stockAPIService.getPrice("", mockedRUR));*/
    }

}
