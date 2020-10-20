package ru.testing.yandex.tests;

import org.testng.annotations.DataProvider;
import ru.testing.yandex.model.Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders extends TestBase{
    @DataProvider
    public Iterator<Object[]> search() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/searchParams.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new Search().setPriceFrom(split[0]).setPriceTo(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}