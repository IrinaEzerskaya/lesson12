package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class BillBuilder {

    public static void main(String[] args) {

        ArrayList<String> productNames = new ArrayList<String>();
        ArrayList<Float> productQuantity = new ArrayList<Float>();
        ArrayList<Float> productPrice = new ArrayList<Float>();

        String inputLine;

        BufferedReader reader;
        // Читаем исходный файл
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Temp\\products.txt"
            ));

            // Контроль целостности данных (порядка следования строк) не производится
            do {
                // Читаем блоками по три строки (согласно ТЗ)
                inputLine = reader.readLine();
                // Первая строка - ожидаем название товара
                if (inputLine != null) {
                    //System.out.println(inputLine);
                    productNames.add(inputLine);
                }
                // Вторая строка - ожидаем получить кол-во товара
                inputLine = reader.readLine();
                if (inputLine != null) {
                    //System.out.println(inputLine);
                    productQuantity.add(Float.parseFloat(inputLine));
                }

                // Третья строка - ожидаем получить цену товара
                inputLine = reader.readLine();
                if (inputLine != null) {
                    //System.out.println(inputLine);
                    productPrice.add(Float.parseFloat(inputLine));
                }

            } while(inputLine != null);

            reader.close();

            System.out.println("Наименование        Цена   Кол-во    Стоимость\n" +
                    "===============================================");
            // Открываем цикл по импортированным их файла записям
            Iterator<String> pName = productNames.iterator();
            Iterator<Float> pQuantity = productQuantity.iterator();
            Iterator<Float> pPrice = productPrice.iterator();

            Double total = 0.0;
            while (pName.hasNext()) {
                Float price = pPrice.next();
                Float quant = pQuantity.next();
                Float summ = price * quant;
                total += summ;

                System.out.printf("%-18s %6.2f x %6.3f  =%8.2f\n", pName.next(), price, quant, summ);
            }

            System.out.println("===============================================");
            System.out.printf("Итого:                              =%8.2f\n", total);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
